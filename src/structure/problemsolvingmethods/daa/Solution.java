package structure.problemsolvingmethods.daa;

public abstract class Solution {

	private Double score;
	
	public Solution(Double score) {
		setScore(score);
	}

	public Solution() {
		setScore(null);
	}
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public abstract boolean equals(Solution solution);
}
