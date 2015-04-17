package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public abstract class Problem {
	private boolean isMaxProblem;
	
	public Problem(boolean isMax) {
		setMaxProblem(isMax);
	}

	public boolean isMaxProblem() {
		return isMaxProblem;
	}

	public void setMaxProblem(boolean isMaxProblem) {
		this.isMaxProblem = isMaxProblem;
	}
	
	public boolean areEqual (Solution solution1, Solution solution2) {
		if (solution1.getScore() == null)
			evaluate(solution1);
		if (solution2.getScore() == null)
			evaluate(solution2);
		
		return solution1.equals(solution2) && solution1.getScore() == solution2.getScore();
	}
	
	public boolean firstSolutionIsBetter(Solution solution1, Solution solution2) {
		if (solution1.getScore() == null)
			evaluate(solution1);
		if (solution2.getScore() == null)
			evaluate(solution2);
		
		return solution1.getScore() > solution2.getScore()? true : false;
	}
	
	public abstract void evaluate(Solution solution);
}
