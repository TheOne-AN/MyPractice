package Shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1. 得到商品id
        String id = request.getParameter("id");
        //2. 将商品放大购物车中，将购物车做成一个map
        Map<Book, Integer> cart = (Map<Book, Integer>) request.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<Book, Integer>();
        }
        Book book = BookGlobal.getBookById(id);
        Integer count = cart.get(book);//获得指定id的书籍对象
        if(count == null) {
            count = 1;
        }else {
            count += 1;
        }
        cart.put(book,count);
        request.getSession().setAttribute("cart", cart);
        response.getWriter().write("<a href='/shopping/book.jsp'>继续购物</a>&nbsp;&nbsp;<a href='/shopping/display.jsp'>查看购物车</a>");

    }
}