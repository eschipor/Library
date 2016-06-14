package main.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import persistance.dao.DaoFilm;
import persistance.model.Film;

/**
 * Servlet implementation class Film
 */
@WebServlet("/index/film/AddFilm")
public class AddFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY ="c:\\temp\\Library ";
    
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
		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest((RequestContext) request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        film.getMedia().setNome(name);
                        film.getMedia().setIndirizzo(UPLOAD_DIRECTORY + File.separator + name);
                        film.getMedia().setSize(item.getSize());
                        item.write( new File(film.getMedia().getIndirizzo()));
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }
		}
		
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