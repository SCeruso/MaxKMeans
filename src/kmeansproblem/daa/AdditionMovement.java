package kmeansproblem.daa;

public class AdditionMovement implements Movement{

	@Override
	public KMeansSolution makeMove(KMeansSolution solution, int index) {
		solution.addElement(index);
		return solution;
	}

}
