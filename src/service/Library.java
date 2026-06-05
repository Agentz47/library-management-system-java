package service;

import model.Book;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Library {

    ArrayList<Book> books = new ArrayList<>();

    public void loadBooksFromFile() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("books.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id =
                        Integer.parseInt(parts[0]);

                String title = parts[1];
                String author = parts[2];

                Book book =
                        new Book(
                                id,
                                title,
                                author
                        );

                books.add(book);

            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error loading books."
            );

        }

    }

    public void addBook(Book book) {

        books.add(book);

        saveBooksToFile();
    }

    public void saveBooksToFile() {

        try {

            FileWriter writer =
                    new FileWriter("books.txt");

            for (Book book : books) {

                writer.write(
                        book.getId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "\n"
                );

            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving books."
            );

        }
    }

    public void displayAllBooks() {

        for (Book book : books) {
            book.displayBook();
            System.out.println();
        }
    }

    public void searchBook(String title) {

        for (Book book : books) { // LOOP Look at every book.
            if (book.getTitle().equalsIgnoreCase(title)) { // CONDITION

                System.out.println("model.Book Found!");
                book.displayBook();
                return; // STOP SEARCHING, EXIT THE METHOD
            }
        }

        System.out.println("model.Book Not Found!");
    }

    public void deleteBook(int id) {

        Book bookToDelete = null;

        for (Book book : books) {

            if (book.getId() == id) {

                bookToDelete = book;
                break;
            }
        }

        if (bookToDelete != null) {

            books.remove(bookToDelete);
            saveBooksToFile();
            System.out.println("model.Book Deleted Successfully!");

        } else {

            System.out.println("model.Book Not Found!");
        }
    }

    public void updateBook(int id, String newTitle, String newAuthor) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                saveBooksToFile();

                System.out.println("model.Book Updated Successfully!");

                return;
            }
        }

            System.out.println("model.Book Not Found!");
    }
}
