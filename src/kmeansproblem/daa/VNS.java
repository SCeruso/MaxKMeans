package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;

import structure.problemsolvingmethods.daa.SolutionMethod;
/**
 * Clase para implementar el algoritmo VNS. Utilizara un minimo de 3 entornos: eliminar un elemento, añadir
 * un elemento, e intercambiar un elemento respectivamente. Los subsiguientes posibles entornos seran 
 * intercambiar 2 elementos, 3 elementos, 4... y asi sucesivamente segun el parametro de k.
 * 
 * @author sabato
 *
 */
public class VNS extends SolutionMethod{
	private ArrayList<Enviroment> enviroments;					// Lista de entornos.
	
	/**
	 * @param problem Problema a resolver.
	 * @param k Numero maximo de entornos.
	 * @throws IllegalArgumentException Si k es menor a 3.
	 */
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
