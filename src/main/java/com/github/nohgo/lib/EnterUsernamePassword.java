package com.github.nohgo.lib;

import java.util.List;
import java.util.Scanner;

public class EnterUsernamePassword {
    public static List<String> enterUsernamePassword(Scanner input) {
        String username;
        String password;
        do {
            System.out.print("Enter your username: ");
            username = input.nextLine();
            System.out.print("Enter your password: ");
            password = input.nextLine();
        } while (username.isEmpty() || password.isEmpty());
        return List.of(username, password);
    }
}
