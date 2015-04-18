package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.io.FileNotFoundException;
import java.util.BitSet;

import javax.swing.JMenu;

public class Main {

	public static void main(String[] args) {
		KMeansProblem problem;
		ConstructiveGreedy greedy;
		try {
			problem = new KMeansProblem(true, "res/problems/max-mean-div-10.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.REVERSE);
		
		greedy.runSearch();

		System.out.println("Best Solution: " + greedy.getBestSolution());

		greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.DIRECT);
		greedy.runSearch();
		System.out.println("Best Solution: " + greedy.getBestSolution());
		
		GRASPandLocalSearch grasp;
		grasp = new GRASPandLocalSearch(problem, 2, ConstructiveGRASP.REVERSE);
		grasp.runSearch();
		System.out.println("Best Solution: " + grasp.getBestSolution());
		
	}

}


// Seguir con grasp, insertar en solutionmetod problema y solucion.
// Comprobar que elegir los dos mejores est� bien.
// Implementar cruce para ags