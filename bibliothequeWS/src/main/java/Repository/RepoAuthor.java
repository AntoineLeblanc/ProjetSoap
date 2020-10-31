package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;

import Object.Author;
import Object.Book;


@WebService(endpointInterface="Repository.IRepoAuthor")
public class RepoAuthor implements IRepoAuthor {

	private static Connection _connection;
	public RepoAuthor(Connection connection) {
		_connection = connection;
	}

	@Override
	public Object[] GetAllAuthors() {
		String query = "SELECT * FROM AUTEUR";
		try {
            // Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = _connection.prepareStatement(query);
	        System.out.println(preparedStatement);
	        // Step 3: Execute the query or update query
	        ResultSet rs = preparedStatement.executeQuery();
	        ArrayList<Author> listAuthor = new ArrayList<Author>();
	        // Step 4: Process the ResultSet object.
	        while (rs.next()) {
	        	Author author = new Author(rs.getInt("ID")
	        			,rs.getString("PRENOM")
	        			,rs.getString("NOM"));
	        	listAuthor.add(author);
	        }
	        rs.close();
    		return listAuthor.toArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    return null;
	}

	@Override
	public Author GetAuthor(int id) {
		String query = "SELECT * FROM AUTEUR WHERE ID =?";
		
		
        // Step 2:Create a statement using connection object
		PreparedStatement preparedStatement;
		try {
			preparedStatement = _connection.prepareStatement(query); 
			preparedStatement.setInt(1, id);
	        System.out.println(preparedStatement);
	        // Step 3: Execute the query or update query
	        ResultSet rs = preparedStatement.executeQuery();
	        // Step 4: Process the ResultSet object.
	        while (rs.next()) {
	        	Author author = new Author(rs.getInt("ID")
	        			,rs.getString("PRENOM")
	        			,rs.getString("NOM"));
	
	    		return author;
	        }
	        rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	return null;
	}

	@Override
	public Boolean CreateAuthor(String firstName, String lastName) {
		String query = "INSERT INTO AUTEUR (prenom, nom) VALUES (? , ? )";
		
		
        // Step 2:Create a statement using connection object
		PreparedStatement preparedStatement;
		try {
			preparedStatement = _connection.prepareStatement(query); 
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
	        System.out.println(preparedStatement);
	        // Step 3: Execute the query or update query
	        int rs = preparedStatement.executeUpdate();
	        // Step 4: Process the ResultSet object.
	        System.out.println(rs);
	        return rs == 1 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	return false;
	}

	@Override
	public void DeleteAuthor(int id) {
		String query = "DELETE FROM AUTEUR WHERE ID = ?";
		
		
        // Step 2:Create a statement using connection object
		PreparedStatement preparedStatement;
		try {
			preparedStatement = _connection.prepareStatement(query); 
			preparedStatement.setInt(1, id);
	        System.out.println(preparedStatement);
	        // Step 3: Execute the query or update query
	        preparedStatement.execute();
	        // Step 4: Process the ResultSet object.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
