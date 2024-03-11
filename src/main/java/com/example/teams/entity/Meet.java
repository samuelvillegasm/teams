package com.example.teams.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table( name = "meets")
@Data
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(name = "max_time")
    private Integer maxTime;


    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToMany(mappedBy = "meetTeams")
    Set<Team> teams;

}
