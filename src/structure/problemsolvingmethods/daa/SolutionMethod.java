package structure.problemsolvingmethods.daa;

public abstract class SolutionMethod {
	private int iteration;
	private int iterationOfBestSolution;
	private double elapsedTime;
	private double elapsedTimeOfBestSolution;
	private StopCriterion stopCriterion;
	
	public SolutionMethod() {
		setStopCriterion(new StopCriterion());
	}
	
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

}
