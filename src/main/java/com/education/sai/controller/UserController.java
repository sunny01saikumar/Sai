package com.education.sai.controller;


import com.education.sai.model.User;

import com.education.sai.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> users() {
        return userService.findUser();
    }

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getUsers(page, size);
    }

    @PostMapping("/upload")
    public String uploadUsers(@RequestParam("file") MultipartFile file) {
        userService.saveUsersFromExcel(file);
        return "Users Uploaded Successfully";
    }
}