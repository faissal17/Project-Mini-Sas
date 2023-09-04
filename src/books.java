
public class books {
    protected String title;
    protected String author;
    protected String isbn;
    protected String status;
    protected Integer quantity;
    protected Integer quantityLost;

    public books (String title, String author, String isbn, String status, Integer quantity, Integer quantityLost) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.quantity = quantity;
        this.quantityLost = quantityLost;
    }
}

