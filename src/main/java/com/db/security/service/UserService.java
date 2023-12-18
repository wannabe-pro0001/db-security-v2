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

    void modifyUser(long id, int value); // đường cùng viết v cho nhanh =))

    void modifyUserXetDuyet(long id, boolean value);

    void AuthenticateUserRequest(long id, String username);
    void ApproveUserRequest(long id, String username);
    void RejectUserRequest(long id, String username);
}
