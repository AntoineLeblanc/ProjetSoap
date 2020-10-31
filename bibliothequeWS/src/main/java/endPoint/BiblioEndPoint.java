package endPoint;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

import DB.H2JDBCUtils;
import Repository.*;

public class BiblioEndPoint {

	public static void main(String[] args) throws MalformedURLException {
		Connection connection = H2JDBCUtils.getConnection();
		Endpoint.publish("http://localhost:9998/ws/bookRepo", new RepoBook(connection));
		Endpoint.publish("http://localhost:9998/ws/authorRepo", new RepoAuthor(connection));
	}
}
