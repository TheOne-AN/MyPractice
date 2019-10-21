package library.operation;

import library.book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("Byebye!(^ _ ^)");
        /*0是程序结束代码*/
        System.exit(0);
    }
}
