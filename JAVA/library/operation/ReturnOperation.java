package library.operation;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要还的书的编号：");
        String id = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (!book.getId().equals(id)) {
                continue;
            }
            System.out.println("您已成功归还"+book.getName()+"书。");
            book.setBorrowed(false);
            break;
        }

    }
}
