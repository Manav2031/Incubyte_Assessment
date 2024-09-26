package main.java;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}