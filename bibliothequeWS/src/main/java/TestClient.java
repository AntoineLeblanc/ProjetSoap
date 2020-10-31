import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Object.Author;
import Object.Book;
import Repository.IRepoAuthor;
import Repository.IRepoBook;

public class TestClient {
	public static void main(String[] args) throws MalformedURLException {
		URL bookUrl = new URL("http://localhost:9998/ws/bookRepo?wsdl");
		URL authorUrl = new URL("http://localhost:9998/ws/authorRepo?wsdl");
		
		QName bookQname = new QName("http://Repository/","RepoBookService");
		QName authorQname = new QName("http://Repository/","RepoAuthorService");

		Service bookService = Service.create(bookUrl, bookQname);
		Service authorService = Service.create(authorUrl,authorQname);
		
		IRepoBook repoBook = bookService.getPort(IRepoBook.class);
		IRepoAuthor repoAuthor = authorService.getPort(IRepoAuthor.class);
		
		
		//Test Book 
		var resBook = repoBook.GetBook(1);
		System.out.println(resBook.toString());
		
		System.out.println("Le livre a été ajouté ? : "  + repoBook.CreateBook("LivreTest", 20789, 2));

		Object[] listBook = repoBook.GetAllBooks();
		
		for(Object o : listBook) {
			System.out.println(o.toString());
		}
		
		Book book = (Book) listBook[listBook.length-1];
		repoBook.DeleteBook(book.getID());
		
		
		
		//Test Author
		var resAuthor = repoAuthor.GetAuthor(1);
		System.out.println(resAuthor.toString());
		
		System.out.println("L'auteur a été ajouté ? : "  + repoAuthor.CreateAuthor("Michel", "Dumas"));
		
		Object[] listAuthor = repoAuthor.GetAllAuthors();
		
		for(Object a : listAuthor) {
			System.out.println(a.toString());
		}
		
		Author author = (Author) listAuthor[listAuthor.length-1];
		repoAuthor.DeleteAuthor(author.getID());
	}

}
