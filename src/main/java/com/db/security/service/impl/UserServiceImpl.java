package com.db.security.service.impl;

import com.db.security.config.DataSourceContextHolder;
import com.db.security.config.DatasourceType;
import com.db.security.mapper.LocationMapper;
import com.db.security.mapper.UserMapper;
import com.db.security.model.LocationEntity;
import com.db.security.model.UserRequestEntity;
import com.db.security.repository.LocationRepository;
import com.db.security.repository.UserRequestRepository;
import com.db.security.response.LocationResponse;
import com.db.security.request.UserRequest;
import com.db.security.response.UserResponse;
import com.db.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final LocationRepository locationRepository;
    private final UserMapper userMapper;
    private final UserRequestRepository userRequestRepository;
    private final DataSourceContextHolder dataSourceContextHolder;
    private final LocationMapper locationMapper;

    @Override
    public void addUser(UserRequest request) {
        dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        UserRequestEntity entity = userMapper.toEntity(request);
        if (!Objects.isNull(request.getLocationId())) {
            LocationEntity location = locationRepository.findById(request.getLocationId()).orElse(null);
            entity.setLocation(location);
        }
        userRequestRepository.save(entity);
    }

    @Override
    public List<LocationResponse> getListLocation() {
        dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        return locationRepository.findAll().stream().map(locationMapper::toResponse).toList();
    }

    @Override
    public UserResponse getUser(String passportId) {
        return userMapper.toResponse(userRequestRepository.findByPassportId(passportId));
    }

    @Override
    public List<UserResponse> getAllUser(String username) {
        return userRequestRepository.findAll().stream().map(userMapper::toResponse).toList();
    }

    @Transactional
    @Override
    public void modifyUser(long id, int value) {
        dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        UserRequestEntity entity = userRequestRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setIsAuthenticated(value);
        userRequestRepository.save(entity);
    }

    @Transactional
    @Override
    public void modifyUserXetDuyet(long id, boolean value) {
        dataSourceContextHolder.setBranchContext(DatasourceType.XET_DUYET);
        UserRequestEntity entity = userRequestRepository.findById(id).orElseThrow(RuntimeException::new);
        if (value) {
            entity.setIsApprove(1);
            entity.setIsRejected(0);
        } else {
            entity.setIsApprove(0);
            entity.setIsRejected(1);
        }
        userRequestRepository.save(entity);
    }
}
