package com.db.security.service.impl;

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


    @Override
    public List<ResidentResponse> getAllResident() {
        return residentRepository.findAll().stream().map(residentMapper::toResponse).toList();
    }
}
