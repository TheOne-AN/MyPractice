package library.book;

public class Book {
    private String name;
    private String id;
    private String author;
    private int price;
    private String type;
    private boolean isBorrowed;

    public Book(String name, String id, String author,
                int price, String type, boolean isBorrowed) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
