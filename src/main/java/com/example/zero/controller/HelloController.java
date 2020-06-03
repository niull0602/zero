package com.example.zero.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-05-22 13:14.
 */
@RestController
public class HelloController {
    @GetMapping
    public String getHello(){
        return "service health";
    }
}
