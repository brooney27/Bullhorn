package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.BHFunction;
import model.Bhpost;
import model.Bhuser;

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ValidateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bhuser user = BHFunction.getUserByEmail(request.getParameter("email"));
		
		response.setContentType("text/html");
		
		boolean valid = BHFunction.isValidUser(user,request.getParameter("password"));
		String nextURL;
		if(valid){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			nextURL = "/Home";
			
			String gravatar = customTools.Gravatar.getGravatarUrl(user.getUseremail());
			//String gravatar = customTools.Gravatar.getGravatarUrl("briguy278@yahoo.com");
			session.setAttribute("gravatar", gravatar);
		}
		else{
			nextURL = "/login.jsp";
			String messages = "Incorrect login";
			request.setAttribute("messages", messages);
		}
		
		request.getRequestDispatcher(nextURL).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
