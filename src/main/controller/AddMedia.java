package main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.dao.DaoMedia;
import persistance.model.Media;

/**
 * Servlet implementation class Film
 */
@WebServlet("/index/media/AddMedia")
public class AddMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoMedia daoMedia = new DaoMedia();
	String msg = "";
	boolean token = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedia() {
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
		
		Media media = new Media();
		media.setNome(request.getParameter("nome"));
		media.setTipo(request.getParameter("tipo"));
		media.setIndirizzo(request.getParameter("indirizzo"));
		media.setSize(Integer.parseInt(request.getParameter("size")));
		
			if(daoMedia.add(media)){
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