package library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("A book with ISBN " + book.getIsbn() + " is already in the library.");
        }
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("No book found with ISBN " + isbn + ".");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("The book with ISBN " + isbn + " is currently borrowed.");
        }
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("No book found with ISBN " + isbn + ".");
        }
        if (book.isAvailable()) {
            throw new IllegalStateException("The book with ISBN " + isbn + " has not been borrowed.");
        }
        book.setAvailable(true);
    }

    public void viewAvailableBooks() {
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}
