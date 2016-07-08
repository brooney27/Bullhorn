package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bhpost;
import model.Feedpost;
import customTools.Gravatar;
import customTools.Sentiment;

@WebServlet("/Newsfeed")
public class Newsfeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Newsfeed() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bhpost> posts = customTools.DbBullhorn.bhPost();
		ArrayList<Feedpost> feed = new ArrayList<Feedpost>();
		
		for(Bhpost p:posts){
			Feedpost f = new Feedpost();
			f.setGravatar(Gravatar.getGravatarUrl(p.getBhuser().getUseremail()));
			f.setPost(p);
			feed.add(f);
		}
		request.setAttribute("feed", feed);
		request.getRequestDispatcher("/newsfeed.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
