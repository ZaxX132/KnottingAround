package com.zaxx.KnottingAround.service.security;

import com.zaxx.KnottingAround.domain.dto.userDto.UserRegisterDto;
import com.zaxx.KnottingAround.excepcions.registerExceptions.CellPhoneAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.EmailAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.NickNameAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.UserAlredyExistsException;
import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import com.zaxx.KnottingAround.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegisterService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserRegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(UserRegisterDto userRegister) throws UserAlredyExistsException
            , EmailAlredyExistsException, CellPhoneAlredyExistsException , NickNameAlredyExistsException {
        if(userRepository.existsById(userRegister.getUsuario())){
            throw new UserAlredyExistsException("User already exists");
        }else if(userRepository.existsByCorreo(userRegister.getCorreo())){
            throw new EmailAlredyExistsException("Email already exists");
        }else if(userRepository.existsByApodo(userRegister.getApodo())){
            throw new NickNameAlredyExistsException("The nickname already exists");
        }
        else if(userRegister.getCelular()!=null){
            if(userRepository.existsByCelular(userRegister.getCelular())){
                throw new CellPhoneAlredyExistsException("Cellphone already exists");
            }
        }
        UserEntity NewUser=new UserEntity();
        NewUser.setUsuario(userRegister.getUsuario());
        encodePassword(NewUser,userRegister);
        NewUser.setApodo(userRegister.getApodo());
        NewUser.setCelular(userRegister.getCelular());
        NewUser.setCorreo(userRegister.getCorreo());
        NewUser.setLocked(false);
        NewUser.setDisabled(false);
        userRepository.save(NewUser);
        userRepository.insertCustomerRole(NewUser.getUsuario());

    }
    private void encodePassword(UserEntity userEntity,UserRegisterDto register){
        userEntity.setPassword(passwordEncoder.encode(register.getPassword()));
    }
}
