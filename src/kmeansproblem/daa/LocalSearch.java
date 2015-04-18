package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import structure.problemsolvingmethods.daa.SolutionMethod;
/**
 * Clase que realiza una busqueda local a partir de una solucion.
 * @author sabato
 *
 */
public class LocalSearch extends SolutionMethod{
	private KMeansSolution actualSolution;
	private Enviroment enviroment;
	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param solution Solucion de partida.
	 */
	public LocalSearch(KMeansProblem problem, KMeansSolution solution){
		setActualSolution(solution);
		setProblem(problem);
		setBestSolution(getActualSolution());
		setEnviroment(new Enviroment(getActualSolution(), new ExchangeMovement(), 1));
	}
	@Override
	public void runSearch() {
		KMeansSolution aux;
		
		while (getEnviroment().hasMoreSolutions()) {
			aux = getEnviroment().getNextSolutionFromEnviroment();
			if (getProblem().firstSolutionIsBetter(aux, getActualSolution())) {
				setActualSolution(aux);
				setBestSolution(getActualSolution());
				setEnviroment(new Enviroment(aux, getEnviroment().getMove(), getEnviroment().getIndex().length));
			}
		}
		
	}
	public KMeansSolution getActualSolution() {
		return actualSolution;
	}
	public void setActualSolution(KMeansSolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	public Enviroment getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(Enviroment enviroment) {
		this.enviroment = enviroment;
	}
	
}
