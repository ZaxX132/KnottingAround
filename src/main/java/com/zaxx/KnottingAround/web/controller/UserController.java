package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.domain.dto.userDto.UserShowDto;
import com.zaxx.KnottingAround.domain.dto.userDto.UserUpdateDto;
import com.zaxx.KnottingAround.domain.service.UserShowService;
import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/customer/update")
    public ResponseEntity<UserShowDto> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto, Authentication authentication){
        userService.saveUser(userUpdateDto,authentication);
        return ResponseEntity.ok(userShowService.getUserByUsername(authentication.getPrincipal().toString()));
    }
    @PutMapping("/admin/ban")
    public ResponseEntity<Void> banUser(@RequestParam String username){
        userService.banUser(username);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/admin/unban")
    public ResponseEntity<Void> unBanUser(@RequestParam  String username){
        userService.unbanUser(username);
        return ResponseEntity.ok().build();
    }
}
