package com.db.security.request;

import com.db.security.model.enum_type.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String fullName;

    private Gender gender;

    private String CCCD;

    private String phone;

    private String email;

    private Integer extendDuration;

    private Long locationId;
    private String passportId;
}
