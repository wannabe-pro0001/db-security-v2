package com.db.security.service.impl;

import com.db.security.config.DataSourceContextHolder;
import com.db.security.config.DatasourceType;
import com.db.security.mapper.LuuTru_PassportMapper;
import com.db.security.mapper.PassportMapper;
import com.db.security.repository.PassportRepository;
import com.db.security.response.LuuTru_PassportResponse;
import com.db.security.response.PassportResponse;
import com.db.security.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final PassportMapper passportMapper;
    private final LuuTru_PassportMapper luupassportMapper;
    private final DataSourceContextHolder dataSourceContextHolder;

    @Override
    public List<PassportResponse> getListPassport(String username) {
        switch (username) {
            case "XacThucQuan1" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_1);
            case "XacThucQuan2" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_2);
            case "XacThucQuan3" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC_3);
            case "XacThuc" -> dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        }
    
        return passportRepository.findAll().stream().map(passportMapper::toResponse).toList();
    }

    @Override
    public List<LuuTru_PassportResponse> getListLuuTru_Passport() {
        dataSourceContextHolder.setBranchContext(DatasourceType.LUU_TRU);
        return passportRepository.findAll().stream().map(luupassportMapper::toResponse).toList();
    }
}
