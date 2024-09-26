package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1234", "Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("5678", "Clean Code", "Robert C. Martin", 2008));

        // Borrow a book
        library.borrowBook("1234");

        // Display available books after borrowing
        System.out.println("Books available after borrowing 'Effective Java':");
        library.viewAvailableBooks();

        // Return the previously borrowed book
        library.returnBook("1234");

        // Display available books after returning the book
        System.out.println("Books available after returning 'Effective Java':");
        library.viewAvailableBooks();
    }
}
