package com.zaxx.KnottingAround.domain.dto.userDto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserShowDto {
    private String usuario;
    private String apodo;
    private String celular;
    private String correo;

}
