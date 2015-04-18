package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
/**
 * Interfaz que representa un movimiento sobre un elemento.
 * @author sabato
 *
 */
public interface Movement {

	public KMeansSolution makeMove (KMeansSolution solution, int index );
}
