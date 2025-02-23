package com.example.myweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class HomeController {

    private final Random random = new Random();

    // 設定目標數字範圍
    private final int targetNumber = random.nextInt(100) + 1;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/guess")
    public String guess(@RequestParam("number") int number, Model model) {
        String message;
        if (number == targetNumber) {
            message = "恭喜你猜對了！目標數字是：" + targetNumber;
        } else if (number < targetNumber) {
            message = "猜錯了！";
        } else {
            message = "猜錯了！";
        }
        model.addAttribute("message", message);
        return "index";
    }
}
