package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.domain.dto.userDto.UserUpdateDto;
import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.persistence.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void saveUser(UserUpdateDto userUpdateDto, Authentication authentication){
        userRepository.updateCelularAndApodo(userUpdateDto.getCelular(),userUpdateDto.getApodo(),authentication.getPrincipal().toString());
    }
    public void banUser(String user){
        userRepository.updateLockedandDisabled(true,true,user);
    }
    public void unbanUser(String user){
        userRepository.updateLockedandDisabled(false,false,user);
    }
}
