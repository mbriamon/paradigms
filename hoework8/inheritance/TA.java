public class TA extends UniversityMember{
	private Course[] coursesAssisting = new Course[2];

	public TA(String name, String id, String email){
		super(name, id, email);
	}

	public void assignToCourse(Course c){
		for (Course course : coursesAssisting){
			if (course == c) return;	//already assigned
		}
		for (int i = 0; i < coursesAssisting.length; i++){
			if (coursesAssisting[i] == null){
				coursesAssisting[i] = c;
				return;
			}
		}
	}
	public Course[] getCoursesAssisting() {
		return coursesAssisting;
	}

	@Override
	public String getRole(){
		return "TA";
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(getName() + " (" + getEmail() + "). TA for courses: ");
		boolean first = true;
		for (Course c : coursesAssisting) {
			if (c != null){
				if (!first) sb.append(", ");
				sb.append(c.getCode());
				first = false;
			}
		}
		return sb.toString();
	}
}