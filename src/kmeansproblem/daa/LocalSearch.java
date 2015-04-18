package kmeansproblem.daa;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class LocalSearch extends SolutionMethod{
	private KMeansSolution actualSolution;
	private Enviroment enviroment;
	
	public LocalSearch(KMeansProblem problem, KMeansSolution solution){
		setActualSolution(solution);
		setProblem(problem);
		setBestSolution(getActualSolution());
		setEnviroment(new Enviroment(getActualSolution(), new ExchangeMovement()));
	}
	@Override
	public void runSearch() {
		KMeansSolution aux;
		
		while (getEnviroment().hasMoreSolutions()) {
			aux = getEnviroment().getNextSolutionFromEnviroment();
			if (getProblem().firstSolutionIsBetter(aux, getActualSolution())) {
				setActualSolution(aux);
				setBestSolution(getActualSolution());
				setEnviroment(new Enviroment(aux, new ExchangeMovement()));
			}
		}
		
	}
	public KMeansSolution getActualSolution() {
		return actualSolution;
	}
	public void setActualSolution(KMeansSolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	public Enviroment getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(Enviroment enviroment) {
		this.enviroment = enviroment;
	}
	
}
