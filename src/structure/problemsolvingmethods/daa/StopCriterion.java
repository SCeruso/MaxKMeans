package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class StopCriterion {
	private long iteration;
	private long max;
	
	public StopCriterion() {
		
	}
	public StopCriterion(long max) {
		setMax(max);
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
