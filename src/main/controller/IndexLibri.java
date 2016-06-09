package main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.dao.DaoLibri;
import persistance.model.Libri;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "indexLibri", urlPatterns = { "/index/libri" })
public class IndexLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoLibri daoLibri = new DaoLibri();
	ArrayList<Libri> lista = new ArrayList<Libri>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexLibri() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("libri") != null)
		{
			response.sendRedirect("/Library/index/libri/insert.jsp");
		}
		if(request.getParameter("list") != null) 
		{
			lista = daoLibri.findAll();
			
			request.setAttribute("lista", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/index/libri/list.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
}
