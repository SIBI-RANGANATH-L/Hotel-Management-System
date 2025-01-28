package com.example.hms.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hotel Management System API")
                        .version("1.0.0")
                        .description("API documentation for the Hotel Management System")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your_email@example.com")
                                .url("https://example.com")));
    }
}

@RestController
class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
