package org.connectHub;
public class userLogin {
    private int id;
    private String email,pass;
    public userLogin(String email , String pass){
        this.email = email;
        this.pass = pass ;
    }
    public int login(){
        Validate valid = new Validate(this.email , this.pass);
        if(valid.isTrueMailPass()){
            DBcon person = new DBcon(this.email , this.pass);
            if(person.searchForUserLogin()!=null) {
                return person.getId();
            }
        }
            return 0;

    }

}