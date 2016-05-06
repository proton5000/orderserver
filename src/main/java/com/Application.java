package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by proton on 27.01.2016.
 */
@SpringBootApplication
public class Application {

    public static void  main (String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("beans");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println("---------------------------------------------------");
    }

}
