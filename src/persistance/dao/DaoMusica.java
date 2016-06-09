package persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistance.model.Musica;

public class DaoMusica 
{	
	private final String table = "musica";
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
    public ArrayList<Musica> findAll()
    {
    	connect();
    	ArrayList<Musica> musica = new ArrayList<Musica>();
    	
    	try
    	{
    		resultSet = connect().executeQuery("select * from " +table);
    		
    		while(resultSet.next())
    		{
    			Musica mus = new Musica();
    			mus.setId(resultSet.getInt("id"));
    			mus.setNome(resultSet.getString("nome"));
    			mus.setTitolo(resultSet.getString("titolo"));
    			mus.setData(resultSet.getInt("data"));
    			musica.add(mus);
    		}
    	}
    	catch(Exception e)
    	{
    		return musica;
    	}
    	finally
    	{
    		close();
    	}
    	return musica;
    	
    }
    public boolean add(Musica m) 
    {
    	connect();
    	try {
			preparedStatement=connect.prepareStatement("insert into " +table+ "(nome, titolo, data) values (?, ?, ?)");
	    	preparedStatement.setString(1, m.getNome());
	    	preparedStatement.setString(2, m.getTitolo());
	    	preparedStatement.setInt(3, m.getData());
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
    public boolean delete(Musica m)
    {
		try {
			preparedStatement = connect.prepareStatement("delete from " +table+ " where nome= ?;");
			preparedStatement.setString(1, m.getNome());
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
    public Musica getDetailByID(Integer id){
    	try{
    		connect();
    		String selectSQL = "select * from " +table+ " where id = ?";
    		PreparedStatement preparedStatement = connect.prepareStatement(selectSQL);
    		preparedStatement.setInt(1, id.intValue());
    		resultSet = preparedStatement.executeQuery();
    		resultSet.next();
    			Musica musica = new Musica();
    			musica.setId(resultSet.getInt("id"));
    			musica.setNome(resultSet.getString("nome"));
    			musica.setTitolo(resultSet.getString("titolo"));
    			musica.setData(resultSet.getInt("data"));
    			return musica;
    	}
    	catch (SQLException e){
    		return null;
    	}
    	finally{
    		close();
    	}
    }
}