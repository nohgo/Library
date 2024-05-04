package com.github.nohgo;

import com.github.nohgo.models.Individual;
import com.github.nohgo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import static com.github.nohgo.lib.Login.login;
import static com.github.nohgo.lib.Register.register;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to the Library Management System!\n");
        String choice;

        do {
            System.out.println("\nWould you like to login or register?");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    login(input);
                    break;
                case "2":
                    register(input);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("3"));
    }



}
