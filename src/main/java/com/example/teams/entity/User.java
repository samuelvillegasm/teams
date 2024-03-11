package com.example.teams.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
