package Repository;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import Object.Book;

@WebService
@SOAPBinding(style=Style.RPC,use = Use.LITERAL)
public interface IRepoBook {
	
	Object[] GetAllBooks();
	
	Book GetBook(int id);
	
	Boolean CreateBook(String title, int isbn, int idauthor);
	
	void DeleteBook(int id);
}
