package com.yasuaki640.keisanmondaisan.service.impl;

import com.yasuaki640.keisanmondaisan.config.AppDataSource;
import com.yasuaki640.keisanmondaisan.repository.UserRepository;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.MalformedURLException;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

    private static IDatabaseTester databaseTester;

    @MockBean
    UserRepository repository;

    @BeforeEach
    void setUp() throws ClassNotFoundException, MalformedURLException, DataSetException {
        databaseTester = new JdbcDatabaseTester(
                AppDataSource.DRIVER,
                AppDataSource.url,
                AppDataSource.username,
                AppDataSource.password
        );

    }

    @Test
    void test_findById() {

    }
}