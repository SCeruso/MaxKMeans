package kmeansproblem.daa;

public class RemovalMovement implements Movement{

	@Override
	public KMeansSolution makeMove(KMeansSolution solution, int index) {
		solution.removeElement(index);
		return solution;
	}

}
