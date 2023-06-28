package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserEntity> getAll(){
        return this.userRepository.findAll();
    }
    public UserEntity getUserByUsername(String username){
        return this.userRepository.findById(username).get();
    }
}
