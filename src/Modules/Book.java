package Modules;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import Connection.DbConnection;
import App.libraryManagement;


public class Book {
    Connection connection = DbConnection.getConnection();
    private int id;
    private String title;
    private Author author;
    private String isbn;
    private Integer quantityTotal;
    private Integer quantity;
    private Integer quantityLost;
    private Integer quantityReserved;

    public Book(int id, String title, Author author, String isbn, Integer quantity, Integer quantityLost, Integer quantityReserved, Integer quantityTotal) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantityTotal = quantityTotal;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
        this.quantityReserved = quantityReserved;
    }

    public Book() {

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

    public Integer getQuantityReserved() {
        return quantityReserved;
    }

    public void setQuantityReserved(Integer quantityImprinted) {
        this.quantityReserved = quantityReserved;
    }
    // start of methods
    public void CreateBook(Book book){
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1,book.getId());
            ps.setString(2, book.getTitle());
            ps.setObject(3,book.getAuthor());
            ps.setString(4,book.getIsbn());
            ps.setInt(5,book.getQuantityTotal());
            ps.setInt(6,book.getQuantity());
            ps.setInt(7,book.getQuantityLost());
            ps.setInt(8,book.getQuantityReserved());
        }catch (Exception error){
            System.out.println(error);
        }
    }
    public List<Book> getAllBooks() {
        // get method
        return null;
    }
    public void UpdateBook(Book book){
        // update method
    }

    public void DeleteBook(String title,String isbn){
        // delete methode
    }
    public Book SearchBook(String isbn) {
        // search method
        return null;
    }
}

