#! /usr/bin env python3

from question3 import Student, Professor, TA, Course

if __name__ == '__main__':
    #Create Professor
    prof_santos = Professor("Joanna Santos", 1001, "jdasilv2@nd.edu", "CSE")
    

    #Create TAs
    ta1 = TA("Micah Brody", 2001, "mbrody@nd.edu")
    ta2 = TA("Sahil Khandelwal", 3001, "skhandel@nd.edu")
    ta3 = TA("Kaixiang Zhao", 4001, "kzhao5@nd.edu")
    ta4 = TA("Ella Gerczak", 5001, "egerczak@nd.edu")

    #Create Course
    course_pp = Course("Programming Paradigms", "CSE30332")

    #Assign Prof
    course_pp.add_instructor(prof_santos)

    #Assign TAs
    ta1.assign_to_course(course_pp)
    ta2.assign_to_course(course_pp)
    ta3.assign_to_course(course_pp)
    ta4.assign_to_course(course_pp)

    #Create Students
    student1 = Student("Mary Briamonte", 1101, "mbriamon@nd.edu", "Computer Engineering")
    student2 = Student("Anna Finn", 1102, "afinn@nd.edu", "Classics")
    student3 = Student("Layann Wardeh", 1103, "lwardeh@nd.edu", "Computer Science")

    #Enroll Students
    course_pp.add_student(student1)
    course_pp.add_student(student2)
    course_pp.add_student(student3)

    #Print 
    print(prof_santos)
    print(ta1)
    print(ta2)
    print(ta3)
    print(ta4)
    print(student1)
    print(student2)
    print(student3)

    print(f"\nCourse: {course_pp.name} ({course_pp.code})")
    print(f"Instructor: {course_pp.instructor}")
    print("Enrolled Students:")
    for student in course_pp.enrolled_students:
        print(f" - {student}")    