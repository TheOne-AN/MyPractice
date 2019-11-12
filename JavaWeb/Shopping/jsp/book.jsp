<%@page import="Shopping.BookGlobal"%>
<%@page import="Shopping.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车</title>
</head>
<body>
<center>
<table border="1px">
    <caption>商品列表</caption>
    <td>序列号</td>
    <td>名称</td>
    <td>价格</td>
    <td>商家</td>
    <td>添加到购物车</td>
    <tr>

   <%
       List<Book> books = new BookGlobal().getBooks();
   %>



        <%

        for (int i = 0;i < books.size();i++) {
        %>
        <td><%=books.get(i).getId()%></td>
        <td><%=books.get(i).getName()%></td>
        <td><%=books.get(i).getPrice()%></td>
        <td><%=books.get(i).getAuthor()%></td>

        <td> <a href="<%=request.getContextPath()%>/BookServlet?id=<%=books.get(i).getId()%>">添加商品到购物车</a> </td>

    </tr>

    <%
        }
    %>
</table>

<hr />
<a href="<%=request.getContextPath()%>/shopping/display.jsp">查询购物车商品</a>
</center>
</body>
</html>