package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {
    // 1 : USER, 2: MANAGER, 3: ADMIN~~~~
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}
/*
  Member(M)                  <관계T : member_roles>       Role(N)
  1 : 홍길동                         1         1                                 1 : USER / 2:MANAGER / 3:ADMIN
  2 : 나길동                        1         2
  3 : 조길동
 */