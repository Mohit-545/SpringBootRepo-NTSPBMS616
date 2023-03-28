//NitFrontController.java
package com.nt.fcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.LinksHandler;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class NitFrontController extends HttpServlet {
	
	private LinksHandler handler = null;
	
	@Override
	public void init() throws ServletException {
		handler = new LinksHandler();
	}//method
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Perform Navigation Management
		//get the Servlet req path
		String path = req.getServletPath();
		String lvn = null;
		if(path.equalsIgnoreCase("/wish")) {
			lvn = handler.showWishMessage(req);
		}//if
		else if(path.equalsIgnoreCase("/langs")) {
			lvn = handler.showAllLanguages(req);
		}//else if
		else {
			lvn = "home";
		}//else
		
		// Perform View Management
		String destPath = null;
		if(lvn.equalsIgnoreCase("wish_result")) {
			destPath = "/show_wish.jsp";
		}//if
		else if(lvn.equalsIgnoreCase("all_langs")) {
			destPath = "/show_languages.jsp";
		}//else if
		else 
			lvn = "/index.jsp";
		
		//forwarding the request to the destination page
		RequestDispatcher rd = req.getRequestDispatcher(destPath);
		rd.forward(req, res);
		
	}//doGet(-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-)

}//class
