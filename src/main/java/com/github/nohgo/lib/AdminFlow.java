package com.github.nohgo.lib;

import com.github.nohgo.models.Author;
import com.github.nohgo.models.Book;
import com.github.nohgo.models.Magazine;
import com.github.nohgo.services.AuthorService;
import com.github.nohgo.services.LibraryItemService;

import java.util.Scanner;

public class AdminFlow {
    public static void adminFlow(Scanner input) {
        String choice;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View all items");
            System.out.println("2. View all borrowed items");
            System.out.println("3. View all available items");
            System.out.println("4. Add an item");
            System.out.println("5. Remove an item");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    viewAllBooks();
                    break;
                case "2":
                    viewAllBorrowedBooks();
                    break;
                case "3":
                    viewAllAvailableBooks();
                    break;
                case "4":
                    addBook();
                    break;
                case "5":
                    addMagazine();
                    break;
                case "6":
                    removeBook();
                    break;
                case "7":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("7"));
    }
    public static void viewAllBooks() {
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.println("All library items:");
        libraryItemService.getAllLibraryItems().forEach(System.out::println);
    }
    public static void viewAllBorrowedBooks() {
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.println("All borrowed library items:");
        libraryItemService.findByIsBorrowed(true).forEach(System.out::println);
    }
    public static void viewAllAvailableBooks() {
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.println("All available library items:");
        libraryItemService.findByIsBorrowed(false).forEach(System.out::println);
    }
    public static void addMagazine() {
        Magazine magazine = new Magazine();

        Scanner input = new Scanner(System.in);
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.print("Enter the title of the magazine: ");
        String title = input.nextLine();
        System.out.print("Enter the issue number of the magazine: ");
        int issueNumber = Integer.parseInt(input.nextLine());
        magazine.setTitle(title);
        magazine.setIssueNumber(issueNumber);
        libraryItemService.saveLibraryItem(magazine);
        System.out.println("Magazine added successfully!");
    }
    public static void addBook() {
        Book book = new Book();
        AuthorService authorService = new AuthorService();

        Scanner input = new Scanner(System.in);
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.print("Enter the title of the book: ");
        book.setTitle(input.nextLine());
        System.out.print("Enter the author of the book: ");
        String authorName = input.nextLine();
        Author author;
        if (authorService.findByName(authorName) == null) {
            author = new Author();
            author.setName(authorName);
            authorService.save(author);
        } else {
            author = authorService.findByName(authorName);
            author.getBooks().add(book);
        }
        book.setAuthor(author);
        libraryItemService.saveLibraryItem(book);
        System.out.println("Book added successfully!");
    }
    public static void removeBook() {
        Scanner input = new Scanner(System.in);
        LibraryItemService libraryItemService = new LibraryItemService();
        System.out.print("Enter the title of the book you would like to remove: ");
        String title = input.nextLine();
        try {
            libraryItemService.removeByTitle(title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Book removed successfully!");
    }
}
