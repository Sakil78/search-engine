import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private final Library library;
    private final UserInteractionLogger logger = new UserInteractionLogger();

    public LibraryMenu(Library library) {
        this.library = library;
        // ← No loading or serialization here
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books by Title");
            System.out.println("3. Sort Books by Author");
            System.out.println("4. Sort Books by Year");
            System.out.println("5. Search for a Book by Keyword");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.println("-- All Books --");
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                    break;

                case "2":
                    System.out.println("-- Sorting by Title --");
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    logger.logSort("Title");
                    break;

                case "3":
                    System.out.println("-- Sorting by Author --");
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    logger.logSort("Author");
                    break;

                case "4":
                    System.out.println("-- Sorting by Year --");
                    List<Book> books = library.getBooks();
                    SortUtil.quickSort(books, Comparator.comparingInt(Book::getPublicationYear), 0, books.size() - 1);
                    library.viewAllBooks();
                    logger.logSort("Year");
                    break;

                case "5":
                    System.out.print("Enter keyword (title, author, or year): ");
                    String keyword = scanner.nextLine().trim();
                    Book found = library.searchBookByKeyword(keyword);
                    if (found != null) {
                        System.out.println("Book found: " + found);
                        logger.logSearch(keyword);
                    } else {
                        System.out.println("Book not found.");
                        logger.log("Search for: " + keyword + " - no match");
                    }
                    break;

                case "6":
                    logger.log("Exited program");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
