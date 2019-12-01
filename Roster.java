/* Johnson Wei (004150718)
 * CS 5800: Lab 4
 * 12/1/2019
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Roster {
	private String courseName;
	private String courseNumber;
	private List<Student> students;
	
	public Roster(String courseName, String courseNumber) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		students = new ArrayList<>();
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	public AvgDispenser getDispenser() {
		return new AvgDispenser() {
			List<Student> studentDispenserList = students;
			
			@Override
			// cannot call this method if studentDispenserList is empty
			public double getNextAvg() {
				return studentDispenserList.remove(0).getAverage(new ComputeAssignmentAvg(), false);
			}

			@Override
			public boolean hasMore() {
				if(studentDispenserList.isEmpty()) {
					return false;
				}
				return true;
			}
		};
	}
}
