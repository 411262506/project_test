package com.example.myweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // 對應 index.html
    }

    @GetMapping("/create-character")
    public String createCharacter(Model model) {
        // 生成 5 個固定顏色的頭貼
    List<String> colors = List.of(
    "紅", "橙", "黃", "綠", "藍"
    );

        
        model.addAttribute("colors", colors);
        return "create-character"; // 對應 create-character.html
    }

    private String getRandomColor() {
        Random rand = new Random();
        return String.format("#%02X%02X%02X", rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
