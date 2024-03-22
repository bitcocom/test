package com.example.springboot.service;

import com.example.springboot.entity.Book;
import com.example.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    //@Transactional
    public List<Book> list(){
        List<Book> list=repository.findAll();
        return list;
    }

}
