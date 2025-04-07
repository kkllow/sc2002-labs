public class Main {
    public static void main(String[] args) {
        // Create a library
        Library<Book> library = new Library<>();

        // Test Case 1: Adding Books to the Library
        System.out.println("Test Case 1: Adding Books to the Library");
        Book book1 = new Book("1984", "George Orwell", "Fiction", 1949);
        Book book2 = new Book("A Brief History of Time", "Stephen Hawking", "Science", 1988);
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("Library contains 2 books:");
        library.displayBooks();

        // Test Case 2: Filtering Books by Genre
        System.out.println("\nTest Case 2: Filtering Books by Genre (Fiction)");
        System.out.println("List of books:");
        System.out.println(library.filterByGenre("Fiction"));

        // Test Case 3: Filtering Books by Author
        System.out.println("\nTest Case 3: Filtering Books by Author (Stephen Hawking)");
        System.out.println("List of books:");
        System.out.println(library.filterByAuthor("Stephen Hawking"));

        // Test Case 4: Searching Books by Keyword
        System.out.println("\nTest Case 4: Searching Books by Keyword (Time)");
        System.out.println("List of books:");
        System.out.println(library.searchBooks("Time"));

        // Test Case 5: Add and Sort Books by Title
        System.out.println("\nTest Case 5: Sorting Books by Title");
        Book book3 = new Book("A Beautiful Mind", "Sylvia Nasar", "Biography", 1998);
        library.addBook(book3);
        System.out.println("Sorted Order by Title:");
        library.sortBooksByTitle().forEach(System.out::println);

        // Test Case 6: Providing Recommendations
        System.out.println("\nTest Case 6: Providing Recommendations (Science)");
        System.out.println(library.recommendBook("Science"));

        // Test Case 7: Borrower Operations (Borrow)
        System.out.println("\nTest Case 7: Borrower Operations (Borrow)");
        library.borrowBook("Alice", book1);
        Borrower alice = library.findBorrower("Alice");
        System.out.println("Borrower details:");
        System.out.println(alice);

        // Test Case 8: Borrower Operations (Return)
        System.out.println("\nTest Case 8: Borrower Operations (Return)");
        library.returnBook("Alice", book1);
        System.out.println("Borrower details:");
        System.out.println(alice);
    }
}