package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbBullhorn;
import helpers.BHFunction;
import model.Bhuser;


@WebServlet("/Follow")
public class Follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Follow() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		Bhuser user = (Bhuser)session.getAttribute("user");
		String email=request.getParameter("follow");
		
		Bhuser follow = DbBullhorn.getUserByEmail(email);
		
		List<Bhuser> list = follow.getBhusers1();
		list.add(user);
		
		follow.setBhusers1(list);
		
		DbBullhorn.update(follow);
		
		request.getRequestDispatcher("/Newsfeed").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
