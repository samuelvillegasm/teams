package com.example.teams.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
