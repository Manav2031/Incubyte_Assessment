package test.java;

import main.java.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Library class.
 * The tests cover adding, borrowing, returning books, and viewing available books.
 */
class LibraryTest {

    // The Library object used in the tests
    private Library library;

    /**
     * Set up a new Library object before each test.
     * This ensures each test runs independently with a fresh Library instance.
     */
    @BeforeEach
    void setUp() {
        library = new Library();
    }

    /**
     * Test that adding a book increases the number of available books in the library.
     */
    @Test
    void testAddBook() {
        library.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 2008);
        // Assert that the library contains one available book after adding it
        assertEquals(1, library.getAvailableBooks().size());
    }

    /**
     * Test that borrowing an available book decreases the number of available books.
     */
    @Test
    void testBorrowBook_Success() {
        library.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 2008);
        library.borrowBook("978-0132350884");
        // Assert that the book is no longer available after borrowing it
        assertEquals(0, library.getAvailableBooks().size());
    }

    /**
     * Test that attempting to borrow an unavailable book throws an exception.
     * The exception message should indicate that the book is not available.
     */
    @Test
    void testBorrowBook_NotAvailable() {
        library.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 2008);
        library.borrowBook("978-0132350884");
        // Attempt to borrow the same book again, expecting an IllegalStateException
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            library.borrowBook("978-0132350884");
        });
        // Verify the exception message
        assertEquals("Book not available", exception.getMessage());
    }

    /**
     * Test that returning a borrowed book makes it available again.
     */
    @Test
    void testReturnBook() {
        library.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 2008);
        library.borrowBook("978-0132350884");
        library.returnBook("978-0132350884");
        // Assert that the book is available again after being returned
        assertEquals(1, library.getAvailableBooks().size());
    }
}
