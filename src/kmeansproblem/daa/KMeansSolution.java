package kmeansproblem.daa;

import java.util.BitSet;

import structure.problemsolvingmethods.daa.Solution;

public class KMeansSolution extends Solution{
	private BitSet solutionSet;
	
	public KMeansSolution() {
		setSolutionSet(new BitSet());
	}

	@Override
	public boolean equals(Solution solution) {
		KMeansSolution sol = (KMeansSolution) solution;
		return getSolutionSet().equals(sol.getSolutionSet()) && getScore() == solution.getScore();
	}

	public int[] getSolutionIndexesArray() {
		int j = 0;
		int solutionNodes[] = new int[getSolutionSet().cardinality()];
		
		for (int i = getSolutionSet().nextSetBit(0); i >= 0; i = getSolutionSet().nextSetBit(i+1)) {
		     solutionNodes[j++] = i;	
		     if (i == Integer.MAX_VALUE) {
		         break; // or (i+1) would overflow
		     }
		 }
		
		return solutionNodes;
	}
	public boolean containsElement(int n) {
		return getSolutionSet().get(n);
	}
	public void addElement(int n) {
		getSolutionSet().set(n);
	}
	public void removeElement(int n) {
		getSolutionSet().clear(n);
	}
	public BitSet getSolutionSet() {
		return solutionSet;
	}

	public void setSolutionSet(BitSet solutionSet) {
		this.solutionSet = solutionSet;
	}

	
}
