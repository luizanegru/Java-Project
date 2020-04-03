package com.company;


public class Librarian extends Person{
    double salary;

    public Librarian(String n, String m, int nP, double s){
        super(n,m,nP);
        salary = s;
        type = true;
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("Salary: " + salary);
    }

}

