package ru.frank.model;

public class VkMessage {

    private String id;
    private int date;
    private int out;
    private int userId;
    private int readState;
    private String title;
    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReadState() {
        return readState;
    }

    public void setReadState(int readState) {
        this.readState = readState;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "VkMessage{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", out=" + out +
                ", userId=" + userId +
                ", readState=" + readState +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
