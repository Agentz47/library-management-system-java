//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.Book;
import service.Library;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("books.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                //System.out.println(line);

            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error Reading File");

        }

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Library library = new Library();
        library.loadBooksFromFile();


        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n==== LIBRARY MENU ====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.println("Enter choice: ");

            int choice;

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {

                System.out.println("Please enter a number!");

                scanner.nextLine();

                continue;
            }
            //scanner.nextLine();

            switch (choice) {

                case 1:


                    System.out.println("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (id <= 0) {

                        System.out.println("ID must be greater than 0!");

                        break;
                    }

                    if (library.idExists(id)) {

                        System.out.println("Book ID already exists!");

                        break;
                    }

                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    if (title.isBlank()) {

                        System.out.println("Title cannot be empty!");

                        break;
                    }

                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    if (author.isBlank()) {

                        System.out.println("Author cannot be empty!");

                        break;
                    }



                    Book newBook = new Book(id, title, author);

                    library.addBook(newBook);

                    System.out.println("Book Added Successfully!");
                    break;

                case 2:

                    library.displayAllBooks();

                    break;

                case 3:

                    System.out.println("Enter book title: ");

                    String searchTitle = scanner.nextLine();

                    library.searchBook(searchTitle);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");

                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();

                    library.updateBook(
                            updateId,
                            newTitle,
                            newAuthor
                    );

                    break;

                case 5:

                    System.out.println("Enter Book ID to Delete: ");

                    int deleteID = scanner.nextInt();
                    scanner.nextLine();

                    library.deleteBook(deleteID);

                    break;

                case 6:
                    System.out.println("Goodbye!");

                    running = false;

                    break;

                default:

                    System.out.println("Invalid Choice!");

                    break;
            }
        }
    }
}