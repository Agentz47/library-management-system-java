package model;

public class Book {

    // ENCAPSULATED WITH PRIVATE
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author){
        this.id= id;
        this.title = title;
        this.author = author;
    }

    // ADDING GETTERS
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBook() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: "+ author);
    }
}
