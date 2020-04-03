package com.company;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Renter extends Person {

    private Map<Book, Integer> rentBook;
    private int numberOFRents;

    public Renter(String n, String m, int nP){
        super(n,m,nP);
        numberOFRents = 0;
        type = false;
        rentBook = new HashMap<Book, Integer>();
    }

    public void addRentBook(Book book){
        rentBook.put(book, numberOFRents);
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("Number of rents: " + numberOFRents);
        rentBook.forEach((Book, Integer) -> System.out.println(Integer + ":" + Book));
    }

    public void removeTentBook(Book book){
        rentBook.remove(book);
    }

    public int sizeRents(){
        return rentBook.size();
    }

    ///////////----- Getter Functions----///////////
    public int getNumberOFRents(){
        return numberOFRents;
    }

    ///////////----- Setter Functions----///////////
    public void setRentBook(int number){
        numberOFRents = number;
    }
}

