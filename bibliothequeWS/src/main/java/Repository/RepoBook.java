package Repository;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import DB.H2JDBCUtils;
import Object.Book;

@WebService(endpointInterface="Repository.IRepoBook")
public class RepoBook implements IRepoBook {
	private static Connection _connection;
	
	public RepoBook(Connection connection) {
		_connection = connection;
	}

	@Override
	public Object[] GetAllBooks() {
		String query = "SELECT * FROM LIVRE";
			try {
	            // Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = _connection.prepareStatement(query);
		        System.out.println(preparedStatement);
		        // Step 3: Execute the query or update query
		        ResultSet rs = preparedStatement.executeQuery();
		        ArrayList<Book> listBook = new ArrayList<Book>();
		        // Step 4: Process the ResultSet object.
		        while (rs.next()) {
		        	Book book = new Book(rs.getInt("ID")
		        			,rs.getString("TITRE")
		        			,rs.getInt("ISBN")
		        			,rs.getInt("IDAUTEUR"));
		        	listBook.add(book);
		        }
		        rs.close();
	    		return listBook.toArray();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
        return null;
	}

	@Override
	public Book GetBook(int id) {
		String query = "SELECT * FROM LIVRE WHERE ID =?";
		
		
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
	        	Book book = new Book(rs.getInt("ID")
	        			,rs.getString("TITRE")
	        			,rs.getInt("ISBN")
	        			,rs.getInt("IDAUTEUR"));
	
	    		return book;
	        }
	        rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	return null;
	}

	@Override
	public Boolean CreateBook(String title, int isbn, int idauthor) {
		// TODO Auto-generated method stub
			String query = "INSERT INTO LIVRE (titre, isbn, idauteur) VALUES (? , ? , ? )";
			
			
	        // Step 2:Create a statement using connection object
			PreparedStatement preparedStatement;
			try {
				preparedStatement = _connection.prepareStatement(query); 
				preparedStatement.setString(1, title);
				preparedStatement.setInt(2, isbn);
				preparedStatement.setInt(3, idauthor);
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
	public void DeleteBook(int id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM LIVRE WHERE ID = ?";
		
		
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
