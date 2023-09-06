import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import Connection.DbConnection;
public class Book {
    Connection connection = DbConnection.getConnection();
    private int id;
    private String title;
    private Author author;
    private String isbn;
    private String status;
    private Integer quantityConstant;
    private Integer quantity;
    private Integer quantityLost;
    private Integer quantityReserved;

    public Book(int id ,String title, Author author, String isbn, String status, Integer quantity, Integer quantityLost, Integer quantityReserved,Integer quantityConstant) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
        this.quantityReserved = quantityReserved;
        this.quantityConstant = quantityConstant;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getQuantityConstant() {
        return quantityConstant;
    }

    public void setQuantityConstant(Integer quantityConstant) {
        this.quantityConstant = quantityConstant;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
            PreparedStatement ps = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?,?,?,?)");
        }catch (Exception error){

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

