package com.example.demo.entity;

public class Content {

    private Integer id;
    private int column_id;
    private String author;
    private String text;
    private String da;

    public Content(Integer id, int column_id, String author, String text, String da) {
        this.id = id;
        this.column_id = column_id;
        this.author = author;
        this.text = text;
        this.da = da;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", column_id=" + column_id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", da='" + da + '\'' +
                '}';
    }
}
