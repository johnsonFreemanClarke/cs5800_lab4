/* Johnson Wei (004150718)
 * CS 5800: Lab 4
 * 12/1/2019
 */
import java.text.DecimalFormat;

public class Driver {

	public static void main(String[] args) {
		// part 1
		Compute computeType; // will help us determine what type of avg to compute
		
		// creating a student
		Student student1 = new Student("Bob");
		student1.addAssignmentScore(92.3);
		student1.addAssignmentScore(84.5);
		student1.addAssignmentScore(78.2);
		student1.addExamScore(93);
		student1.addExamScore(88);
		
		// method A
		System.out.println("[Part 1]");
		computeType = new ComputeAssignmentAvg();
		DecimalFormat gradeFormat = new DecimalFormat("0.0"); 
		System.out.println(student1.getName() + " has an average of: " + 
						   gradeFormat.format(student1.getAverage(computeType, false)));
		
		// method B
		computeType = new ComputeDroppedAssignmentAvg();
		DecimalFormat adjustedGradeFormat = new DecimalFormat("0.0"); 
		System.out.println(student1.getName() + " has an adjusted average of: " + 
						   adjustedGradeFormat.format(student1.getAverage(computeType, true)));
		
		// back to method A
		computeType = new ComputeAssignmentAvg();
		System.out.println(student1.getName() + " has an average of: " + 
						   gradeFormat.format(student1.getAverage(computeType, false)));
		
		// part 2
		System.out.println("\n[Part 2]");
		computeType = new ComputeAssignmentAvg();
		// making use of a grade tracker (see hw assignment description)
		GradeTracker gt = new GradeTracker(student1, false);
		System.out.println("Grade of " + student1.getName() + " = " + gt.getLetterGrade());
		student1.addExamScore(40);
		System.out.println(student1.getName() + " has an average of: " + 
				   gradeFormat.format(student1.getAverage(computeType, false)));
		System.out.println("Grade of " + student1.getName() + " = " + gt.getLetterGrade());
		
		// part 3
		System.out.println("\n[Part 3]");
		// add another student
        Student student2 = new Student("Alyssa");
        student2.addAssignmentScore(90.3);
        student2.addAssignmentScore(97.9);
        student2.addAssignmentScore(95.6);
        student2.addExamScore(96);
        student2.addExamScore(91);
        
        // creating new roster
        Roster csRoster = new Roster("Adv Software Engineering","CS 5800");
        csRoster.addStudent(student1);
        csRoster.addStudent(student2);
        
        // testing the roster traversal
        System.out.println(csRoster.getCourseNumber() + ": " + csRoster.getCourseName() + " grades:");
        AvgDispenser ad = csRoster.getDispenser();
        while(ad.hasMore()) {
            System.out.println("next average "  +
                               gradeFormat.format(ad.getNextAvg()));
        }
	}

}
