import java.util.ArrayList;
public class Library {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {

        books.add(book);
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

                System.out.println("Book Found!");
                book.displayBook();
                return; // STOP SEARCHING, EXIT THE METHOD
            }
        }

        System.out.println("Book Not Found!");
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
            System.out.println("Book Deleted Successfully!");

        } else {

            System.out.println("Book Not Found!");
        }
    }

    public void updateBook(int id, String newTitle, String newAuthor) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setTitle(newTitle);
                book.setAuthor(newAuthor);

                System.out.println("Book Updated Successfully!");

                return;
            }
        }

            System.out.println("Book Not Found!");
    }
}
