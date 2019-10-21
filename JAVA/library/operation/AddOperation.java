package library.operation;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新添加一本书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.next();
        System.out.println("请输入编号：");
        String id = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        System.out.println("请输入类别：");
        String type = scanner.next();
        Book book = new Book(name,id,author,price,type,false);
        bookList.setBook(bookList.getSize(),book);
        bookList.setSize(bookList.getSize()+1);
    }
}
