package library.book;

public class BookList {
    private  Book books[] = new Book[1000];
    private int size;

    public BookList() {
        books[0] = new Book("《JAVA从入门到入土》","01","国家863中部",
                100,"计算机类",false);
        books[1] = new Book("《C语言从入门到入土》","02","韩旭",
                100,"计算机类",false);
        books[2] = new Book("《C++从入门到入土》","03","徐兆元",
                100,"计算机类",false);
        books[3] = new Book("《Python从入门到入土》","004","叶维忠",
                100,"计算机类",false);
        size = 4;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void setBook(int index,Book book) {
        books[index] = book;
    }
}
