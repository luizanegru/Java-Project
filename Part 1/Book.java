package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.io.IOException;
import java.util.Scanner;
import java.util.Comparator;

public class Book {

    static int bookId = 0;
    private String title;
    private String author;
    private String description;
    private String publishingHous;
    private int year;
    private int numberBooks;
    private int numberRents;

    ArrayList<String> tags;

    //contructor
    public Book(String d, String t, String a, String pH, int y, int nB){
        bookId++;

        title = t;
        description = d;
        author = a;
        publishingHous = pH;
        year = y;
        numberBooks = nB;
        tags = new ArrayList<String>();
    }

    //add tags for a book- ex: drama, love;
    public void addTags(String name){
        tags.add(name);
    }

    public void changeBookInfo() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nUpdate Author? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Author: ");
            author = reader.readLine();
        }

        System.out.println("\nUpdate Description? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Subject: ");
            description = reader.readLine();
        }

        System.out.println("\nUpdate Title? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Title: ");
            title = reader.readLine();
        }

        System.out.println("\nUpdate Publishing Hous? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Publishing Hous: ");
            publishingHous = reader.readLine();
        }

        Scanner scan = new Scanner(System.in);
        Year input2;

        System.out.println("\nUpdate Year? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Year: ");
            year = scan.nextInt();
        }

        System.out.println("\nUpdate Number Of This Type OF Book? (y/n)");
        input = scanner.next();

        if(input.equals("y"))
        {
            System.out.println("\nEnter new Number Of This Type OF Book: ");
            numberBooks = scan.nextInt();
        }


        System.out.println("\nBook is successfully updated.");

    }

    public void printInfo() {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("Book ID: " + bookId + "\n");
        System.out.println("Title: " + title + "\n");
        System.out.println("Author: " + author + "\n");
        System.out.println("Description: " + description + "\n");
        System.out.println("Publishing Hous: " + publishingHous + "\n");
        System.out.println("Year of occurrence: " + year + "\n");
        System.out.println("Tags: ");
        for(int i = 0; i < tags.size(); i++){
            System.out.println(tags.get(i) + " ");
        }

    }

    public String getTitle(){
        return title;
    }

    public static Comparator<Book> bookComparator = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            String bookTitle1 = b1.getTitle();
            String bookTitle2 = b2.getTitle();

            return bookTitle1.compareTo(bookTitle2);

        }
    };

    //////////////----Getter Functions----////////////

    public int getBookId(){
        return bookId;
    }


    public String getAuthor(){
        return author;
    }

    public String getDescription(){
        return description;
    }

    public String getPublishingHous(){
        return publishingHous;
    }

    public int getYear(){
        return year;
    }
    public int getnumberBooks(){
        return numberBooks;
    }

    public int getNumberRents(){
        return numberRents;
    }

    //////////////----Setter Functions----////////////

    public void setnumberBooks(int nB){
        numberBooks = nB;
    }

    public void setNumberRents(int nR){
        numberRents = nR;
    }
}

