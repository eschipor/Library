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
 * Servlet implementation class Libri
 */
@WebServlet("/index/libri/AddLibri")
public class AddLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoLibri daoLibri = new DaoLibri();
	String msg = "";
	boolean token = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibri() {
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

		Libri libri = new Libri();
		libri.setNome(request.getParameter("nome"));
		libri.setTitolo(request.getParameter("titolo"));
		libri.setData(Integer.parseInt(request.getParameter("data")));
		
		
		if(daoLibri.add(libri)){
			msg = "Salvato con sucesso";
		}
		else
		{
			msg = "Errore nel salvataggio. Contattare l'amministratore!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
	}

}
