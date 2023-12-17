package com.db.security.service;

import com.db.security.model.PassportEntity;
import com.db.security.response.PassportResponse;

import java.util.List;

public interface PassportService {
    List<PassportResponse> getListPassport(String username);
}
