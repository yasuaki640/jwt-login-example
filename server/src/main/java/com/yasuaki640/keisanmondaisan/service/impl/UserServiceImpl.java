package com.yasuaki640.keisanmondaisan.service.impl;

import com.yasuaki640.keisanmondaisan.model.User;
import com.yasuaki640.keisanmondaisan.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByLoginId(String loginId) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<User> findAll(Pageable page) {
        return null;
    }

    @Transactional(timeout = 10)
    @Override
    public User updateById(long id, User user) {
        return null;
    }

    @Transactional(timeout = 10)
    @Override
    public void deleteById(long id) {

    }
}
