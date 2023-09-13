package Modules;
import java.sql.*;

import Connection.DbConnection;

public class Book {
    private int id;
    private String title;
    private Author author;
    private String isbn;
    private int quantityTotal;
    private int quantity;
    private int quantityLost;
    private int quantityReserved;

    public Book(int id, String title, Author author, String isbn, int quantity, int quantityLost, int quantityReserved, int quantityTotal) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantityTotal = quantityTotal;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
        this.quantityReserved = quantityReserved;
    }


    public Book() {}

    public Book(String title, Author author, String isbn, int quantityTotal, int quantity, int quantityLost, int quantityReserved) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantityTotal = quantityTotal;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
        this.quantityReserved = quantityReserved;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityLost() {
        return quantityLost;
    }

    public void setQuantityLost(Integer quantityLost) {
        this.quantityLost = quantityLost;
    }

    public void setQuantityReserved(Integer quantityImprinted) {
        this.quantityReserved = quantityReserved;
    }

    public Integer getQuantityReserved() {
        return quantityReserved;
    }

    // start of methods

    public void getAllBooks() throws SQLException {
        try {
            Connection connection = DbConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while(rs.next()){
                System.out.println("Book Name : "+rs.getString("title") +"\n"+ "Books isbn : "+ rs.getString("isbn" )+"\n"+ "book quantity : " + rs.getString("quantity" ));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void getAvailableBooks() throws SQLException {
        try {
            Connection connection = DbConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `books` WHERE books.quantity > 0;");

            while(rs.next()){
                System.out.println("Book Name : "+rs.getString("title") +"\n"+ "Books isbn : "+ rs.getString("isbn" )+"\n"+ "book quantity : " + rs.getString("quantity" ));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public int CreateBook(Book book) {
        int updated = 0;
        try {
            if (book.getQuantityTotal() >= book.getQuantity() &&
                    book.getQuantityTotal() > book.getQuantityLost() &&
                    book.getQuantityTotal() > book.getQuantityReserved()) {

                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?,?,?)");
                ps.setInt(1, book.getId());
                ps.setString(2, book.getTitle());
                ps.setInt(3, 1);
                ps.setString(4, book.getIsbn());
                ps.setInt(5, book.getQuantityTotal());
                ps.setInt(6, book.getQuantity());
                ps.setInt(7, book.getQuantityLost());
                ps.setInt(8, book.getQuantityReserved());
                updated = ps.executeUpdate();
            } else {
                System.out.println("Validation error: quantityTotal must be greater than other quantities.");
            }
        } catch (Exception error) {
            System.out.println(error);
        }
        return updated;
    }

    public int UpdateBook(Book book) {
        int update = 0;
        try {
            if (book.getQuantityTotal() >= book.getQuantity() &&
                    book.getQuantityTotal() > book.getQuantityLost() &&
                    book.getQuantityTotal() > book.getQuantityReserved()) {

                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement("UPDATE books SET title = ?, author_id = ?, isbn = ?, quantityTotal = ?, quantity = ?, quantityLost = ?, quantityReserved = ? WHERE isbn = ?");
                ps.setString(1, book.getTitle());
                ps.setInt(2, 1);
                ps.setString(3, book.getIsbn());
                ps.setInt(4, book.getQuantityTotal());
                ps.setInt(5, book.getQuantity());
                ps.setInt(6, book.getQuantityLost());
                ps.setInt(7, book.getQuantityReserved());
                ps.setString(8, book.getIsbn());
                update = ps.executeUpdate();
            } else {
                System.out.println("Validation error: quantityTotal must be greater than other quantities.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return update;
    }
    public int DeleteBook(String title,String isbn) throws Exception{
        int status = 0;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE books.title = ? and books.isbn = ?");
            ps.setString(1, title);
            ps.setString(2, isbn);
            status = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }
    public static void SearchBookByTitle(String title) throws Exception{
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `books` WHERE books.title = ?");
            ps.setString(1,title);
            ResultSet st = ps.executeQuery();
            while(st.next()){
                System.out.println("Book Name : "+st.getString("title") +"\n"+ "Books isbn : "+ st.getString("isbn" )+"\n"+ "book quantity : " + st.getString("quantity" ));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println("Book is not exist");
        }
    }
    public static void SearchBookByAuthor(String author) throws Exception{
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `books` INNER JOIN author ON author.id WHERE author.name = ?");
            ps.setObject(1,author);
            ResultSet st = ps.executeQuery();
            while(st.next()){
                System.out.println("Book Name : "+st.getString("title") +"\n"+ "Books isbn : "+ st.getString("isbn" )+"\n"+ "book quantity : " + st.getString("quantity" ));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println("Book is not exist");
        }
    }
    public static void BookStatistics(){
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT `title` ,`isbn`,`quantity`, `quantityLost`, `quantityReserved` FROM `books`");
            ResultSet st = ps.executeQuery();
            while (st.next()){
                System.out.println("Book Name : "+st.getString("title") +"\n"+ "Books isbn : "+ st.getString("isbn" )+"\n"+ "book quantity : " + st.getString("quantity")+"\n"+ "book quantity borrowed : "+st.getString("quantityReserved")+"\n"+"lost books : "+st.getString("quantityLost"));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void AuthorStatistics(){
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `author` INNER JOIN `books` ON author.id WHERE author.id = books.author_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("author name : " +rs.getString("name") +"\n" + "Book Name : "+rs.getString("title") +"\n"+ "Books isbn : "+ rs.getString("isbn" )+"\n"+ "book quantity : " + rs.getString("quantity")+"\n"+ "book quantity borrowed : "+rs.getString("quantityReserved")+"\n"+"lost books : "+rs.getString("quantityLost"));
                System.out.println("-----------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

