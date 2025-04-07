public class Book implements Searchable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public String toString() {
        return String.format("{\"title\": \"%s\", \"author\": \"%s\", \"genre\": \"%s\", \"publicationYear\": %d}",
                title, author, genre, publicationYear);
    }

    @Override
    public boolean matches(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase()) ||
               author.toLowerCase().contains(keyword.toLowerCase());
    }
}