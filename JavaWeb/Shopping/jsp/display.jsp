<%@page import="java.util.Set"%>
<%@page import="java.util.Collection"%>
<%@page import="Shopping.Book"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table border="1px">
    <caption>购物车信息</caption>
    <tr>
        <td>商品名</td>
        <td>价格</td>
        <td>店铺</td>
        <td>数量</td>
    </tr>


    <%
        Map<Book, Integer> cart = (Map<Book, Integer>) request.getSession().getAttribute("cart");

        if (cart != null && cart.size() != 0) {
            Set<Book> books = cart.keySet();
            for (Book book : books) {
    %>
    <tr>
        <td><%=book.getName()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getAuthor()%></td>
        <td><%=cart.get(book)%></td>
    </tr>
    <%
            }
        }
    %>


</table>

<a href="book.jsp">继续购物</a>

</body>
</html>
