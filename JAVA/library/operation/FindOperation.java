package library.operation;

import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书名：");
        String name = scanner.nextLine();
        int count = 0;//计数器
        for (int i = 0; i < bookList.getSize() ; i++) {

            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("抱歉，查无此书。");
        }else {
            System.out.println("共计找到"+count+"本书。");
        }
    }
}
