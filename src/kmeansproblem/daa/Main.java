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
		KMeansProblem problem;
		ConstructiveGreedy greedy;
		try {
			problem = new KMeansProblem(true, "res/problems/max-mean-div-10.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		/*greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.DIRECT);
		
		greedy.runSearch();

		System.out.println("Best Solution: " + greedy.getBestSolution());
		System.out.println(greedy.getElapsedTime() + ", " + greedy.getIteration());

		greedy = new ConstructiveGreedy(problem, ConstructiveGreedy.DIRECT);
		greedy.runSearch();
		System.out.println("Best Solution: " + greedy.getBestSolution());*/
		
		GRASPandLocalSearch grasp;
		grasp = new GRASPandLocalSearch(problem, 2, ConstructiveGRASP.REVERSE);
		grasp.runSearch();
		System.out.println("Best Solution: " + grasp.getBestSolution());
		System.out.println(grasp.getElapsedTime() + ", " + grasp.getIteration());
		/*
		MultiStart multi = new MultiStart(problem, new RandomSolutionGenerator(problem.getNnodes()), new StopCriterion(20));
		multi.runSearch();
		System.out.println("Best Solution: " + multi.getBestSolution());
		
		VNS vns = new VNS(problem, 4);
		
		vns.runSearch();
		System.out.println("Best Solution: " + vns.getBestSolution());*/
	}

}

// Implementar cruce para ags