package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y análisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, EspaÃ±a.
 */
import java.util.ArrayList;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class ConstructiveGRASP extends SolutionMethod {
	private ArrayList<KMeansSolution> lrc;
	
	public ConstructiveGRASP(KMeansProblem problem, int lrc) {
		setLrc(new ArrayList<KMeansSolution>(lrc));
		setProblem(problem);
		setBestSolution(new KMeansSolution(problem.getNnodes()));
	}
	@Override
	public void runSearch() {
		// Encontrar los dos mas amigos
		// Ir buscando los mejores candidatos a insertar
		// Tirada aleatoria entre los mejores
		
	}
	
	private void findBestAffinity() {
		KMeansProblem problem = (KMeansProblem)getProblem();
		KMeansSolution sol = (KMeansSolution)getBestSolution();	
		Integer max = problem.getAffinity(0, 1);
		int firstNode = -1;
		int secondNode = -1;
		
		for (int i = 0; i < problem.getAffinities().size(); i++) {					// Cuidado por aca.
			for (int j = i + 1; j < problem.getNnodes(); j++) {
				if (max < problem.getAffinity(i, j)) {
					max = problem.getAffinity(i, j);
					firstNode = i;
					secondNode = j;
				}
			}
		}
		sol.addElement(firstNode);
		sol.addElement(secondNode);
	}
	public ArrayList<KMeansSolution> getLrc() {
		return lrc;
	}
	public void setLrc(ArrayList<KMeansSolution> lrc) {
		this.lrc = lrc;
	}

	
}
