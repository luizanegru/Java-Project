package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.IOException;

public class Library {

    private String name;
    private Librarian librarian;
    private ArrayList<Person> persons;
    private ArrayList<Book> booksInLibrary;

    private static Library library;

    public static Library getInstance() {
        if(library==null)
        {
            library = new Library();
        }

        return library;
    }

    private Library() {
        name = null;
        persons = new ArrayList();
        booksInLibrary = new ArrayList();

    }

    public void setName(String n) {
        name = n;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Book> getBooks() {
        return booksInLibrary;
    }

    public boolean addLibrarian(Librarian lib) {
        if (librarian == null) {
            librarian = lib;
            persons.add(librarian);
            return true;
        }
        else
            System.out.println("\nSorry, the library already has one librarian. New Librarian can't be created.");
        return false;
    }

    public void addRenter(Renter person) {
        persons.add(person);
    }

    public void removeBookFromLibrary(Book b) {
        booksInLibrary.remove(b);
    }

    // View Info of all Books in Library
    public void viewAllBooks() {

        if (!booksInLibrary.isEmpty())
        {
            Scanner scanner = new Scanner(System.in);
            String input;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nYou want the books sorted by title? (y/n)");
            input = scanner.next();

            if(input.equals("y"))
            {
                Collections.sort(booksInLibrary, Book.bookComparator);
            }


            System.out.println("\nBooks are: ");

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("No.\t\tTitle\t\t\tAuthor\t\t\tDescription\t\t\tPublishing Hous\t\t\tYear of occurrence\t\t\tTags");
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < booksInLibrary.size(); i++)
            {
                booksInLibrary.get(i).printInfo();
                System.out.print("\n");
            }
        }
        else
            System.out.println("\nCurrently, Library has no books.");
    }

    public void createPerson(char x) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("\nEnter Name: ");
        String n = "";
        n = reader.readLine();

        System.out.println("Enter Mail: ");
        String mail = "";
        mail = reader.readLine();


        int phone = 0;
        try {
            System.out.println("Enter Phone Number: ");
            phone = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("\nInvalid Input.");
        }

        //creat a librarian
        if (x == 'l')
        {
            double salary = 0;
            try{
                System.out.println("Enter Salary: ");
                salary = sc.nextDouble();
            }
            catch (java.util.InputMismatchException e)
            {
                System.out.println("\nInvalid Input.");
            }

            Librarian l = new Librarian(n,mail,phone,salary);
            if(addLibrarian(l))
            {
                System.out.println("\nLibrarian with name " + n + " created successfully.");
                System.out.println("\nYour ID is : " + l.getId());
                System.out.println("Your Password is : " + l.getPassword());
            }
        }
        //creat a renter
        else
        {
            Renter r = new Renter(n,mail,phone);
            addRenter(r);
            System.out.println("\nBorrower with name " + n + " created successfully.");

            System.out.println("\nYour ID is : " + r.getId());
            System.out.println("Your Password is : " + r.getPassword());
        }
    }

    public void addBookinLibrary(Book b) {
        booksInLibrary.add(b);
    }

    public void createBook(String description, String title, String author, String pH, int y, int nB){
        Book b = new Book(description, title, author, pH, y, nB);

        addBookinLibrary(b);

        System.out.println("\nBook with Title " + b.getTitle() + " is successfully created.");
    }

    public ArrayList<Book> searchForBooks() throws IOException
    {
        String choice;
        String title = "", subject = "", author = "";

        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("\nEnter either '1' or '2'  for search by Title or Author of Book respectively: ");
            choice = sc.next();

            if (choice.equals("1") || choice.equals("2"))
                break;
            else
                System.out.println("\nWrong Input!");
        }

        if (choice.equals("1"))
        {
            System.out.println("\nEnter the Title of the Book: ");
            title = reader.readLine();
        }

        else if (choice.equals("2"))
        {
            System.out.println("\nEnter the Author of the Book: ");
            author = reader.readLine();
        }



        ArrayList<Book> matchedBooks = new ArrayList();

        //Retrieving all the books which matched the user's search query
        for(int i = 0; i < booksInLibrary.size(); i++)
        {
            Book b = booksInLibrary.get(i);

            if (choice.equals("1"))
            {
                if (b.getTitle().equals(title))
                    matchedBooks.add(b);
            }
            else if (choice.equals("2"))
            {
                if (b.getAuthor().equals(author))
                    matchedBooks.add(b);
            }

        }

        //Printing all the matched Books
        if (!matchedBooks.isEmpty())
        {
            System.out.println("\nThese books are found: \n");

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("No.\t\tTitle\t\t\tAuthor\t\t\tSubject");
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < matchedBooks.size(); i++)
            {
                System.out.print(i + "-" + "\t\t");
                matchedBooks.get(i).printInfo();
                System.out.print("\n");
            }

            return matchedBooks;
        }
        else
        {
            System.out.println("\nSorry. \n" + "This book is not in the library.");
            return null;
        }
    }



}

