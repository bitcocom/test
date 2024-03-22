package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true, nullable = false)
    private String username; // unique
    private String password;
    private String uname;
    private int age;
    private String email;
    // 권한정보(1명의 회원은 여러개의 권한을 가질 수 있다) - Set
    @ManyToMany(fetch = FetchType.EAGER) // 즉시로딩(EAGER) , 지연로딩(LAZY)
    @JoinTable(
            name="member_roles",
            joinColumns=@JoinColumn(name="member_id"),
            inverseJoinColumns =@JoinColumn(name="role_id")
    )
    private Set<Role> roles; // Role(권한)
}