package App;
import Modules.Author;
import Modules.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    static Book Modules = new Book();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. List of books");
            System.out.println("3. List of Available books");
            System.out.println("4. update existing book");
            System.out.println("5. Delete a book");
            System.out.println("6. Search book");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CreateBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:
                    getAvailableBooks();
                    break;
                case 4:
                    UpdateBook();
                    break;
                case 5:
                    DeleteBook();
                    break;
                case 6:
                    SearchBook();
                case 0:
                    System.out.println("Exiting the Library Management System.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }

    public static void getAllBooks() throws SQLException {
        Book book = new Book();
        book.getAllBooks();
    }
    public static void getAvailableBooks() throws SQLException {
        Book book = new Book();
        book.getAvailableBooks();
    }
    public static void CreateBook() {
        scanner.nextLine();

        System.out.println("Enter book name:");
        String title = scanner.nextLine();

        System.out.println("Enter Author name:");
        String author_name = scanner.nextLine();
        Author author = new Author(0,author_name);
        System.out.println("Enter book ISBN:");
        String isbn = scanner.nextLine();

        System.out.println("Enter book QuantityTotal:");
        int quantityTotal = scanner.nextInt();

        System.out.println("Enter book Quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter book quantity Lost:");
        int quantityLost = scanner.nextInt();

        System.out.println("Enter book quantity Reserved:");
        int quantityReserved = scanner.nextInt();

        Book book = new Book(title, author, isbn, quantityTotal,quantity,quantityLost,quantityReserved);
        int status = Modules.CreateBook(book);
        if(status ==1 )
        {
            System.out.println("Book added successfully");
        }
        else
        {
            System.out.println("ERROR while adding book");
        }
        scanner.close();
    }
    public static void UpdateBook() throws Exception {
        scanner.nextLine();

        System.out.println("Enter the book ID you want to update:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the new book name:");
        String title = scanner.nextLine();

        System.out.println("Enter the new Author name:");
        String authorName = scanner.nextLine();
        Author author = new Author(0, authorName);

        System.out.println("Enter the new book ISBN:");
        String isbn = scanner.nextLine();

        System.out.println("Enter the new book QuantityTotal:");
        int quantityTotal = scanner.nextInt();

        System.out.println("Enter the new book Quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter the new book quantity Lost:");
        int quantityLost = scanner.nextInt();

        System.out.println("Enter the new book quantity Reserved:");
        int quantityReserved = scanner.nextInt();

        Book book = new Book(bookId, title, author, isbn, quantityTotal, quantity, quantityLost, quantityReserved);
        int status = Modules.UpdateBook(book);

        if (status == 1) {
            System.out.println("Book updated successfully");
        } else {
            System.out.println("ERROR while updating book");
        }
        scanner.close();
    }


    public static void DeleteBook() throws Exception {
        scanner.nextLine();

        System.out.println("Enter Book Name");
        String name = scanner.nextLine();
        System.out.println("Enter book ISBN");
        String isbn = scanner.nextLine();
        int status = Modules.DeleteBook(name,isbn);
        if(status == 1 )
        {
            System.out.println("Book deleted successfully");
        }
        else
        {
            System.out.println("ERROR while deleting book");
        }
        scanner.close();
    }
    public static void SearchBook() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to Search by book name or 2 to search author name");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter the name of the book you want to search for:");
            String bookName = scanner.nextLine();
            Book.SearchBookByTitle(bookName);
        } else if (choice == 2) {
            System.out.println("Enter the name of the author you want to search for:");
            String author = scanner.nextLine();
            Book.SearchBookByAuthor(author);
        } else {
            System.out.println("Please enter '1' for book name or '2' for author.");
        }
        scanner.close();
    }

}
