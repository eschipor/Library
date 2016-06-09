package main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.dao.DaoMusica;
import persistance.model.Musica;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "detailMusica", urlPatterns = { "/index/musica/detail" })
public class DetailMusica extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoMusica daoMusica = new DaoMusica();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMusica() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ID") != null)
		{
			Musica current = daoMusica.getDetailByID(Integer.parseInt(request.getParameter("ID")));
			
			request.setAttribute("musica",current);

			RequestDispatcher rd = request.getRequestDispatcher("/index/musica/details.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
