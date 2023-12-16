package com.db.security.model;

import com.db.security.model.enum_type.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "PASSPORT", name = "userRequest")
public class UserRequestEntity {
    @GeneratedValue
    @Id
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String CCCD;

    private String phone;

    private String email;

    @Column(name = "extendDuration")
    private Integer extendDuration;

    private int isAuthenticated;

    private int isApprove;

    private int isRejected;

    private String note;
    private String passportId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    private LocationEntity location;
}
