package com.github.nohgo;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import com.github.nohgo.models.Individual;
import com.github.nohgo.models.Magazine;
import com.github.nohgo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import static com.github.nohgo.lib.EnterUsernamePassword.enterUsernamePassword;
import static com.github.nohgo.lib.Login.login;
import static com.github.nohgo.lib.Register.register;
import static com.github.nohgo.lib.UserFlow.userFlow;

@SpringBootApplication
public class App {
    public static Scanner input = new Scanner(System.in);

    @Autowired
    private LibraryItemService libraryItemService;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthService authService;




    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
