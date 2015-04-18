package kmeansproblem.daa;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class ConstructiveGreedy extends SolutionMethod{
	private ConstructiveGRASP solutionMethod;
	public static final int DIRECT = 0;
	public static final int REVERSE = 1;
	
	public ConstructiveGreedy(KMeansProblem problem, int type) {
		if (type == DIRECT)
			setSolutionMethod(new DirectConstructiveGRASP(problem, 1));
		else
			setSolutionMethod(new ReverseConstructiveGRASP(problem, 1));
	}
	
	public void runSearch() {
		getSolutionMethod().runSearch();
		setBestSolution(getSolutionMethod().getBestSolution());
		setIterationOfBestSolution(getIterationOfBestSolution());
		setIteration(getIteration());
		setElapsedTime(getElapsedTime());
		setElapsedTimeOfBestSolution(getElapsedTimeOfBestSolution());
	}
	private ConstructiveGRASP getSolutionMethod() {
		return solutionMethod;
	}

	private void setSolutionMethod(ConstructiveGRASP solutionMethod) {
		this.solutionMethod = solutionMethod;
	}
	
	
}
