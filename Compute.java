/* Johnson Wei (004150718)
 * CS 5800: Lab 4
 * 12/1/2019
 */
import java.util.List;

// Strategy Pattern
public interface Compute {
	double computeAverage(List<Double> aList);	
}

class ComputeAssignmentAvg implements Compute {
	private final double ASSIGNMENT_WEIGHT = 0.40; // 40% of total weight
	
	public double computeAverage(List<Double> aList) {
		if(aList.isEmpty()) {
			return 0;
		}
		double totalAssignmentScore = 0;
		for(double score : aList) {
			totalAssignmentScore += score;
		}
		return (totalAssignmentScore / aList.size()) * ASSIGNMENT_WEIGHT;
	}
}

class ComputeDroppedAssignmentAvg implements Compute {
	private final double ASSIGNMENT_WEIGHT = 0.40; // 40% of total weight
	
	public double computeAverage(List<Double> aList) {
		// only perform this method if aList contains at least two scores
		if(aList.size() < 2) {
			throw new IllegalArgumentException("size of aList must be >= 2");
		}
		double lowestScore = Double.MAX_VALUE;
		double totalAssignmentScore = 0;
		// find the lowest score and keep track of it
		for(double score : aList) {
			if(lowestScore > score) {
				lowestScore = score;
				totalAssignmentScore += score;
			}
		}
		// subtract the lowest score from the total sum of aList
		totalAssignmentScore -= lowestScore;
		// return adjusted average
		return (totalAssignmentScore / (aList.size() - 1)) * ASSIGNMENT_WEIGHT;	
	}
}

class ComputeExamAvg implements Compute {
	private final double EXAM_WEIGHT = 0.60; // 60% of total weight
	
	public double computeAverage(List<Double> aList) {
		if(aList.isEmpty()) {
			return 0;
		}
		double totalAssignmentScore = 0;
		for(double score : aList) {
			totalAssignmentScore += score;
		}
		return (totalAssignmentScore / aList.size()) * EXAM_WEIGHT;
	}
	
}