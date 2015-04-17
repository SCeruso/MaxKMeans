package kmeansproblem.daa;

import java.io.FileNotFoundException;
import java.util.BitSet;

import javax.swing.JMenu;

public class Main {

	public static void main(String[] args) {
		KMeansProblem problem = new KMeansProblem(true);
		KMeansSolution sol = new KMeansSolution();
		
		
		sol.addElement(7);
		sol.addElement(5);
	
		try {
			problem.read("res/problems/max-mean-div-10.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		problem.evaluate(sol);
		System.out.println(sol.getScore());
	}

}


// Seguir con el reader.
// Implementar cruce para ags