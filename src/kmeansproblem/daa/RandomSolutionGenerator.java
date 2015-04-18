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
 * Clase que genera soluciones de manera aleatoria.
 * @author sabato
 *
 */
public class RandomSolutionGenerator implements SolutionGenerationMethod{
	private int size;
	
	public RandomSolutionGenerator(int size) {
		setSize(size);
	}
	@Override
	public KMeansSolution generate() {
		Random engine = new Random();
		KMeansSolution result = new KMeansSolution(getSize());
		
		for (int i = 0; i < size; i++) 
			if (engine.nextBoolean())
				result.addElement(i);
		
		return result;			
	}
	private int getSize() {
		return size;
	}
	private void setSize(int size) {
		this.size = size;
	}
	
}
