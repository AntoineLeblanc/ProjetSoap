package Object;

public class Book {

	private int ID,ISBN,IdAuthor;
	private String Title;
	
	public Book() {
		
	};

	public Book(int id, String title ,int isbn, int idAuthor) {
		this.ID = id;
		this.ISBN = isbn;
		this.IdAuthor = idAuthor;
		this.Title = title;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public int getIdAuthor() {
		return IdAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		IdAuthor = idAuthor;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	

	@Override
	public String toString() {
		return "Book [ID=" + ID + ", ISBN=" + ISBN + ", IdAuthor=" + IdAuthor + ", Title=" + Title + "]";
	}
}
