package com.school_journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.net.URLClassLoader;

@SpringBootApplication
public class SchoolJournalApplication {

    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.class.path").replace(":","\n"));
        SpringApplication.run(SchoolJournalApplication.class, args);
    }

}
