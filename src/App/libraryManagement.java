package App;
import Modules.Book;
import java.util.Scanner;

public class libraryManagement {
    static Book Modules = new Book();
    public static void main(String[] args) {
        String choice = "";

        do {
                System.out.println("=== Book Management System Menu ===");
                System.out.println("1. Add a Book");
                System.out.println("2. Update Book Information");
                System.out.println("3. Delete a Book");
                System.out.println("4. Search for a Book");
                System.out.println("5. List All Books");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");


            switch(choice.toUpperCase())
            {
                case "A":
                    CreateBook();
                    break;

                case "F":
                    System.out.println("******************************THANK YOU********************");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option! Please enter again");
                    break;
            }
        }while(!choice.equals("F"));
        }
    public static void CreateBook(){
        System.out.println("Enter book id");
        System.out.println("Enter book name");
        System.out.println("Enter Author name");
        System.out.println("Enter book ISBN");
        System.out.println("Enter book QuantityTotal");
    }
}

