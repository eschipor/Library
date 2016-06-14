package main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import persistance.dao.DaoFilm;
import persistance.model.Film;

/**
 * Servlet implementation class Film
 */
@WebServlet("/index/film/AddFilm")
@MultipartConfig
public class AddFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY ="d:\\temp\\Library\\";
    
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
		InputStream fileContent= null;
		OutputStream outFile = null;
		Film film = new Film();
		film.setTitolo(request.getParameter("titolo"));
		film.setData(Integer.parseInt(request.getParameter("data")));
		
		if(request.getPart("media")!=null){
            try {
            	 Part filePart = request.getPart("media");
            	    String fileName = getSubmittedFileName(filePart);
            	    fileContent = filePart.getInputStream();
          
            	    File targetFile = new File(UPLOAD_DIRECTORY + fileName);
            	    Files.copy(fileContent, targetFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
            	    film.getMedia().setIndirizzo(targetFile.getPath());
            	    film.getMedia().setNome(fileName);
            	    film.getMedia().setSize(targetFile.length());
           
            	    
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (IOException e) {
        		e.printStackTrace();
        	} finally {
        		if (fileContent != null) {
        			try {
        				fileContent.close();
        			} catch (IOException e) {
        				e.printStackTrace();
        				}
	        		}
	        		if (outFile!= null) {
        				try {
        				// outputStream.flush();
        				outFile.close();
        				} catch (IOException e) {
        				e.printStackTrace();
	        			}
	
	        		}
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
		
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
}