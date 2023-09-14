package App;
import Modules.Author;
import Modules.Book;
import Modules.Reservation;
import Modules.User;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryManagement {
    static Book Modules = new Book();

    static Reservation ModulesReservation = new Reservation();
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
            System.out.println("7. Reserve a book");
            System.out.println("8. view the statistics");
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
                    break;
                case 7:
                    reserveBook();
                    break;
                case 8:
                    statistics();
                    break;
                case 0:
                    System.out.println("Exiting the Library Management System.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book name:");
        String title = scanner.nextLine();

        System.out.println("Enter Author name:");
        String authorName = scanner.nextLine();
        Author author = new Author(0, authorName);

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

        Book book = new Book(title, author, isbn, quantityTotal, quantity, quantityLost, quantityReserved);
        int status = Modules.CreateBook(book);

        if (status == 1) {
            System.out.println("Book added successfully");
        } else {
            System.out.println("ERROR while adding book");
        }
    }
    public static void UpdateBook() throws Exception {
        scanner.nextLine();

        System.out.println("Enter the book ISBN you want to update:");
        String isbn = scanner.nextLine();

        System.out.println("Enter the new book name:");
        String title = scanner.nextLine();

        System.out.println("Enter the new Author name:");
        String authorName = scanner.nextLine();
        Author author = new Author(0, authorName);

        System.out.println("Enter the book new ISBN:");
        String NewIsbn = scanner.nextLine();

        System.out.println("Enter the new book QuantityTotal:");
        int quantityTotal = scanner.nextInt();

        System.out.println("Enter the new book Quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter the new book quantity Lost:");
        int quantityLost = scanner.nextInt();

        System.out.println("Enter the new book quantity Reserved:");
        int quantityReserved = scanner.nextInt();

        Book book = new Book(title, author, isbn,quantityTotal, quantity, quantityLost, quantityReserved);
        int status = Modules.UpdateBook(book);

        if (status == 1) {
            System.out.println("Book updated successfully");
        } else {
            System.out.println("ERROR while updating book");
        }
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
    }

    public static void reserveBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book ISBN:");
        String isbn = scanner.nextLine();

        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Enter your ID card:");
        String userIdCard = scanner.nextLine();

        System.out.println("Enter your phone number:");
        String userPhone = scanner.nextLine();

        System.out.println("Enter the date of reservation (yyyy-MM-dd HH:mm:ss):");
        String reservationDateStr = scanner.nextLine();
        Timestamp reservationDate = null;

        // Prompt for the date of return
        System.out.println("Enter the date of return (yyyy-MM-dd HH:mm:ss):");
        String returnDateStr = scanner.nextLine();
        Timestamp returnDate = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date ReservationDate = dateFormat.parse(reservationDateStr);
            reservationDate = new Timestamp(ReservationDate.getTime());

            Date ReturnDate = dateFormat.parse(returnDateStr);
            returnDate = new Timestamp(ReturnDate.getTime());
        } catch (ParseException e) {
            System.out.println(e);
            return;
        }

        User user = new User();
        user.setName(userName);
        user.setIdCard(userIdCard);
        user.setPhone(userPhone);

        Reservation reservation = new Reservation();
        reservation.setBookIsbn(isbn);
        reservation.setUser(user);
        reservation.setDateDeReservation(reservationDate);
        reservation.setDateDeReturn(returnDate);

        reservation.ReserveBook();
    }
    public static void statistics(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to see book statistics, Enter 2 to see author statistics");
        int choice = scanner.nextInt();
        if(choice == 1){
            Book book = new Book();
            book.BookStatistics();
        } else if (choice == 2) {
            Book book = new Book();
            book.AuthorStatistics();
        }
    }
}
