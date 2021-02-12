package com.yasuaki640.keisanmondaisan.service.impl;

import com.yasuaki640.keisanmondaisan.config.AppDataSource;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

    private static IDatabaseTester databaseTester;

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        databaseTester = new JdbcDatabaseTester(
                AppDataSource.DRIVER,
                AppDataSource.url,
                AppDataSource.username,
                AppDataSource.password
        );
        
    }

    void test_findById() {

    }
}