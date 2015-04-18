package kmeansproblem.daa;

import structure.problemsolvingmethods.daa.SolutionMethod;



public class GRASPandLocalSearch extends SolutionMethod {
	private ConstructiveGRASP grasp;
	private LocalSearch localSearch;
	
	public GRASPandLocalSearch(KMeansProblem problem, int lrc, int type) {
		setProblem(problem);
		if (type == ConstructiveGRASP.DIRECT)
			setGrasp(new DirectConstructiveGRASP(problem, lrc));
		else
			setGrasp(new ReverseConstructiveGRASP(problem, lrc));
		
	}
	@Override
	public void runSearch() {
		getGrasp().runSearch();
		setLocalSearch(new LocalSearch((KMeansProblem)getProblem(), (KMeansSolution)getGrasp().getBestSolution()));
		getLocalSearch().runSearch();
		setBestSolution(getLocalSearch().getBestSolution());
	}
	private ConstructiveGRASP getGrasp() {
		return grasp;
	}
	private void setGrasp(ConstructiveGRASP grasp) {
		this.grasp = grasp;
	}
	private LocalSearch getLocalSearch() {
		return localSearch;
	}
	private void setLocalSearch(LocalSearch localSearch) {
		this.localSearch = localSearch;
	}
	
}
