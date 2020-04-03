package com.company;


public abstract class Person {
    protected String name;
    protected String mail;
    protected int phoneNumber;
    protected String password;
    protected boolean type;
    static int idPerson = 0;
    protected int a;

    public Person(String n, String m, int nP) {
        idPerson++;

        name = n;
        mail = m;
        phoneNumber = nP;
        password = Integer.toString(idPerson);
    }

    public void printInfo() {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("ID: " + idPerson);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber + "\n");
        System.out.println("email: " + mail + "\n");
    }


    //////////----Getter Functions----///////////
    public int getId(){
        return idPerson;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }

    public String getMail(){
        return mail;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public int getIdPerson(){
        return idPerson;
    }

    public boolean getType(){
        return type;
    }
}
