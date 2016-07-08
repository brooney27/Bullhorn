package controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbBullhorn;
import model.Bhuser;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String motto = request.getParameter("motto");
		String email = request.getParameter("email");
		java.util.Date joindate = new Date();
		
		Bhuser user = new Bhuser();
		user.setUseremail(email);
		user.setMotto(motto);
		user.setUserpassword(password);
		user.setUsername(name);
		user.setJoindate(joindate);
		
		DbBullhorn.update(user);
		
		String gravatar = customTools.Gravatar.getGravatarUrl(user.getUseremail());
		//String gravatar = customTools.Gravatar.getGravatarUrl("briguy278@yahoo.com");
		session.setAttribute("gravatar", gravatar);
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/profile.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
