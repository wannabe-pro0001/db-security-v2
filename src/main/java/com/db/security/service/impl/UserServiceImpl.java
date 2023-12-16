package com.db.security.service.impl;

import com.db.security.config.DataSourceContextHolder;
import com.db.security.config.DatasourceType;
import com.db.security.mapper.LocationMapper;
import com.db.security.mapper.UserMapper;
import com.db.security.model.LocationEntity;
import com.db.security.model.UserRequestEntity;
import com.db.security.repository.LocationRepository;
import com.db.security.repository.UserRequestRepository;
import com.db.security.request.LocationResponse;
import com.db.security.request.UserRequest;
import com.db.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        dataSourceContextHolder.setBranchContext(DatasourceType.PRIMARY);
        UserRequestEntity entity = userMapper.toEntity(request);
        if (!Objects.isNull(request.getLocationId())) {
            LocationEntity location = locationRepository.findById(request.getLocationId()).orElse(null);
            entity.setLocation(location);
        }
        userRequestRepository.save(entity);
    }

    @Override
    public List<LocationResponse> getListLocation() {
        dataSourceContextHolder.setBranchContext(DatasourceType.PRIMARY);
        return locationRepository.findAll().stream().map(locationMapper::toResponse).toList();
    }
}
