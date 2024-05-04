package com.github.nohgo.lib;

import com.github.nohgo.models.Individual;
import com.github.nohgo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

import static com.github.nohgo.lib.EnterUsernamePassword.enterUsernamePassword;
import static com.github.nohgo.lib.UserFlow.userFlow;

public class Login {

    public static void login(Scanner input) {
        AuthService authService = new AuthService();
        List<String> usernamePassword = enterUsernamePassword(input);
        Individual individual;
        do {
            try {
                individual = authService.login(usernamePassword.get(0), usernamePassword.get(1));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Welcome, " + individual.getUsername() + "!");
        if (individual.getIsAdmin()) {
            System.out.println("You are an admin.");
        } else {
            userFlow(input, individual);
        }
    }
}
