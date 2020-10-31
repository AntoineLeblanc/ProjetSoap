package Repository;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import Object.Author;

@WebService
@SOAPBinding(style=Style.RPC,use = Use.LITERAL)
public interface IRepoAuthor {
	
	Object[] GetAllAuthors();
	
	Author GetAuthor(int id);
	
	Boolean CreateAuthor(String firstName, String lastName);
	
	void DeleteAuthor(int id);
	
}
