package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
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
