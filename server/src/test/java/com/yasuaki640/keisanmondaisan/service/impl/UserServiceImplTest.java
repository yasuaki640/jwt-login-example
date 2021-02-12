package com.yasuaki640.keisanmondaisan.service.impl;

import com.yasuaki640.keisanmondaisan.repository.UserRepository;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

    private static IDatabaseTester databaseTester;

    @MockBean
    UserRepository repository;

    @BeforeEach
    void setUp() throws Exception {

        databaseTester = new JdbcDatabaseTester(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/keisanmondaisan",
                "keisanmondaisan",
                "keisanmondaisan"
        );

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(new File("./data/After.xml"));

        databaseTester.setDataSet(dataSet);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();
    }

    @Test
    void test_findById() {

    }
}