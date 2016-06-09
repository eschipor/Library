package main.controller;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet(name = "filmlist", urlPatterns = { "/film" })
public class IndexFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoFilm daoFilm = new DaoFilm();
	ArrayList<Film> lista = new ArrayList<Film>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexFilm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("film") != null)
		{
			response.sendRedirect("/Library/indexFilm/insert_film.jsp");
		}
		if(request.getParameter("lista") != null)
		{
			lista = daoFilm.findAll();
			
			request.setAttribute("lista", lista);

			RequestDispatcher rd = request.getRequestDispatcher("indexFilm/film.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
}
