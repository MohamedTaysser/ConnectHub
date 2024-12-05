package org.connectHub;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class DBcon {
    private String email;
    private String pass;
    int id;
    private String name;
    private String dateOfBirth;
    private static final String FILE_PATH = "users.json";

    public DBcon() {
    }

    public DBcon(String email, String pass, int id, String name, String dateOfBirth) {
        this.email = email;
        this.pass = pass;
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public DBcon(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public DBcon searchForUserLogin() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<DBcon> users = objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<DBcon>>() {});
            Optional<DBcon> matchedUser = users.stream()
                    .filter(user -> user.getEmail().equals(email) && user.getPass().equals(pass))
                    .findFirst();
            return matchedUser.orElse(null);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void addUser() {
        // Check for null in attributes and handle it appropriately
        ObjectMapper objectMapper = new ObjectMapper();
        List<DBcon> users;

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                // Read the existing users from the file
                users = objectMapper.readValue(file, new TypeReference<List<DBcon>>() {});
            } else {
                // If no file exists, create an empty list
                users = new ArrayList<>();
            }

            // Create a new DBcon instance using the current object's fields
            DBcon newUser = new DBcon(this.email, this.pass, this.id, this.name, this.dateOfBirth);

            // Add the new user to the list
            users.add(newUser);

            // Write the updated user list back to the file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, users);

            System.out.println("Sign up successfully!");
        } catch (IOException e) {
            System.out.println("Sign up failed: " + e.getMessage());
            e.printStackTrace();
        }
    }



    }









