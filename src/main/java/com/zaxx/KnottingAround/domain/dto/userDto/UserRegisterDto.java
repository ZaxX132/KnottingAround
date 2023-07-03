package com.zaxx.KnottingAround.domain.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterDto {
    @NotBlank
    private String usuario;
    @NotBlank
    private String password;
    @NotBlank
    private String matchingPassword;
    private String apodo;
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")
    private String celular;
    @NotBlank
    @Email
    private String correo;
}
