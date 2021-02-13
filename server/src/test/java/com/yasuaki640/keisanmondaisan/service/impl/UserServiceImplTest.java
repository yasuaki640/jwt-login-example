package com.yasuaki640.keisanmondaisan.service.impl;

import com.yasuaki640.keisanmondaisan.repository.UserRepository;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
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
    public void setUp() throws Exception {

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

    @AfterEach
    public void tearDown() throws Exception {
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
        databaseTester.onTearDown();
    }

    @Test
    void test_findById() throws Exception {

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("./data/After.xml"));
        ITable expectedTable = expectedDataSet.getTable("users");

        IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("users");

        ITable filteredExpectedTable = getFilteredTable(expectedTable);
        ITable filteredActualTable = getFilteredTable(actualTable);

        Assertion.assertEquals(filteredActualTable, filteredExpectedTable);

    }

    private ITable getFilteredTable(ITable expectedTable) throws DataSetException {
        return DefaultColumnFilter.excludedColumnsTable(
                expectedTable, new String[]{"created_at", "updated_at", "deleted_at"});
    }
}