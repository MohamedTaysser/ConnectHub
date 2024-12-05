package org.content;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.connectHub.DBcon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public class DBpost {
    private String text;
    private String img;
    private LocalDate date;
    private int type;
    private static final String FILE_PATH = "posts.json";

    public DBpost(String text, String img, LocalDate date, int type) {
        this.text = text;
        this.img = img;
        this.date = date;
        this.type = type;
    }

    public DBpost() {
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }

    public LocalDate getDate() {
        return date;
    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        List<DBpost> posts;
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                posts = mapper.readValue(file, new TypeReference<List<DBpost>>() {
                });

            } else {
                posts = new ArrayList<>();

            }
            DBpost post = new DBpost(this.text, this.img, this.date, this.type);
            posts.add(post);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, posts);


        } catch (Exception e) {
            return;
        }


    }


    public void view() {
        ObjectMapper map = new ObjectMapper();
        List<DBpost> posts;

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                posts = map.readValue(file, new TypeReference<List<DBpost>>() {});

                for (DBpost post : posts) {
                    switch (this.type) {
                        case 0:
                            System.out.println("Text: " + post.getText());
                            System.out.println("Image: " + post.getImg());
                            System.out.println("Date: " + post.getDate());
                            System.out.println("Type: " + post.type);
                            System.out.println("-------------------");
                            break;

                        case 1: //storu
                            if (post.getImg() != null && !post.getImg().isEmpty()) {
                                System.out.println("Text: " + post.getText());
                                System.out.println("Image: " + post.getImg());
                                System.out.println("Date: " + post.getDate());
                                //type ` is story check if date diff from now and the date od sorty is 25 hours skip
                                System.out.println("-------------------");
                            }
                            break;
                    }
                }
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}