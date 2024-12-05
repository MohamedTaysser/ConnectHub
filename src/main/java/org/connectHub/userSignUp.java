package org.connectHub;

public class userSignUp {
        private String email;
        private String pass;
        int id;
        private String name;
        private String dateOfBirth;

        public userSignUp(String email, String pass, int id, String name, String dateOfBirth) {
            this.email = email;
            this.pass = pass;
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }
boolean signUp(){
            int flag = 0;
            try{
                DBcon person = new DBcon();
                person.addUser();
            } catch (Exception e) {
                return false;
            }
            return true;



}

}
