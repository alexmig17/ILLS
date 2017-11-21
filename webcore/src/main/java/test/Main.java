package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Aliaksei_Drapun\\IdeaProjects\\SpringExample\\testweb\\webcore\\src\\main\\webapp\\WEB-INF\\configuration\\spring\\springAppContext.xml");

        A a = (A)context.getBean("a");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");

        DriverManagerDataSource
    }
}
