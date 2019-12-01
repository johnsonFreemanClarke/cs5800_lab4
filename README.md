# cs5800_lab4
### Design Patterns assignment description:

Lab 4
Design Patterns

**CS 5800**

Due: before class Monday, 11/25/2019 


We want to implement a Java class to represent a student and their scores from a class they are enrolled in. 

The Student class provides at least the following methods: 	Student(String name);                		//constructor
   	void addAssignmentScore (double as); //add 1 assignment score
   	void addExamScore (double es);         //add 1 exam score

There is also a Roster class that stores a list of the Students in a particular class. 
The Roster class provides at least these methods:
 	Roster(String name, String number);	//constructor
	String getCourseName(); 		         //getter for name
	addStudent (Student student);	       //add 1 student

1. We need to add a method to return the Student’s class average but, the algorithm to compute the average must be able to be selected at runtime. It also must be possible to add new algorithms to compute the average to the program with only minor modifications to the Student class. 
Your task: Using a specific Design Pattern, develop a design for Student that satisfies the above requirements, then implement your design.  
Use the following two algorithms for computing the average in your implementation: 
	A) 	The Assignment average contributes 40%, and the Exam average 					contributes 60% to the final class average.

	B) 	Use the same percentages as the first algorithm, but first if there are at 		  		least 2 Assignments scores, drop the lowest Assignment score.

Verify your program works by testing. Create a Student, add three assignment scores and two exam scores, and compute their average first using method A then using method B, then using method A again. (Screen capture the outputs)






2. We want to extend our design with a class GradeTracker that tracks(stores) the current letter grade of a given Student object (>=90=A, >=80=B, etc.). Whenever the Student object is changed, the tracker has to be modified automatically. 
Your task: Using a specific Design Pattern, develop a design for the tracker, then implement your design.  
Verify your program works by testing. Define a tracker object to track the student and output the letter grade of the student. Then add an exam score that will change the letter grade of the student, and output the tracker’s letter grade again to show it was updated automatically. 


3. We want to provide access to the averages of the students in the class, without providing access to either the ArrayList of Students or the Student objects.  
We do not want to provide a collection of the averages to the client code (we don’t want to require the client to store all the values locally).  
We also want to be able to allow multiple clients to access the averages simultaneously without interference (so adding a “current element” pointer to the Roster will not suffice).  
Your task: Using a specific Design Pattern, develop a design that satisfies the above requirements for accessing the averages, then implement your design. 
 
Verify your program works by testing. Create two students and add them to a Roster object. Use an AvgDispenser(Interface), obtained from the Roster, for accessing the averages and outputting them to the screen as described above.

4. For problems 1-3, draw the class diagram showing how your classes implement the Design Pattern, and label it with the name of the design pattern you used.


What to submit:
Submit a PDF or DOC file with a link to your repository. For each question you should include a print out of your code and screen shots of the output.
