package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.Random;
/**
 * Clase que representa el entorno de una solucion.
 * El entorno viene definido por un movimiento y el numero de elementos a 
 * los que se le puede aplicar dicho movimiento. En otras palabras, el numero maximo de elementos
 * de diferencia entre la solucion y las soluciones vecinas.
 * @author sabato
 *
 */
public class Enviroment {
	private Movement move;			
	private KMeansSolution solution;
	private int[] index;
	/**
	 * 
	 * @param solution Solucion
	 * @param move Movimiento que define el entorno
	 * @param k Numero de movimientos que se le puede aplicar a la solucion para encontrar
	 * 		     una vecina
	 */
	public Enviroment(KMeansSolution solution, Movement move, int k) {
		setSolution(solution);
		setMove(move);
		setIndex(new int[k]);
	}
	public Enviroment(Movement move, int k) {
		setMove(move);
		setIndex(new int[k]);
	}
	
	/**
	 * Obtiene la siguiente solucion del entorno o null si no hay mas soluciones.
	 * @return
	 */
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
	/**
	 * Genera una solucion aleatoria del entorno.
	 * @return
	 */
	public KMeansSolution generateRandom() {
		Random engine = new Random();
		KMeansSolution aux = getSolution().clone();		
		int choice;
		for (int i = 0; i < getIndex().length; i++) {
			choice = engine.nextInt(getSolution().getSize());
			getMove().makeMove(aux, choice);
		}
		return aux;
	}
	/**
	 * 
	 * @return True si hay mas soluciones por explorar.
	 */
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
