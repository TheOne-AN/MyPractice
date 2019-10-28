<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pw = request.getParameter("upw");
		if(name.equals("张三") && pw.equals("123")){
			//response.sendRedirect("success.jsp");重定向导致数据丢失
			//请求转发 request
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			out.print("用户名或密码有误！");
		}
		%>
</body>
</html>