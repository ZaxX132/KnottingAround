package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.domain.dto.userDto.LoginDto;
import com.zaxx.KnottingAround.domain.dto.userDto.UserRegisterDto;
import com.zaxx.KnottingAround.excepcions.registerExceptions.CellPhoneAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.EmailAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.NickNameAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.UserAlredyExistsException;
import com.zaxx.KnottingAround.service.security.UserRegisterService;
import com.zaxx.KnottingAround.web.config.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRegisterService registerService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    public AuthController(UserRegisterService registerService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.registerService = registerService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }



    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());
        String jwt=this.jwtUtil.create(loginDto.getUsername());
        return  ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt).build();
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegisterDto register) throws CellPhoneAlredyExistsException
            , UserAlredyExistsException, EmailAlredyExistsException, NickNameAlredyExistsException {

        if(register.getPassword().equals(register.getMatchingPassword())){
           registerService.register(register);
          return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
