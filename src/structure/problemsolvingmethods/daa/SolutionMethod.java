package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

/**
 * Clase abstracta para la representacion de algoritmos para la resolucion de problemas.
 * @author sabato
 *
 */
public abstract class SolutionMethod {
	private int iteration;
	private int iterationOfBestSolution;
	private double elapsedTime;
	private double elapsedTimeOfBestSolution;
	private StopCriterion stopCriterion;
	private Problem problem;
	private Solution bestSolution;
	
	public SolutionMethod() {
		setStopCriterion(new StopCriterion());
	}
	/**
	 * Ejecuta la busqueda de la solucion.
	 */
	public abstract void runSearch();
	
	public void resetIteration() {
		setIteration(0);
	}
	public void resetIterationOfBestSolution() {
		setIterationOfBestSolution(0);
	}
	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public int getIterationOfBestSolution() {
		return iterationOfBestSolution;
	}

	public void setIterationOfBestSolution(int iterationOfBestSolution) {
		this.iterationOfBestSolution = iterationOfBestSolution;
	}

	public double getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(double elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public double getElapsedTimeOfBestSolution() {
		return elapsedTimeOfBestSolution;
	}

	public void setElapsedTimeOfBestSolution(double elapsedTimeOfBestSolution) {
		this.elapsedTimeOfBestSolution = elapsedTimeOfBestSolution;
	}

	public StopCriterion getStopCriterion() {
		return stopCriterion;
	}

	public void setStopCriterion(StopCriterion stopCriterion) {
		this.stopCriterion = stopCriterion;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public Solution getBestSolution() {
		return bestSolution;
	}

	public void setBestSolution(Solution bestSolution) {
		this.bestSolution = bestSolution;
	}

	
}
