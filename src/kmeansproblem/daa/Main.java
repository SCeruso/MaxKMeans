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
		try {
			KMeansProblem problem = new KMeansProblem(true, "res/problems/max-mean-div-10.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		KMeansSolution sol = new KMeansSolution(10);
		
		
		sol.addElement(7);
		sol.addElement(5);

	
		
		//problem.evaluate(sol);
		sol.getNonSolutionIndexesArray();
		System.out.println(sol.getScore());
	}

}


// Seguir con grasp, insertar en solutionmetod problema y solucion.
// Comprobar que elegir los dos mejores est� bien.
// Implementar cruce para ags