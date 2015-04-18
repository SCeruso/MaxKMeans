package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import structure.problemsolvingmethods.daa.SolutionMethod;
import structure.problemsolvingmethods.daa.StopCriterion;
/**
 * Clase que realiza un algoritmo multiarranque con una busqueda local con un entorno
 * de tipo intercambio de un elemento generando las soluciones de manera aleatoria.
 * El criterio de parada se establece a numero maximo de iteraciones sin mejora.
 * @author sabato
 *
 */
public class MultiStart extends SolutionMethod{
	private SolutionGenerationMethod generator;
	private LocalSearch localSearch;
	private KMeansSolution actualSolution;
	
	public MultiStart(KMeansProblem problem, SolutionGenerationMethod generator, StopCriterion criterion) {
		setGenerator(generator);
		setStopCriterion(criterion);
		setProblem(problem);
	}
	@Override
	public void runSearch() {
		int iteration = 0;
		long time = System.currentTimeMillis();
		setBestSolution(getGenerator().generate());
		do {
			iteration++;
			getStopCriterion().iterationIncrease();
			setActualSolution(getGenerator().generate());
			setLocalSearch(new LocalSearch((KMeansProblem)getProblem(), (KMeansSolution)getActualSolution()));
			getLocalSearch().runSearch();
			setActualSolution((KMeansSolution)getLocalSearch().getBestSolution());
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getBestSolution())){
				setBestSolution(getActualSolution());
				getStopCriterion().resetIteration();
			}
		} while (!getStopCriterion().stop());
		
		setIteration(iteration);
		setElapsedTime(System.currentTimeMillis() - time);
	}
	private SolutionGenerationMethod getGenerator() {
		return generator;
	}
	private void setGenerator(SolutionGenerationMethod generator) {
		this.generator = generator;
	}
	private LocalSearch getLocalSearch() {
		return localSearch;
	}
	private void setLocalSearch(LocalSearch localSearch) {
		this.localSearch = localSearch;
	}
	private KMeansSolution getActualSolution() {
		return actualSolution;
	}
	private void setActualSolution(KMeansSolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	
	
}
