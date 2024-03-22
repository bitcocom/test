package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequiredArgsConstructor
public class TestController {

    @Autowired
    private  BookService bookService;

    @RequestMapping("/start")
    public String start(Model model){
        List<String> list=new ArrayList<>();
        list.add("사과");
        list.add("바나나");
        list.add("오랜지");
        list.add("포도");
        list.add("귤");
        model.addAttribute("list",list);
        return "index"; // index.html ->  ${list}
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Book> list=bookService.list();
        model.addAttribute("list", list);
        return "list"; // list.html
    }
}
