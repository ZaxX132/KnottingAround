package com.zaxx.KnottingAround.domain.service;

import com.zaxx.KnottingAround.domain.dto.userDto.UserShowDto;
import com.zaxx.KnottingAround.domain.mapper.DomUserMapper;
import com.zaxx.KnottingAround.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShowService {
    @Autowired
    private final UserService userService;
    @Autowired
    private final DomUserMapper mapper;

    public UserShowService(UserService userService, DomUserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    public UserShowDto getUserByUsername(String username){
        return mapper.toUserShowDto(this.userService.getUserByUsername(username));
    }
}
