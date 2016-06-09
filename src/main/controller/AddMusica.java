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
 * Servlet implementation class Musica
 */
@WebServlet("/indexMusica/AddMusica")
public class AddMusica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoMusica daoMusica = new DaoMusica();
	String msg = "";
	boolean token = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMusica() {
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
		
		Musica musica = new Musica();
		musica.setNome(request.getParameter("nome"));
		musica.setTitolo(request.getParameter("titolo"));
		musica.setData(Integer.parseInt(request.getParameter("data")));

		if(daoMusica.add(musica)){
			msg = "Salvato con sucesso";
		}
		else{
			msg = "Errore nel salvataggio. Contattare l'amministratore!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);	
	}

}
