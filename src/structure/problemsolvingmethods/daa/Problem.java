package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

/**
 * Clase abstracta para representar problemas.
 * @author sabato
 *
 */
public abstract class Problem {
	private boolean isMaxProblem;				// True si el problema es de maximizar.
	
	/**
	 * 
	 * @param isMax True si el problema es de maximizar.
	 */
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
		
		return solution1.getScore() > solution2.getScore()? isMaxProblem() : !isMaxProblem();
	}
	
	public abstract void evaluate(Solution solution);
}
