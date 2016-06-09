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
 * Servlet implementation class Film
 */
@WebServlet("/indexFilm/AddFilm")
public class AddFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoFilm daoFilm = new DaoFilm();
	String msg = "";
	boolean token = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Film film = new Film();
		film.setTitolo(request.getParameter("titolo"));
		film.setData(Integer.parseInt(request.getParameter("data")));
		
			if(daoFilm.add(film)){
				msg = "Salvato con sucesso";
			} 
			else
			{
				msg = "Errore nel salvataggo. Contattare l'amministratore!";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd =request.getRequestDispatcher("/success.jsp");
			rd.forward(request,response);
		
	}
}