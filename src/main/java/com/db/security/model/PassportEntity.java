package com.db.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "PASSPORT", name = "passport")
public class PassportEntity {
    @GeneratedValue
    @Id
    private long id;

    @Column(name = "passport_id")
    private String passportID;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residentId", referencedColumnName = "id")
    private ResidentEntity resident;
}
