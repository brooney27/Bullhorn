<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>

<%if(session.getAttribute("user")==null){
	response.sendRedirect(request.getContextPath()+"/login.jsp");	
}%>
<fmt:setLocale value="en_US"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Home</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<h1>Welcome, ${user.username}!</h1>

<form role="form" action="Post" method="post" onsubmit="return validate(this);">
                <div class="form-group">  
                    <label for="post">Create New Post (141 char):</label>
                    <textarea name= "posttext" id="posttext" class="form-control" rows="2" placeholder= "Express yourself!" maxlength="141"></textarea>
                    <div id="textarea_feedback"></div>
                    </div> 
                    <div class = "form-group"> 
                    <input type="submit" value="Submit" id="submit"/>
                    <input type="reset" value="Clear"/>
                </div>  
</form>
<br>Your posts
<table class="table table-bordered table-striped table-hover">
    <thead>
        <tr><th>User</th><th>Post</th><th>Date</th></tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
    <c:if test="${post.bhpost==null}">
        <tr><td><c:out value="${post.bhuser.useremail}"/></td>
        <td><c:out value="${post.posttext}"/></td>
        <td><fmt:formatDate value="${post.postdate}" pattern="yy-MM-dd"/></td>
        </tr>
    </c:if>
    </c:forEach>
    </tbody>
</table>

<script>
$(document).ready(function() {
    var text_max = 141;
    $('#textarea_feedback').html(text_max + ' characters remaining');
    $('#posttext').keyup(function() {
        var text_length = $('#posttext').val().length;
        var text_remaining = text_max - text_length;
        $('#textarea_feedback').html(text_remaining + ' characters remaining');
    });
});
function validate(form) {
	valid = true;
	if ($('#posttext').val().length==0){
		alert("You may not submit an empty post.");
		valid = false;
	}
	return valid;
}
</script>

</body>
</html>

