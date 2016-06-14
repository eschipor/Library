package persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistance.model.Film;

public class DaoFilm 
{	
	private DaoMedia daoMedia = new DaoMedia();
	private final String table = "film";
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private String connectionString = "jdbc:mysql://localhost:3306/table";
	private String usr = "root";
	private String pass = "root";

    public Statement connect()
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		connect = DriverManager.getConnection(connectionString,usr,pass);
    		statement = connect.createStatement();
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    	return statement;
    }
    public ArrayList<Film> findAll()
    {
    	connect();	
    	ArrayList<Film> film = new ArrayList<Film>();

    	try
    	{
    		resultSet = connect().executeQuery("select * from " +table);
    		
    		while(resultSet.next())
    		{
    			Film fil = new Film();
    			fil.setId(resultSet.getInt("id"));
    			fil.setTitolo(resultSet.getString("titolo"));
    			fil.setData(resultSet.getInt("data"));
    			film.add(fil);
    		}
    	}
    	catch(Exception e)
    	{
    		return film;
    	}
    	finally
    	{
    		close();
    	}
    	return film;
    	
    }
    public boolean add(Film f)
    {
    	connect();
    	try {
    		if(f.getMedia()!=null){
    		Integer ref_media = daoMedia.add(f.getMedia());
			preparedStatement=connect.prepareStatement("insert into " +table+ "(titolo, data, ref_media) values (?, ?, ?)");
	    	preparedStatement.setString(1, f.getTitolo());
	    	preparedStatement.setInt(2, f.getData());
	    	preparedStatement.setInt(3, ref_media);
    		}
    		else{
    			preparedStatement=connect.prepareStatement("insert into " +table+ "(titolo, data, ref_media) values (?, ?)");
    	    	preparedStatement.setString(1, f.getTitolo());
    	    	preparedStatement.setInt(2, f.getData());
    		}
	    	preparedStatement.executeUpdate();
	    	return true;	
	    	
    	} catch (SQLException e) {
			return false;
		}
    	finally{
    	close();
    	}
    }
    public boolean delete(Film f)
    {
		try {
			preparedStatement = connect.prepareStatement("delete from " +table+ " where titolo = ?;");
			preparedStatement.setString(1, f.getTitolo());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	      
	    
    }
    
    private void close() 
    {
    	try 
    	{
    		if (resultSet != null) 
    		{
    			resultSet.close();
    		}

    		if (statement != null) 
    		{
    			statement.close();
    		}
    		if (connect != null) 
    		{
    			connect.close();
    		}
    	} 
    	catch (Exception e) 
    	{

    	}
    }
    //Show details
	public Film getDetailByID(Integer id) {
		try{
			connect();
			DaoMedia daoMedia = new DaoMedia();
			String selectSQL = "select * from " +table+ " where id = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id.intValue());
			resultSet= preparedStatement.executeQuery();
			resultSet.next();
				Film film = new Film();
    			film.setId(resultSet.getInt("id"));
    			film.setTitolo(resultSet.getString("titolo"));
    			film.setData(resultSet.getInt("data"));
    			if((Integer)resultSet.getInt("ref_media")!=null)
    			{
    				film.setMedia(daoMedia.getByID((Integer)resultSet.getInt("ref_media")));
    			}
    		return film;
		}catch(Exception e){
			return null;
		}finally{
			close();
		}
	}
}