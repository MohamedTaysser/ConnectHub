package org.content;

import java.time.LocalDate;
import java.util.List;

public class post implements posts {
    String text;
    String img;
    LocalDate date;

    public post(String text, String img) {
        this.text = text;
        this.img = img;
        this.date = LocalDate.now();
    }

    @Override
    public void publish() {
        try {
            DBpost post = new DBpost(this.text, this.img, this.date, 1);
            post.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void view() {
        try {
            DBpost db = new DBpost();
            db.view();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
