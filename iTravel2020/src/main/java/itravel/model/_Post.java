package itravel.model;

public class _Post {
    private String id;
    private String userId;
    private String image;
    private String title;
    private String content;
    private String category;
    private String tags;
    // Using for admin
    private String status; // active, deActive

    public _Post() {
        this.id         = "";
        this.userId     = "";
        this.image      = "";
        this.title      = "";
        this.content    = "";
        this.category   = "";
        this.tags       = "";
        // using for admin
        this.status     = "active";
    }

    public _Post(String id, String userId, String image, String title, String content, String category, String tags) {
        this.id         = id;
        this.userId     = userId;
        this.image      = image;
        this.title      = title;
        this.content    = content;
        this.category   = category;
        this.tags       = tags;
        // using for admin
        this.status     = "active";
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
