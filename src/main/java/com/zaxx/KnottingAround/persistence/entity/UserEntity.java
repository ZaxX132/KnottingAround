package com.zaxx.KnottingAround.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String apodo;
    @Column
    private String celular;
    @Column
    private String correo;
    @Column
    private Boolean locked;
    @Column
    private Boolean disabled;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;

}
