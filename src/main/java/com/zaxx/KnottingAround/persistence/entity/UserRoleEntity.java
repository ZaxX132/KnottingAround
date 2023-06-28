package com.zaxx.KnottingAround.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles_usuario")
@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity {
    @Id
    @Column
    private String usuario;
    @Id
    @Column
    private String role;
    @Column(name = "granted_date")
    private LocalDateTime grantedDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="usuario",referencedColumnName = "usuario",insertable = false,updatable = false)
    private UserEntity user;
}
