package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

/**
 * Clase que realiza el algoritmo GRASP a a partir de una solucion con todos los nodos y los va 
 * eliminando.
 * @author sabato
 *
 */
public class ReverseConstructiveGRASP extends ConstructiveGRASP {

	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param lrc Tamaño de la lista restringida de candidatos.
	 */
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
