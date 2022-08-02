package com.example.demo1;

import com.example.demo1.Service.SingleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

    @Autowired
    SingleChoiceService singleChoiceService;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        singleChoiceService.contextLoads();
    }

}
