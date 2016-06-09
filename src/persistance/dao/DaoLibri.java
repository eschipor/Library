package persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistance.model.Libri;

public class DaoLibri 
{	
	private final String table = "libri";
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
    public ArrayList<Libri> findAll()
    {
    	connect();
    	ArrayList<Libri> libri = new ArrayList<Libri>();

    	try
    	{
    		resultSet = connect().executeQuery("select * from " +table);
    		
    		while(resultSet.next())
    		{
    			Libri lib = new Libri();
    			lib.setNome(resultSet.getString("nome"));
    			lib.setTitolo(resultSet.getString("titolo"));
    			lib.setData(resultSet.getInt("data"));
    			libri.add(lib);
    		}
    	}
    	catch(Exception e)
    	{
    		return libri;
    	}
    	finally
    	{
    		close();
    	}
    	return libri;
    	
    }
    public boolean add(Libri l)
    {
    	connect();
    	try {
			preparedStatement=connect.prepareStatement("insert into " +table+ "(nome, titolo, data) values (?, ?, ?)");
			preparedStatement.setString(1, l.getNome());
	    	preparedStatement.setString(2, l.getTitolo());
	    	preparedStatement.setInt(3, l.getData());
	    	preparedStatement.executeUpdate();
	    	return true;
    	} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
    	finally{
    	close();
    	}
    }
    public boolean delete(Libri l)
    {
		try {
			preparedStatement = connect.prepareStatement("delete from "+table+" where nome= ?;");
		    preparedStatement.setString(1, l.getNome());
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
}