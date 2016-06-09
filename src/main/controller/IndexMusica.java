package main.controller;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet(name = "indexMusica", urlPatterns = { "/index/musica" })
public class IndexMusica extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoMusica daoMusica = new DaoMusica();
	ArrayList<Musica> lista = new ArrayList<Musica>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexMusica() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("musica") != null)
		{
			response.sendRedirect("/Library/index/musica/insert.jsp");
		}
		if(request.getParameter("list") != null)
		{
			lista = daoMusica.findAll();
			
			request.setAttribute("lista", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/index/musica/list.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
}
