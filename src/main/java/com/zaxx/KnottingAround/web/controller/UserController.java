package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
