package kmeansproblem.daa;

import java.util.Random;

public class RandomSolutionGenerator implements SolutionGenerationMethod{
	private int size;
	
	public RandomSolutionGenerator(int size) {
		setSize(size);
	}
	@Override
	public KMeansSolution generate() {
		Random engine = new Random();
		KMeansSolution result = new KMeansSolution(getSize());
		
		for (int i = 0; i < size; i++) 
			if (engine.nextBoolean())
				result.addElement(i);
		
		return result;			
	}
	private int getSize() {
		return size;
	}
	private void setSize(int size) {
		this.size = size;
	}
	
}
