package persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import persistance.model.Media;

public class DaoMedia 
{	
	private final String table = "media";
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

    public Integer add(Media m)
    {
    	connect();
    	if(!m.getNome().equals("")||m.getNome()!=null){
    		m.setTipo(m.getNome().substring(m.getNome().lastIndexOf(".")));
    	}
    	try {
    		preparedStatement=connect.prepareStatement("insert into " +table+ "(nome, tipo, indirizzo, size) values (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
	    	preparedStatement.setString(1, m.getNome());
	    	preparedStatement.setString(2, m.getTipo());
	    	preparedStatement.setString(3, m.getIndirizzo());
	    	preparedStatement.setFloat(4, m.getSize());
	    	preparedStatement.executeUpdate();
	    	ResultSet rs =  preparedStatement.getGeneratedKeys();
	    	rs.next(); 
	    	return rs.getInt(1);
    	} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} 
    	finally{
    	close();
    	}
    }
    public boolean delete(Media m)
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
	public Media getByID(Integer id) {
		try{
			connect();
			String selectSQL = "select * from " +table+ " where id = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id.intValue());
			resultSet= preparedStatement.executeQuery();
			resultSet.next();
				Media media = new Media();
				media.setId(resultSet.getInt("id"));
				media.setNome(resultSet.getString("nome"));
				media.setTipo(resultSet.getString("tipo"));
				media.setIndirizzo(resultSet.getString("indirizzo"));
				media.setSize(resultSet.getInt("size"));
    	
    		return media;
		}catch(Exception e){
			return null;
		}finally{
			close();
		}
	}
}