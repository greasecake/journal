package com.school_journal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SchoolJournalApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testConnection() throws SQLException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.school_journal");

        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        Assert.notNull(dataSource);

    }
}
