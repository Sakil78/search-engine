
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {
    /**
     * Serializes the list of books to the given file.
     */

    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // TODO - missing code
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes and returns the list of books from the given file.
     * Returns null if the file doesn’t exist, is empty, or on error.
     */
    @SuppressWarnings("unchecked")
    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // TODO - missing code
            return (List<Book>) ois.readObject();
        } catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

