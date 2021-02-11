package com.yasuaki640.keisanmondaisan.repository;

import com.yasuaki640.keisanmondaisan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
