package Object;

public class Author {

	private int ID;
	private String FirstName,LastName;
	
	public Author() {};
	
	public Author(int id, String firstName, String lastName) {
		this.ID = id;
		this.FirstName = firstName;
		this.LastName = lastName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [ID=" + ID + ", FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}
}