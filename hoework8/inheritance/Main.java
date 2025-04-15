public class Main{
	public static void main(String[] args){
		//Profs
		Professor profSantos = new Professor("Joanna Santos", "P01","jdasilv2@nd.edu", "Computer Science");
		Professor profBui = new Professor("Peter Bui", "P02","pbui@nd.edu", "Computer Engineering");

		//courses
		Course cse30332 = new Course("Programming Paradigms", "CSE30332", profSantos);
		Course cse12345 = new Course("Systems Programming", "CSE12345", profBui);
		
		//Tas
		TA ta1 = new TA("Micah Brody", "Ta01", "mbrody@nd.edu");
		TA ta2 = new TA("Sahil Khandelwal", "Ta02", "skhandel@nd.edu");
		TA ta3 = new TA("Kaixiang Zhao", "Ta03", "kzhao5@nd.edu");
		TA ta4 = new TA("Ella Gerczak", "Ta04", "egerczak@nd.edu");

		TA ta5 = new TA("Anna Briamonte", "Ta05", "abriamon@nd.edu");

		//assignment
		ta1.assignToCourse(cse30332);
		ta2.assignToCourse(cse30332);
		ta3.assignToCourse(cse30332);
		ta4.assignToCourse(cse30332);

		ta5.assignToCourse(cse30332);
		
		//students
		Student s1 = new Student("Mary Briamonte", "St01", "mbriamon@nd.edu", "Computer Engineering");
		Student s2 = new Student("Rory Gilmore", "St02", "rgilmo@nd.edu", "Computer Science");
		Student s3 = new Student("Ferris Bueller", "St03", "fbueller@nd.edu", "Computer Science");
		
		//enroll students
		cse30332.addStudent(s1);
		cse30332.addStudent(s2);
		cse30332.addStudent(s3);

		cse12345.addStudent(s1);
		cse12345.addStudent(s2);
		cse12345.addStudent(s3);

		//print
		System.out.println(ta1);
		System.out.println(profSantos);
		System.out.println(s1);

	}
}