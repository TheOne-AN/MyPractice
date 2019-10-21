package library.operation;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("请输入要删除的书的编号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int i = 0;
        for (i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getId().equals(id)) {
                System.out.println("已找到"+book.getName()+"书。");
                Book lastBook = bookList.getBook(bookList.getSize()-1);
                bookList.setBook(i,lastBook);
                bookList.setSize(bookList.getSize() - 1);
                System.out.println("删除成功。");
                break;
            }
        }
        if (i>=bookList.getSize()-1) {
            System.out.println("查无此书");
        }
    }
}
