package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
}
