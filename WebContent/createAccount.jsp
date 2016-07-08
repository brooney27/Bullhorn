<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Create Account</title>
</head>
<body>
<h1>Sign up for Bullhorn</h1>
<div class="container">
<div class="row">
<div class="columns small-8 medium-5"> 
<form action="CreateUser" method="get">
<input type="text" class="form-control" placeholder="Email" name="email" id="email" value="" required autofocus></input>
<input type="text" class="form-control" placeholder="Name" name="name" id="name" value=""></input>
<input type="text" class="form-control" placeholder="Motto" name="motto" id="motto" value=""></input>
<input type="password" class="form-control" placeholder="Password" name="password" id="password" value=""></input>
<input type="hidden" name="secretvalue" id="secretvalue" value="loginForm"></input>
<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" id="submit" value="Create Account"></input>
</form>
<p>Already have an account? <a href="login.jsp">Login</a></p>
</div>
</div>
</div>
</body>
</html>
