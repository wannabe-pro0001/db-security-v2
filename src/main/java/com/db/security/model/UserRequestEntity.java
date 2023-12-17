package com.db.security.model;

import com.db.security.model.enum_type.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "PASSPORT", name = "user_request")
@Accessors(chain = true)
public class UserRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String CCCD;

    private String phone;

    private String email;

    @Column(name = "extend_duration")
    private Integer extendDuration;

    private int isAuthenticated;

    private int isApprove;

    private int isRejected;

    private String note;
    @Column(name = "passport_id")
    private String passportId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;
}
