package com.zaxx.KnottingAround.domain.dto.userDto;

import lombok.Data;

@Data
public class UserRegisterDto {

    private String usuario;
    private String password;
    private String matchingPassword;
    private String apodo;
    private String celular;
    private String correo;
}
