package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookRepository repository;

    // http://localhost:8081/api/book
    @GetMapping("/book")
    public ResponseEntity<?> books(){
        // DB에서 book 전체정보 가져오기
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        return new ResponseEntity<>(repository.save(book), HttpStatus.CREATED);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?>
               update(@PathVariable Long id,@RequestBody Book book) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isPresent()) {
            Book dbbook = optional.get();  // 원본내용이 수정이 되면 자동으로 update(더티체킹)
            dbbook.setTitle(book.getTitle()); // 제목
            dbbook.setPrice(book.getPrice()); //가격
            // repository.save(dbbook); // 명시적인 update
            return new ResponseEntity<>(dbbook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }
}
