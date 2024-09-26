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
}
