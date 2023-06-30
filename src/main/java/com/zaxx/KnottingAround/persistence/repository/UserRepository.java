package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    boolean existsByCorreo(String correo);
    boolean existsByCelular(String celular);
    boolean existsByApodo(String apodo);
    @Query(value = "Insert into roles_usuario(usuario,role,granted_date) values(:user,'CUSTOMER',CURTIME())",nativeQuery = true)
    @Modifying
    void insertCustomerRole(String user);
}
