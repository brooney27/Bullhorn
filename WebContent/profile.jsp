<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if(session.getAttribute("user")==null){
	response.sendRedirect(request.getContextPath()+"/login.jsp");	
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<form action="ValidateUser" method="get">
Email:<input type="text" name="email" id="email" value="${user.useremail}"></input>
Name:<input type="text" name="name" id="name" value="${user.username}"></input>
New Password:<input type="password" name="password" id="password" value=""></input>
Motto:<input type="text" name="motto" id="motto" value="${user.motto}"></input>
<input type="submit" name="submit" id="submit" value="Submit Changes"></input>
</form>
</body>
</html>