package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

/**
 * Clase abstracta para la reprecentacion de soluciones.
 * @author sabato
 *
 */
public abstract class Solution {

	private Double score;			// Puntuacion, o valor segun el problema.
	
	public Solution(Double score) {
		setScore(score);
	}

	public Solution() {
		setScore(null);
	}
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public abstract boolean equals(Solution solution);
}
