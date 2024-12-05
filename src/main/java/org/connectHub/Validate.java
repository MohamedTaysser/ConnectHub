package org.connectHub;

public class Validate {
    private String email ;
    private String pass;
    private String name ;
    int age ;

    public Validate(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public Validate(String email, String pass, String name, int age) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.age = age;
    }
    public boolean isTrueMailPass(){
        return true;

    }

}
