package main.controller;

import java.io.IOException;

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
@WebServlet(name = "detailLibri", urlPatterns = { "/index/libri/detail" })
public class DetailLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoLibri daoLibri = new DaoLibri();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailLibri() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ID") != null)
		{
			Libri current = daoLibri.getDetailByID(Integer.parseInt(request.getParameter("ID")));
			
			request.setAttribute("libri",current);

			RequestDispatcher rd = request.getRequestDispatcher("/index/libri/details.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
