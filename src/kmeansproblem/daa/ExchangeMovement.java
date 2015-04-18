package kmeansproblem.daa;

public class ExchangeMovement implements Movement{

	@Override
	public KMeansSolution makeMove(KMeansSolution solution, int index) {
		solution.flipElement(index);
		return solution;
	}

}
