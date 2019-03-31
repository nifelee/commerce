package com.nifelee.commerce.core.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JpaConfigTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws Exception{
        log.debug("datasource : {}", dataSource.getConnection().getMetaData());
    }

}