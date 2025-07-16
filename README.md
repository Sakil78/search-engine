# Java Library Search Engine

A simple Java-based library search engine for managing and searching a collection of books. This project demonstrates file I/O, serialization, logging, and basic search/sort algorithms in Java.

## Project Structure

```
/project-root
│
├── src/
│   ├── Book.java                  # Book entity class
│   ├── Library.java               # Core library logic (load, search, view)
│   ├── LibraryMenu.java           # Console menu for user interaction
│   ├── LibrarySerializer.java     # Serialization/deserialization logic
│   ├── Main.java                  # Application entry point
│   ├── SortUtil.java              # Sorting utilities
│   ├── UserInteractionLogger.java # User action logging
│   └── resources/
│       ├── data/
│       │   ├── books.txt              # Initial book data (title, author, year)
│       │   ├── library.ser            # Serialized library state
│       │   └── user_interactions.log  # User actions log
│       └── test/
│           └── test_books.txt         # Practice data file
└── search engine.iml
```

## Features
- **Load Books:** Reads book data from `books.txt` (title, author, year per line).
- **View All Books:** Displays the current collection.
- **Search:** Find books by title, author, or publication year (case-insensitive).
- **Sort:** Sort books by title, author, or year.
- **Persistence:** Saves and loads library state using serialization (`library.ser`).
- **Logging:** Records user actions in `user_interactions.log`.

## How to Run
1. **Compile:**
   ```
   javac -d bin src/*.java
   ```
2. **Run:**
   ```
   java -cp bin Main
   ```

## Data File Format
- `books.txt` (in `src/resources/data/`):
  - Each line: `Title, Author, Year`
  - Example:
    ```
    The Hobbit, J.R.R. Tolkien, 1937
    To Kill a Mockingbird, Harper Lee, 1960
    ```

## Customization
- Add or edit books in `books.txt` to change the initial library.
- Use `test_books.txt` in `src/resources/test/` for practice or testing.

## License
This project is for educational purposes.

