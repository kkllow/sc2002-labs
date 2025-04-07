public interface Searchable {
    boolean matches(String keyword);

    // Default method to provide a shared functionality
    default String searchMessage(String keyword) {
        return String.format("Searching for keyword: %s", keyword);
    }
}