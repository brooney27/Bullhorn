<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="bootstrap.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Newsfeed</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<table class="table table-bordered table-striped table-hover">
    <thead>
        <tr><th></th><th>User</th><th>Post</th><th>Mood</th></tr>
    </thead>
    <tbody>
    <c:forEach var="f" items="${feed}">
    <c:if test="${f.post.bhpost==null}">
    	<tr><td><img src="${f.gravatar}"></td>
        <td><c:out value="${f.post.bhuser.username}"/>
        <form action="Follow" method="get">
            <input type="submit" value="Follow" id="submit"/>
            <input type="hidden" value="${f.post.bhuser.useremail}" name="follow" id="follow"/>
        </form></td>
        <td><c:out value="${f.post.posttext}"/></td>
        <td>
        <c:if test="${f.post.mood > 0}">:D</c:if>
        <c:if test="${f.post.mood < 0}">:(</c:if>
        <c:if test="${f.post.mood == 0}">:|</c:if>
        </td>
        </tr>
        <c:forEach var="c" items="${f.post.bhposts}">
        	<tr><td></td>
        	<td><c:out value="${c.bhuser.username}"></c:out></td>
        	<td><c:out value="${c.posttext}"></c:out></td>
        	<td>
        	<c:if test="${c.mood > 0}">:D</c:if>
        	<c:if test="${c.mood < 0}">:(</c:if>
        	<c:if test="${c.mood == 0}">:|</c:if>
        	</td>
        	</tr>
   		</c:forEach>
        <tr>
        <td></td>
        <td colspan="3">
        <form role="form" action="Post" method="post" onsubmit="return validate(this);">
                <div class="form-group">  
                    <label for="post">Comment on this post (141 char):</label>
                    <textarea name= "posttext" id="posttext" class="form-control" rows="2" placeholder= "Comment on this post" maxlength="141"></textarea>
                    <div id="textarea_feedback"></div>
                    </div>
                    <div class = "form-group">
                    <input type="submit" value="Submit" id="submit"/>
                    <input type="reset" value="Clear"/>
                    <input type="hidden" name="parent" id="parent" value="${f.post.postid}"/>
                </div>
				</form>
                </td>
                </tr>
    </c:if>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

<!-- <%//out.println(Gravatar.getGravatarUrl(((Bhpost)pageContext.getAttribute("post")).getBhuser().getUseremail()));%>"> -->