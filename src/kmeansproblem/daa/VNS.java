package kmeansproblem.daa;

import java.util.ArrayList;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class VNS extends SolutionMethod{
	private ArrayList<Enviroment> enviroments;
	
	public VNS (KMeansProblem problem, int k) throws IllegalArgumentException{
		if (k < 3)
			throw new IllegalArgumentException("La k no puede ser menor a 3");
		
		setEnviroments(new ArrayList<Enviroment>());
		setProblem(problem);
		getEnviroments().add(new Enviroment(new RemovalMovement(), 1));
		getEnviroments().add(new Enviroment(new AdditionMovement(), 1));
		getEnviroments().add(new Enviroment(new ExchangeMovement(), 1));
		
		for (int i = 0; i < k - 3; i++)
			getEnviroments().add(new Enviroment(new ExchangeMovement(), i + 2));
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
