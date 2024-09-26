package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("1234", "Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("5678", "Clean Code", "Robert C. Martin", 2008));
    }

    @Test
    public void testAddBook() {
        library.addBook(new Book("9101", "Refactoring", "Martin Fowler", 2012));
        assertDoesNotThrow(() -> library.borrowBook("9101"));
    }

    @Test
    public void testAddDuplicateBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("1234", "Duplicate Title", "Some Author", 2020));
        });
        assertEquals("A book with ISBN 1234 is already in the library.", exception.getMessage());
    }

    @Test
    public void testBorrowBook() {
        assertDoesNotThrow(() -> library.borrowBook("1234"));
        assertThrows(IllegalStateException.class, () -> library.borrowBook("1234"));
    }

    @Test
    public void testBorrowNonExistingBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("9999");
        });
        assertEquals("No book found with ISBN 9999.", exception.getMessage());
    }

    @Test
    public void testReturnBook() {
        library.borrowBook("5678");
        assertDoesNotThrow(() -> library.returnBook("5678"));
    }

    @Test
    public void testReturnNonBorrowedBook() {
        assertThrows(IllegalStateException.class, () -> {
            library.returnBook("5678");
        });
    }

    @Test
    public void testViewAvailableBooks() {
        library.borrowBook("1234");
        assertDoesNotThrow(() -> library.viewAvailableBooks());
    }
}
