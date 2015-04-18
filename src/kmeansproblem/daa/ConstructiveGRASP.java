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

public abstract class ConstructiveGRASP extends SolutionMethod {
	private ArrayList<KMeansSolution> lrc;
	private Integer lrcSize;
	private KMeansSolution actualSolution;
	private Movement move;
	public static final int DIRECT = 0;
	public static final int REVERSE = 1;
	
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
	
	
	// Ir buscando los mejores candidatos a insertar
	// Tirada aleatoria entre los mejores
	@Override
	public void runSearch() {			
		initialize();
		
		while (true) {
			makeLrc();
			if (getLrc().size() == 0)
				break;
			selectFromLRC();
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getBestSolution()))
				setBestSolution(getActualSolution());
		}
		
	}
	
	private void selectFromLRC() {		// Pensar si implementar como interfaz y componer.
		Random engine = new Random();
		int choice = engine.nextInt(getLrc().size());
		
		setActualSolution(getLrc().get(choice));	
	}
	
	private boolean insertLrc(KMeansSolution sol) {	// Probar!!!!
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
	
	private void makeLrc() {			// Probar
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
			insertLrc(aux);
			aux = getActualSolution().clone();
		}

		while (getLrc().size() > 0 && j < getLrc().size())
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getLrc().get(j)))
				getLrc().remove(j);
			else
				j++;
	}
	
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
