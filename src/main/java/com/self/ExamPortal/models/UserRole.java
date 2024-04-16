package com.self.ExamPortal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    private Role role;
}
