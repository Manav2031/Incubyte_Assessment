package main.java;

import java.util.*;

/**
 * Represents a library system where users can add, borrow, and return books.
 * It maintains a collection of books and tracks their availability.
 */
public class Library {
    // A map to store books, with the key as the ISBN and the value as the Book object
    private Map<String, Book> books = new HashMap<>();

    /**
     * Adds a new book to the library.
     *
     * @param isbn  The ISBN of the book (must be unique)
     * @param title The title of the book
     * @param author The author of the book
     * @param year  The publication year of the book
     */
    public void addBook(String isbn, String title, String author, int year) {
        // Only add the book if it doesn't already exist in the library
        if (!books.containsKey(isbn)) {
            books.put(isbn, new Book(isbn, title, author, year, true));
        }
    }
}
