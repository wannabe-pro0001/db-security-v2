package com.db.security.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PassportResponse {
    private long id;

    private String passportID;

    private LocalDate startDate;

    private LocalDate endDate;

    private ResidentResponse resident;
}
