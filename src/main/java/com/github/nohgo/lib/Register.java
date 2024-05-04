package com.github.nohgo.lib;

import com.github.nohgo.services.AuthService;

import java.util.List;
import java.util.Scanner;

import static com.github.nohgo.lib.EnterUsernamePassword.enterUsernamePassword;

public class Register {
    public static void register(Scanner input) {
        AuthService authService = new AuthService();
        List<String> usernamePassword = enterUsernamePassword(input);

        do {
            try {
                authService.register(usernamePassword.get(0), usernamePassword.get(1));
                System.out.println("Registration successful!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
