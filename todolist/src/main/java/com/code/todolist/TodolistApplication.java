//package com.code.todolist;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//
//@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
//public class TodolistApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TodolistApplication.class, args);
//	}
//
//}
package com.code.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.code.todolist.repository")
public class TodolistApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }
}
