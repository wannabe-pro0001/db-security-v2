package com.db.security.service;

import com.db.security.request.LocationResponse;
import com.db.security.request.UserRequest;

import java.util.List;

public interface UserService {
    void addUser(UserRequest request);
    List<LocationResponse> getListLocation();
}
