import java.util.*;
import java.util.stream.Collectors;

public class Library<T extends Book> {
    private List<T> books;
    private Set<String> genres;
    private Map<String, List<T>> authorToBooks;
    private List<Borrower> borrowers;

    public Library() {
        this.books = new ArrayList<>();
        this.genres = new HashSet<>();
        this.authorToBooks = new HashMap<>();
        this.borrowers = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(T book) {
        books.add(book);
        genres.add(book.getGenre());
        authorToBooks.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(book);
    }

    // Remove a book from the library
    public void removeBook(T book) {
        books.remove(book);
        List<T> authorBooks = authorToBooks.get(book.getAuthor());
        if (authorBooks != null) {
            authorBooks.remove(book);
            if (authorBooks.isEmpty()) {
                authorToBooks.remove(book.getAuthor());
            }
        }
        // Update genres
        genres.clear();
        books.forEach(b -> genres.add(b.getGenre()));
    }

    // Retrieve all books
    public List<T> getBooks() {
        return new ArrayList<>(books);
    }

    // Filter books by genre using Streams and Lambda
    public List<T> filterByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Filter books by author using Streams and Lambda
    public List<T> filterByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Search books by keyword using Streams and Lambda
    public List<T> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.matches(keyword))
                .collect(Collectors.toList());
    }

    // Sort books by title
    public List<T> sortBooksByTitle() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    // Display all books using enhanced for loop
    public void displayBooks() {
        for (T book : books) {
            System.out.println(book);
        }
    }

    // Recommend a book based on category (genre) using switch expression
    public String recommendBook(String category) {
        return switch (category.toLowerCase()) {
            case "science" -> {
                Optional<T> scienceBook = books.stream()
                        .filter(book -> book.getGenre().equalsIgnoreCase("Science"))
                        .findFirst();
                yield scienceBook.map(book -> "Recommendation: Try '" + book.getTitle() + "' by " + book.getAuthor() + ".")
                        .orElse("No science books available.");
            }
            case "fiction" -> {
                Optional<T> fictionBook = books.stream()
                        .filter(book -> book.getGenre().equalsIgnoreCase("Fiction"))
                        .findFirst();
                yield fictionBook.map(book -> "Recommendation: Try '" + book.getTitle() + "' by " + book.getAuthor() + ".")
                        .orElse("No fiction books available.");
            }
            default -> "Category not supported.";
        };
    }

    // Borrower operations
    public void addBorrower(String name) {
        borrowers.add(new Borrower(name));
    }

    public Borrower findBorrower(String name) {
        return borrowers.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void borrowBook(String borrowerName, T book) {
        Borrower borrower = findBorrower(borrowerName);
        if (borrower == null) {
            borrower = new Borrower(borrowerName);
            borrowers.add(borrower);
        }
        borrower.borrowBook(book);
    }

    public void returnBook(String borrowerName, T book) {
        Borrower borrower = findBorrower(borrowerName);
        if (borrower != null) {
            borrower.returnBook(book);
        }
    }
}