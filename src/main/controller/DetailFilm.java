package main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.dao.DaoFilm;
import persistance.model.Film;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "detailFilm", urlPatterns = { "/index/film/detail" })
public class DetailFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoFilm daoFilm = new DaoFilm();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailFilm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ID") != null)
		{
			Film current = daoFilm.getDetailByID(Integer.parseInt(request.getParameter("ID")));
			
			request.setAttribute("film",current);

			RequestDispatcher rd = request.getRequestDispatcher("/index/film/details.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
