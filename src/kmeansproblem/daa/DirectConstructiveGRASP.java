package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;

/**
 * Grasp que construye la solucion añadiendo nodos.
 * @author sabato
 *
 */
public class DirectConstructiveGRASP extends ConstructiveGRASP {

	public DirectConstructiveGRASP(KMeansProblem problem, int lrc) {
		super(problem, lrc, ConstructiveGRASP.DIRECT);
	}
	

	
	/**
	 * Encuentra los dos nodos con mayor afinidad.
	 */
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
