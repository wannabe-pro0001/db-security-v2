package com.db.security.response;

import com.db.security.model.LocationEntity;
import com.db.security.model.enum_type.Gender;
import com.db.security.request.LocationResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private long id;

    private String fullName;

    private Gender gender;

    private String CCCD;

    private String phone;

    private String email;

    private Integer extendDuration;

    private int isAuthenticated;

    private int isApprove;

    private int isRejected;

    private String note;
    private String passportId;

    private LocationResponse location;
}
