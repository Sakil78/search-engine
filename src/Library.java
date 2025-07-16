
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
               //  TODO - missing code
                // skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title  = parts[0].trim();
                    String author = parts[1].trim();
                    String yearStr = parts[2].trim();

                    try {
                        int publicationYear = Integer.parseInt(yearStr);
                        Book book = new Book(title, author, publicationYear);
                        books.add(book);
                    } catch (NumberFormatException nfe) {
                        System.err.println("Skipping line with invalid year: " + line);
                    }
                } else {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Searches for the first book whose title or author contains the given keyword
     * (case-insensitive), or whose publication year exactly matches the keyword.
     *
     * @param keyword the search term (title, author, or year)
     * @return the first matching Book, or null if none found
     */
    public Book searchBookByKeyword(String keyword) {
        if (keyword == null) return null;
        keyword = keyword.toLowerCase();                    // TODO 9

        for (Book book : books) {                           // TODO 10
            String titleLower  = book.getTitle().toLowerCase();
            String authorLower = book.getAuthor().toLowerCase();
            String yearStr     = Integer.toString(book.getPublicationYear());

            // TODO 11: check if any field matches
            if (titleLower.contains(keyword)
                    || authorLower.contains(keyword)
                    || yearStr.equals(keyword)) {
                return book;
            }
        }

        return null;                                        // no match
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
