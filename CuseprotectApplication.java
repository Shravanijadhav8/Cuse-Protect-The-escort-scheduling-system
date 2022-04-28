package com.shravani.cuseprotect;

import com.shravani.cuseprotect.controller.LoginController;
//import com.shravani.cuseprotect.controller.UserController;
//import com.shravani.cuseprotect.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
//@ComponentScan(basePackageClasses= LoginController.class)
public class CuseprotectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuseprotectApplication.class, args);
	}

}
