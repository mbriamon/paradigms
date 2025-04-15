public class Professor extends UniversityMember{
	private String department;

	public Professor(String name, String id, String email, String department){
		super(name, id, email);
		this.department = department;
	}

	@Override
	public String getRole(){
		return "Professor";
	}

	@Override
	public String toString(){
		String[] nameParts = getName().split(" ");
		String lastName = nameParts[nameParts.length - 1];
		return "Prof. " + lastName + " (" + getEmail() + ") ";
	}
}