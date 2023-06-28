package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
}
