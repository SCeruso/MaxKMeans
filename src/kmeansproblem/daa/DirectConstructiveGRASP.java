package kmeansproblem.daa;

import java.util.ArrayList;

/**
 * @author sabato
 *
 */
public class DirectConstructiveGRASP extends ConstructiveGRASP {

	public DirectConstructiveGRASP(KMeansProblem problem, int lrc) {
		super(problem, lrc, ConstructiveGRASP.DIRECT);
	}
	

	
	// Encontrar los dos mas amigos
	@Override
	protected void initialize() {				
		KMeansProblem problem = (KMeansProblem)getProblem();
		KMeansSolution sol = getActualSolution();	
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
		setBestSolution(sol);
	}
}
