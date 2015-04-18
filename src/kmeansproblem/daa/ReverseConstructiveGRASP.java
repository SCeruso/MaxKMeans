package kmeansproblem.daa;

public class ReverseConstructiveGRASP extends ConstructiveGRASP {

	public ReverseConstructiveGRASP(KMeansProblem problem, int lrc) {
		super(problem, lrc, ConstructiveGRASP.REVERSE);
	}

	@Override
	protected void initialize() {
		KMeansProblem problem = (KMeansProblem)getProblem();
		KMeansSolution sol = getActualSolution();
		
		for (int i = 0; i < problem.getNnodes(); i++) 
			sol.addElement(i);
		
		setBestSolution(sol);
		setActualSolution(sol);
	}

}
