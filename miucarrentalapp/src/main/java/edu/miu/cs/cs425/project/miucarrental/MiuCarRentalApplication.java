package edu.miu.cs.cs425.project.miucarrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MiuCarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiuCarRentalApplication.class, args);
    }

}
