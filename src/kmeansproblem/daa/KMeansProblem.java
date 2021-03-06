package kmeansproblem.daa;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import structure.problemsolvingmethods.daa.Problem;
import structure.problemsolvingmethods.daa.Solution;
/**
 * Clase que representa el problema del la maxima k media.
 * @author sabato
 *
 */
public class KMeansProblem extends Problem {
	private ArrayList<ArrayList<Integer>> affinities;			// Grafo de afinidades.
	private int Nnodes;
	
	/**
	 * 
	 * @param max True si es un problemas de maximizar.
	 * @param filename Nombre del archivo donde se encuentra el grafo
	 * @throws FileNotFoundException
	 */
	public KMeansProblem(boolean max, String filename) throws FileNotFoundException {
		super(max);
		setAffinities(new ArrayList<ArrayList<Integer>>());
		
		try {
			read(filename);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}

	@Override
	public void evaluate(Solution solution) {
		KMeansSolution sol = (KMeansSolution) solution;
		int solutionNodes[] = sol.getSolutionIndexesArray();
		Double totalAffinity = 0.0;

		for (int i = 0; i < solutionNodes.length; i++) {
			for (int j = i + 1; j < solutionNodes.length; j++) {
				totalAffinity += getAffinity(solutionNodes[i], solutionNodes[j]);
			}
		}

		sol.setScore(totalAffinity / (double) solutionNodes.length);
	}

	public ArrayList<ArrayList<Integer>> getAffinities() {
		return affinities;
	}

	public void setAffinities(ArrayList<ArrayList<Integer>> costs) {
		this.affinities = costs;
	}

	/**
	 * Obtiene la afinidad del nodo p con el nodo q
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public Integer getAffinity(int p, int q) {
		int min = Math.min(p, q);
		int max = Math.max(p, q);

		try {
			return getAffinities().get(min).get(max - min - 1); // Testear
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Lee de fichero el grafo
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void read(String filename) throws FileNotFoundException {
		Scanner scanner = null;
		Integer nNodes = -1;
		int j;
		int node;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			throw new FileNotFoundException(e.getMessage());
		}
		nNodes = new Integer(scanner.nextLine());
		setNnodes(nNodes);
		j = nNodes - 1;

		try {
			while (scanner.hasNext()) {
				node = getAffinities().size();
				getAffinities().add(new ArrayList<Integer>());
				for (int i = 0; i < j; i++) {
					getAffinities().get(node).add(
							new Integer(scanner.nextLine()));
				}
				j--;
			}
		} catch (Exception e) {
			System.err.println("Fichero mal escrito");
			throw new RuntimeException();
		} finally {
			scanner.close();
		}
	}

	public int getNnodes() {
		return Nnodes;
	}

	public void setNnodes(int nnodes) {
		Nnodes = nnodes;
	}

}
