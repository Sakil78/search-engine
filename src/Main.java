import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();

        // 1) Try to load from serialized file:
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded from library.ser");
        } else {
            System.out.println("No saved library found. Loading data from books.txt...");
            library.loadBooks("src/resources/data/books.txt");
        }

        // 2) Launch the menu (now that the library is already loaded):
        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();

        // 3) On exit, persist the current state:
        serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
        System.out.println("Library saved to library.ser");
    }
}
