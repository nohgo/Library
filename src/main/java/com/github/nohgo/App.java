package com.github.nohgo;

import com.github.nohgo.models.Individual;
import com.github.nohgo.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private IndividualService individualService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Username and Password");
        Individual individual = individualService.Login(input.next(), input.next());
        if (individual != null) {
            System.out.println("Welcome " + individual.getUsername());
        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}
