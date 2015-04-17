package structure.problemsolvingmethods.daa;

public class StopCriterion {
	private long iteration;
	private long max;
	
	public StopCriterion() {
		
	}
	
	public boolean stop() {
		return getIteration() >= getMax()?  true : false;
	}
	
	public void resetIteration() {
		setIteration(0);
	}
	public void iterationIncrease() {
		setIteration(getIteration() + 1);
	}
	public long getIteration() {
		return iteration;
	}
	public void setIteration(long iteration) {
		this.iteration = iteration;
	}
	public long getMax() {
		return max;
	}
	public void setMax(long max) {
		this.max = max;
	}

	
}
