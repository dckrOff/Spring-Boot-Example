package com.example.blog.controllers;

import com.example.blog.Service.FIleStoreService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    FIleStoreService fileStoreService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Про нас");
        return "about";
    }

    @PostMapping("/upload_image")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        fileStoreService.store(file);
        return "about";
    }
}
