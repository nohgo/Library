package com.github.nohgo.lib;

import com.github.nohgo.models.Individual;
import com.github.nohgo.services.LibraryItemService;
import com.github.nohgo.services.LibraryService;

import java.util.Scanner;

public class UserFlow {
    public static void userFlow(Scanner input, Individual individual) {
        String choice;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View available library items");
            System.out.println("2. Borrow a library item");
            System.out.println("3. Return a library item");
            System.out.println("4. View all borrowed items");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    viewLibraryItems(input);
                    break;
                case "2":
                    borrowLibraryItem(input, individual);
                    break;
                case "3":
                    returnLibraryItem(input, individual);
                    break;
                case "4":
                    viewBorrowedItems(individual);
                    break;
                case "5":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));
    }
    public static void viewLibraryItems(Scanner input) {
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.println("Available library items:");
        libraryItemService.findByIsBorrowed(false).forEach(System.out::println);
        }

        /*
        public void viewLibraryItemsRecursive(Scanner input, List<LibraryItem> libraryItems) {
            if (libraryItems.isEmpty()) {
                return;
            }
            System.out.println(libraryItems.get(0));
            viewLibraryItemsRecursive(input, libraryItems.subList(1, libraryItems.size()));
         */
    public static void borrowLibraryItem(Scanner input, Individual individual) {
        System.out.print("Enter the title of the item you would like to borrow: ");
        String title = input.nextLine();
        LibraryService libraryService = new LibraryService();
        try {
            libraryService.borrowItem(individual, title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Item borrowed successfully!");
    }
    public static void returnLibraryItem(Scanner input, Individual individual) {
        System.out.print("Enter the title of the item you would like to return: ");
        String title = input.nextLine();
        LibraryService libraryService = new LibraryService();
        try {
            libraryService.returnItem(individual, title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Item returned successfully!");
    }
    public static void viewBorrowedItems(Individual individual) {
        System.out.println("Borrowed items:");
        individual.getItems().forEach(System.out::println);
    }
}
