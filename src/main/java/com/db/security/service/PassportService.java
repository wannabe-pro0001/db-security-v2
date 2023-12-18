package com.db.security.service;

import com.db.security.model.PassportEntity;
import com.db.security.response.LuuTru_PassportResponse;
import com.db.security.response.PassportResponse;

import java.util.List;

public interface PassportService {
    List<PassportResponse> getListPassport(String username);
    List<LuuTru_PassportResponse> getListLuuTru_Passport();
}
