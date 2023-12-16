package com.db.security.model;

import com.db.security.model.enum_type.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "PASSPORT", name = "employee")
public class EmployeeEntity {
    @GeneratedValue
    @Id
    private long id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residentId", referencedColumnName = "id")
    private ResidentEntity resident;
}
