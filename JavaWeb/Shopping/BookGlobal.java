package Shopping;

import java.util.ArrayList;
import java.util.List;

public class BookGlobal {
    static List<Book> bookList;

    static {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("<1>","西凤酒","10","西凤酒厂"));
        bookList.add(new Book("<2>","汾酒","20","杏花村"));
        bookList.add(new Book("<3>","茅台酒","30","贵州茅台"));
        bookList.add(new Book("<4>","五粮液","40","五粮液集团"));
    }

    public static List<Book> getBooks() {
        return bookList;
    }

    public static Book getBookById(String id) {
        Book book = new Book();
        book.setId(id);
        int index = bookList.indexOf(book);
        return bookList.get(index);
    }

}
