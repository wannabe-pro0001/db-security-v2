package com.db.security.service;

import com.db.security.response.LocationResponse;
import com.db.security.request.UserRequest;
import com.db.security.response.UserResponse;

import java.util.List;

public interface UserService {
    void addUser(UserRequest request);
    List<LocationResponse> getListLocation();
    UserResponse getUser(String passportId);
    List<UserResponse> getAllUser(String username);

    void modifyUser(long id, int value);

    void modifyUserXetDuyet(long id, boolean value);
}
