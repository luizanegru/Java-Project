package com.company;


import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void allFunctionalities(int choice) throws IOException {
        Library lib = Library.getInstance();

        Scanner scanner = new Scanner(System.in);
        int input = 0;

        switch (choice){
            //add book
            case 0:
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("\nEnter Title:");
                String title = reader.readLine();

                System.out.println("\nEnter Description:");
                String description = reader.readLine();

                System.out.println("\nEnter Author:");
                String author = reader.readLine();

                System.out.println("\nEnter Publishing Hous:");
                String publishing = reader.readLine();

                System.out.println("\nEnter Year:");
                int year = reader.read();

                System.out.println("\nEnter Number of Books:");
                int numberBooks = reader.read();

                lib.createBook(description, title, author, publishing, year, numberBooks);

                break;

            case 1:
                lib.viewAllBooks();
                break;

            case 2:
                lib.createPerson('r');
                break;

            case 3:
                lib.createPerson('l');
                break;

            case 4:
                ArrayList<Book> books = lib.searchForBooks();

                if (books != null) {

                    lib.removeBookFromLibrary(books.get(input));
                }
                break;

            case 5:
                 books = lib.searchForBooks();

                if (books!=null)
                {

                    books.get(input).changeBookInfo();
                }

        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("------ Hello to my Library!!! --------\n");
        System.out.println("------ Menu --------\n");
        System.out.println("0: Add book.\n");
        System.out.println("1: View all books.\n");
        System.out.println("2: Creat a renter.\n");
        System.out.println("3: Creat a librarian.\n");
        System.out.println("4: Remove a book.\n");
        System.out.println("5: Change book info.\n");


        Scanner scan = new Scanner(System.in);
        System.out.println("Entry a choice: ");
        int choice = scan.nextInt();

        while(choice != -1){
            allFunctionalities(choice);
            System.out.println("Entry a choice: ");
            choice = scan.nextInt();
        }

    }

}
