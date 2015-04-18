package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Dise�o y an�lisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;
import java.util.Random;

import structure.problemsolvingmethods.daa.SolutionMethod;

/**
 * Algoritmo que realiza la fase constructiva del GRASP.
 * @author sabato
 *
 */
public abstract class ConstructiveGRASP extends SolutionMethod {
	private ArrayList<KMeansSolution> lrc;
	private Integer lrcSize;
	private KMeansSolution actualSolution;
	private Movement move;
	public static final int DIRECT = 0;
	public static final int REVERSE = 1;
	
	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param lrc Tamaño de la lista restringida de candidatos.
	 * @param type Tipo de grasp, si construye añadiendo o quitando nodos.
	 */
	public ConstructiveGRASP(KMeansProblem problem, int lrc, int type) {
		setLrc(new ArrayList<KMeansSolution>());
		setLrcSize(lrc);
		setProblem(problem);
		setBestSolution(new KMeansSolution(problem.getNnodes()));
		setActualSolution(new KMeansSolution(problem.getNnodes()));
		
		if (type == DIRECT)
			setMove(new AdditionMovement());
		else
			setMove(new RemovalMovement());
	}
	
	@Override
	public void runSearch() {			
		long time = System.currentTimeMillis();
		int iteration = 0;
		
		initialize();
		
		while (true) {
			iteration++;
			makeLrc();
			if (getLrc().size() == 0)
				break;
			selectFromLRC();
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getBestSolution())) {
				setBestSolution(getActualSolution());
				setIterationOfBestSolution(iteration);
			}
		}
		setIteration(iteration);
		setElapsedTime(System.currentTimeMillis() - time);
		setElapsedTimeOfBestSolution(getElapsedTime());
	}
	/**
	 * Selecciona un candidato al azar de la lista restringida de candidatos.
	 */
	private void selectFromLRC() {
		Random engine = new Random();
		int choice = engine.nextInt(getLrc().size());
		
		setActualSolution(getLrc().get(choice));	
	}
	/**
	 * Inserta una solucion en la lista, se mantendra siempre ordenada.
	 * @param sol
	 * @return
	 */
	private boolean insertLrc(KMeansSolution sol) {
		int i = 0;
		int j = i + 1;
		
		getLrc().add(0, sol);
		
		while (j < getLrc().size()) {
			if (getLrc().get(j) == null) {
				getLrc().set(j, sol);
				break;
			}
			else if (!getProblem().firstSolutionIsBetter(sol, getLrc().get(j))) 
				break;
			getLrc().set(j - 1, getLrc().get(j));
			j++;
		}
		getLrc().set(j - 1, sol);
		if (getLrc().size() > getLrcSize())
			getLrc().remove(0);
		
		return getLrc().contains(sol);
	}
	/**
	 * Realiza la lista restringida de candidatos.
	 */
	private void makeLrc() {			
		int nonInsertedNodes[];
		KMeansSolution aux = getActualSolution().clone();
		setLrc(new ArrayList<KMeansSolution>(getLrcSize()));
		int j = 0;
		
		if(getMove() instanceof AdditionMovement) {
			nonInsertedNodes= getActualSolution().getNonSolutionIndexesArray();
		}
		else
			nonInsertedNodes= getActualSolution().getSolutionIndexesArray();
		
		for (int i = 0; i < nonInsertedNodes.length; i++) {
			getMove().makeMove(aux, nonInsertedNodes[i]);
			getProblem().evaluate(aux);
			if (getProblem().firstSolutionIsBetter(aux, getActualSolution()))
				insertLrc(aux);
			aux = getActualSolution().clone();
		}

		while (getLrc().size() > 0 && j < getLrc().size())
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getLrc().get(j)))
				getLrc().remove(j);
			else
				j++;
	}
	/**
	 * Inicializa el grasp con una solucion.
	 */
	protected abstract void initialize();
	
	public ArrayList<KMeansSolution> getLrc() {
		return lrc;
	}
	
	public void setLrc(ArrayList<KMeansSolution> lrc) {
		this.lrc = lrc;
	}
	
	public Integer getLrcSize() {
		return lrcSize;
	}
	
	public void setLrcSize(Integer lrcSize) {
		this.lrcSize = lrcSize;
	}

	protected KMeansSolution getActualSolution() {
		return actualSolution;
	}

	protected void setActualSolution(KMeansSolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	
	protected Movement getMove() {
		return move;
	}

	protected void setMove(Movement move) {
		this.move = move;
	}	
}
