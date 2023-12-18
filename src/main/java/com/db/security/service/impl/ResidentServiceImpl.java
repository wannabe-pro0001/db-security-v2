package com.db.security.service.impl;

import com.db.security.config.DataSourceContextHolder;
import com.db.security.config.DatasourceType;
import com.db.security.mapper.ResidentMapper;
import com.db.security.repository.ResidentRepository;
import com.db.security.response.ResidentResponse;
import com.db.security.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;
    private final ResidentMapper residentMapper;
    private final DataSourceContextHolder dataSourceContextHolder;

    @Override
    public List<ResidentResponse> getAllResident(String username) {
        switch (username) {
            case "XacThucQuan1" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_1);
            case "XacThucQuan2" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_2);
            case "XacThucQuan3" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_3);
            case "XacThuc" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        }
        return residentRepository.findAll().stream().map(residentMapper::toResponse).toList();
    }
}
