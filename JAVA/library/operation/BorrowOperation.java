package library.operation;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍。");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的书的编号：");
        String id = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if ( !book.getId().equals(id)) {
                continue;
            }
            if (book.isBorrowed()) {
                System.out.println("这本书已经被借走了");
                break;
            }
            System.out.println("你已经成功借阅"+book.getName()+"。");
            book.setBorrowed(true);
        }

    }
}
