package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.io.FileNotFoundException;

import structure.problemsolvingmethods.daa.StopCriterion;

public class Main {

	public static void main(String[] args) {
		KMeansProblem problem = null;
		ConstructiveGreedy greedy;
		try {
			problem = new KMeansProblem(true, args[0]);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Debe suministrar un argumento con el nombre del fichero donde se encuentra el problema");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.DIRECT);
		
		greedy.runSearch();

		System.out.println("Best Solution greedy directo: " + greedy.getBestSolution());
		//System.out.println(greedy.getElapsedTime() + ", " + greedy.getIteration());
		greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.REVERSE);
		greedy.runSearch();
		System.out.println("Best Solution greedy inverso: " + greedy.getBestSolution());
		
		GRASPandLocalSearch grasp;
		grasp = new GRASPandLocalSearch(problem, 4, ConstructiveGRASP.DIRECT);
		grasp.runSearch();
		System.out.println("Best Solution: GRASP directo con post-procesamiento, lrc = 4 " + grasp.getBestSolution());
		grasp = new GRASPandLocalSearch(problem, 4, ConstructiveGRASP.REVERSE);
		grasp.runSearch();
		System.out.println("Best Solution: GRASP inverso con post-procesamiento, lrc = 4 " + grasp.getBestSolution());
		
		MultiStart multi = new MultiStart(problem, new RandomSolutionGenerator(problem.getNnodes()), new StopCriterion(20));
		multi.runSearch();
		System.out.println("Best Solution: multi-start" + multi.getBestSolution());
		
		VNS vns = new VNS(problem, 4);
		vns.runSearch();
		System.out.println("Best Solution: VNS, 4 entornos " + vns.getBestSolution());

	}

}