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
		RandomSolutionGenerator generator = new RandomSolutionGenerator(((KMeansProblem)getProblem()).getNnodes());
		KMeansSolution actual = generator.generate();
		KMeansSolution newSolution;
		LocalSearch localSearch;
		int k = 0;
		setBestSolution(actual);
		
		while (k < getEnviroments().size()) {
			getEnviroments().get(k).setSolution(actual);
			newSolution = getEnviroments().get(k).generateRandom();
			localSearch = new LocalSearch((KMeansProblem)getProblem(), newSolution);
			localSearch.setEnviroment(getEnviroments().get(k));
			localSearch.runSearch();
			
			if (getProblem().firstSolutionIsBetter(localSearch.getBestSolution(), actual)) {
				actual = (KMeansSolution)localSearch.getBestSolution();
				setBestSolution(actual);
				k = 0;
			}
			else
				k++;
		}
		
	}
	private ArrayList<Enviroment> getEnviroments() {
		return enviroments;
	}
	private void setEnviroments(ArrayList<Enviroment> enviroments) {
		this.enviroments = enviroments;
	}

}
