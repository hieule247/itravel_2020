package itravel.model;

import java.time.LocalDate;
import java.util.List;

public class Post {
    String id;
    String userId;
    String image;
    String title;
    String content;
    String category;
    String tags;
    String date;


    //Using for admin
    private String status; //active, deActive

    public Post() {
        this.id = "";
        this.userId = "";
        this.image = "";
        this.title = "";
        this.content = "";
        this.category = "";
        this.tags = "";
        this.date = "";
        this.status = "active";
    }

    public Post(String id, String userId, String image, String title, String content, String category, String tags, String date) {
        this.id = id;
        this.userId = userId;
        this.image = image;
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
        this.date = date;

        //using for admin
        this.status = "active";
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //public static List<Post> getPosts(String userId) {
//        return userId.getPosts();
//    }
}
