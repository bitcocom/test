package com.example.springboot.repository;

import com.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // 1. 정해진(제공해준) 메서드 사용 (JpaRepository)
    // findAll() --> select * from Book
    // save() --> insert into ~
    // findById(id) -->
    // deleteById(id) --> delete from Book b where b.id=?:id
    // save() --> update
    // select * from Book b where b.id=?:id
    // public Book findByEmail(String email);
    // 책 제목에 해당하는 책정보 1개를 가지고 오기
    // 2. 쿼리메서드 사용(find+By+멤버변수) -> 여러조합(?)
    public Optional<Book> findByTitle(String title);

    }
