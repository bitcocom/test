package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book { // 책(Object)---ORM(Hibernate API 엔진)--->데이블(Table)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // PK , 1 2 3 4 ....
    @Column(length = 50, nullable = false)
    private String title;
    private int price;
    private String name;
    private int page;
}
