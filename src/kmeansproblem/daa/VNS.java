package kmeansproblem.daa;

import java.util.ArrayList;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class VNS extends SolutionMethod{
	private ArrayList<Enviroment> enviroments;
	
	public VNS (KMeansProblem problem, int k) {
		setProblem(problem);
	}
	@Override
	public void runSearch() {
		// TODO Auto-generated method stub
		
	}
	private ArrayList<Enviroment> getEnviroments() {
		return enviroments;
	}
	private void setEnviroments(ArrayList<Enviroment> enviroments) {
		this.enviroments = enviroments;
	}

}
