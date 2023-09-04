
public class Book {
    private int id;
    private String title;
    private Author author;
    private String isbn;
    private String status;
    private Integer quantity;
    private Integer quantityLost;
    private Integer quantityImprinted;

    public Book(int id ,String title, Author author, String isbn, String status, Integer quantity, Integer quantityLost, Integer quantityImprinted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
        this.quantityImprinted = quantityImprinted;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public Integer getQuantityImprinted() {
        return quantityImprinted;
    }

    public void setQuantityImprinted(Integer quantityImprinted) {
        this.quantityImprinted = quantityImprinted;
    }
    public void CreateBook(Book book){
        // create method
    }
    public void getAllBooks(Book book){
        // read method
    }
    public void UpdateBook(Book book){
        // update method
    }

    public void DeleteBook(String title,String isbn){
        // delete methode
    }
    public void SearchBook(String isbn) {
        // search method
    }
}
