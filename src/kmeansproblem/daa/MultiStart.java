package kmeansproblem.daa;

import structure.problemsolvingmethods.daa.SolutionMethod;
import structure.problemsolvingmethods.daa.StopCriterion;

public class MultiStart extends SolutionMethod{
	private SolutionGenerationMethod generator;
	private LocalSearch localSearch;
	private KMeansSolution actualSolution;
	
	public MultiStart(KMeansProblem problem, SolutionGenerationMethod generator, StopCriterion criterion) {
		setGenerator(generator);
		setStopCriterion(criterion);
		setProblem(problem);
	}
	@Override
	public void runSearch() {
		setBestSolution(getGenerator().generate());
		do {	
			getStopCriterion().iterationIncrease();
			setActualSolution(getGenerator().generate());
			setLocalSearch(new LocalSearch((KMeansProblem)getProblem(), (KMeansSolution)getActualSolution()));
			getLocalSearch().runSearch();
			setActualSolution((KMeansSolution)getLocalSearch().getBestSolution());
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getBestSolution())){
				setBestSolution(getActualSolution());
				getStopCriterion().resetIteration();
			}
		} while (!getStopCriterion().stop());
	}
	private SolutionGenerationMethod getGenerator() {
		return generator;
	}
	private void setGenerator(SolutionGenerationMethod generator) {
		this.generator = generator;
	}
	private LocalSearch getLocalSearch() {
		return localSearch;
	}
	private void setLocalSearch(LocalSearch localSearch) {
		this.localSearch = localSearch;
	}
	private KMeansSolution getActualSolution() {
		return actualSolution;
	}
	private void setActualSolution(KMeansSolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	
	
}
