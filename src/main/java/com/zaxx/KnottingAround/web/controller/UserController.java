package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.domain.dto.userDto.UserShowDto;
import com.zaxx.KnottingAround.domain.service.UserShowService;
import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final UserShowService userShowService;

    public UserController(UserService userService, UserShowService userShowService) {
        this.userService = userService;
        this.userShowService = userShowService;
    }
    @GetMapping()
    public ResponseEntity<UserShowDto> getUser(Authentication authentication){
        return ResponseEntity.ok(userShowService.getUserByUsername(authentication.getPrincipal().toString()));
    }

}
