package kmeansproblem.daa;

import java.util.Random;

public class Enviroment {
	private Movement move;
	private KMeansSolution solution;
	private int[] index;
	
	public Enviroment(KMeansSolution solution, Movement move, int k) {
		setSolution(solution);
		setMove(move);
		setIndex(new int[k]);
		//getIndex()[k - 1] = -1;
	}
	public Enviroment(Movement move, int k) {
		setMove(move);
		setIndex(new int[k]);
	//	getIndex()[k - 1] = -1;
	}
	public KMeansSolution getNextSolutionFromEnviroment() {
		
		for (int i = getIndex().length - 1; i >= 0; i--) {
			if (getIndex()[i] >= getSolution().getSize() - 1){
				getIndex()[i] = 0;
			}
			else {
				KMeansSolution aux = getSolution().clone();
				
				getIndex()[i]++;
				for (int j = 0; j < getIndex().length; j++) {
					getMove().makeMove(aux, getIndex()[j]);
				}
				return aux;
			}
		}
		return null;
	}
	
	public KMeansSolution generateRandom() {
		Random engine = new Random();
		KMeansSolution aux = getSolution().clone();		
		int choice;
		for (int i = 0; i < getIndex().length; i++) {
			choice = engine.nextInt(getSolution().getSize());
			getMove().makeMove(aux, getIndex()[i]);
		}
		return aux;
	}
	public boolean hasMoreSolutions() {
		for (int i = 0; i < getIndex().length; i++)
			if (getIndex()[i] < getSolution().getSize() - 1)
				return true;
		return false;
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
	protected int[] getIndex() {
		return index;
	}
	protected void setIndex(int[] index) {
		this.index = index;
	}
	
}
