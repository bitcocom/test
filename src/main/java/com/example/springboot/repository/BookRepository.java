package com.example.springboot.repository;

import com.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
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
    public Optional<Book> findByPrice(int price);  // select * Book b where b.price=price
    // SQL과 유사한 쿼리 언어입니다
    // 3. JPQL(Java Persistence Query Language) : Entity 기반
    //@Query("select b from Book b where b.price >= :price") // Entity 기반
    //public List<Book> getByPrice(@Param("price") int price); // 가격이 10000원 이상인 책을 검색

    //@Query("select b from Book b where b.price >= :price AND b.page >=:page") // Entity 기반
    //public List<Book> getByPrice(@Param("price") int price, @Param("page") int page); // 가격이 10000원 이상인 책을 검색
    // 4. JPQL(Java Persistence Query Language) : SQL기반
    @Query(value = "select * from book where price>=?1", nativeQuery = true)
    public List<Book> getByPrice(int price);

    }
