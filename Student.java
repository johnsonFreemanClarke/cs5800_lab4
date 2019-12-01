/* Johnson Wei (004150718)
 * CS 5800: Lab 4
 * 12/1/2019
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Student  extends Observable {
	private String name;
	private List<Double> assignments;
	private List<Double> exams;
	private Compute compute;
	
	public Student(String name) {
		this.name = name;
		assignments = new ArrayList<>();
		exams = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addAssignmentScore(double as) {
		assignments.add(as);
		setChanged();
		notifyObservers();
	}
	
	public void addExamScore(double es) {
		exams.add(es);
		setChanged();
		notifyObservers();
	}
	
	/* 
	 * computes average based on assignment contribution = 40%
	 * and exam contribution = 60%, together they sum up to the 
	 * student's final class average.
	*/
	public double getAverage(Compute compute, boolean dropLowAssignment) {
		double avg;
		if(dropLowAssignment) {
			compute = new ComputeDroppedAssignmentAvg();
		} else {
			compute = new ComputeAssignmentAvg();
		}
		avg = compute.computeAverage(assignments);
		compute = new ComputeExamAvg();
		avg += compute.computeAverage(exams);
		return avg;
	}
}
