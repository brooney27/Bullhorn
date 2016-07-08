package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.Sentiment;
import helpers.BHFunction;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class Post
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		Bhuser user = (Bhuser)session.getAttribute("user");
		String posttext = request.getParameter("posttext").toString();
		java.util.Date date = new Date();
		int mood = Sentiment.getSentiment(posttext);
		String nextUrl = "/Newsfeed";
		
		Bhpost post = new Bhpost();
		post.setBhuser(user);
		post.setPosttext(posttext);
		post.setPostdate(date);
		post.setMood(BigDecimal.valueOf(mood));
		if(request.getParameter("parent")!=null){
			post.setBhpost(BHFunction.getPostById(request.getParameter("parent")));
		}
		
		customTools.DbBullhorn.insert(post);
		
		List<Bhpost> posts = customTools.DbBullhorn.bhPost();
		session.setAttribute("posts", posts);
		
		request.getRequestDispatcher(nextUrl).forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
