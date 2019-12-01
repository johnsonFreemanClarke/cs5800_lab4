/* Johnson Wei (004150718)
 * CS 5800: Lab 4
 * 12/1/2019
 */
import java.util.Observable;
import java.util.Observer;

public class GradeTracker implements Observer {
	private final double THRESHOLD = 0.0001;
	private double studentGrade;
	private boolean dropLowestAssignment = false;
	private Student student;
	
	public GradeTracker(Student student, boolean dropLowestAssignment){
		student.addObserver(this);
		
		this.dropLowestAssignment = dropLowestAssignment;
		if(dropLowestAssignment) {
			studentGrade = student.getAverage(new ComputeDroppedAssignmentAvg(), true);
		} else {
			studentGrade = student.getAverage(new ComputeAssignmentAvg(), false);
		}
	}
	
	public char getLetterGrade() {
		if(studentGrade >= 90) {
			return 'A';
		} else if(studentGrade >= 80) {
			return 'B';
		} else if(studentGrade >= 70) {
			return 'C';
		} else if(studentGrade >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

	/* Using Observer design pattern from java utility, 
	 * thus we have to implement the update method */
	@Override
	public void update(Observable obj, Object arg) {
		Student observableStudent = (Student)obj;
		double observableStudentGrade = 22;
		double difference;
		if(dropLowestAssignment) {
			observableStudentGrade = observableStudent.getAverage(new ComputeDroppedAssignmentAvg(), 
														  dropLowestAssignment);
			
		} else {
			observableStudentGrade = observableStudent.getAverage(new ComputeAssignmentAvg(), 
														  dropLowestAssignment);
		}
		
		difference = Math.abs(observableStudentGrade - studentGrade); 
		if(difference > THRESHOLD) {
			studentGrade = observableStudentGrade;
			System.out.println("Exam score added");
		}
	}
}
