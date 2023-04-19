package br.edu.utfpr.todo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class IndexController {
    
    @GetMapping("/")
    public String hello() {
        return "API ToDo is running!";
    }    
}
