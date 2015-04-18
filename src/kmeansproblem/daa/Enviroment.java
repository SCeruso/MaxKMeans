package kmeansproblem.daa;

import java.util.Random;

public class Enviroment {
	private Movement move;
	private KMeansSolution solution;
	private int index;
	
	public Enviroment(KMeansSolution solution, Movement move) {
		setSolution(solution);
		setMove(move);
		setIndex(0);
	}
	
	public KMeansSolution getNextSolutionFromEnviroment() {
		if(getIndex() >= getSolution().getSize())
			return null;
		else 
			return getMove().makeMove(getSolution().clone(), index++);
	}
	
	public KMeansSolution generateRandom() {
		Random engine = new Random();
		int choice = engine.nextInt(getSolution().getSize());
		
		return getMove().makeMove(getSolution().clone(), choice);
	}
	public boolean hasMoreSolutions() {
		return getIndex() >= getSolution().getSize()? false : true;
	}
	protected Movement getMove() {
		return move;
	}
	protected void setMove(Movement move) {
		this.move = move;
	}
	protected KMeansSolution getSolution() {
		return solution;
	}
	protected void setSolution(KMeansSolution solution) {
		this.solution = solution;
	}
	protected int getIndex() {
		return index;
	}
	protected void setIndex(int index) {
		this.index = index;
	}
	
}
