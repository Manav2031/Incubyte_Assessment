package test.java;

import main.java.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        library.addBook("978-0132350884", "Clean Code", "Robert C. Martin", 2008);
        assertEquals(1, library.getAvailableBooks().size());
    }
}