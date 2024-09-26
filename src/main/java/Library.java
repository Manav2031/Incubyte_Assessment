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

    /**
     * Allows a user to borrow a book from the library if it's available.
     *
     * @param isbn The ISBN of the book to be borrowed
     * @throws IllegalStateException if the book is not available or doesn't exist
     */
    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        // Check if the book exists and is available for borrowing
        if (book != null && book.isAvailable()) {
            book.setAvailable(false); // Mark the book as borrowed
        } else {
            throw new IllegalStateException("Book not available");
        }
    }

     /**
     * Allows a user to return a previously borrowed book.
     *
     * @param isbn The ISBN of the book to be returned
     */
    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        // Check if the book exists and is currently borrowed
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true); // Mark the book as available again
        }
    }

    /**
     * Retrieves a list of all available books in the library.
     *
     * @return A list of books that are available for borrowing
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        // Loop through all the books and collect the ones that are available
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
