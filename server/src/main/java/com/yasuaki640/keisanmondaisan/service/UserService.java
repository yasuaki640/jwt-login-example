package com.yasuaki640.keisanmondaisan.service;

import com.yasuaki640.keisanmondaisan.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);

    Optional<User> findByLoginId(String loginId);

    Page<User> findAll(Pageable page);

    User updateById(long id, User user);

    void deleteById(long id);
}
