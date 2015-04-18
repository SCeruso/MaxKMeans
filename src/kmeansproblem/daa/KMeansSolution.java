package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.BitSet;

import structure.problemsolvingmethods.daa.Solution;

public class KMeansSolution extends Solution{
	private BitSet solutionSet;
	private int size;
	
	public KMeansSolution(BitSet set, int n) {
		setSolutionSet(set);
		setSize(n);
	}
	public KMeansSolution(int n) {
		setSize(n);
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
	
	public int[] getNonSolutionIndexesArray() {
		int j = 0;
		int solutionNodes[] = new int[getSize() - getSolutionSet().cardinality()];
		
		for (int i = getSolutionSet().nextClearBit(0); i < getSize(); i = getSolutionSet().nextClearBit(i+1)) {
		     solutionNodes[j++] = i;	
		     if (i == Integer.MAX_VALUE) {
		         break; // or (i+1) would overflow
		     }
		 }
		
		return solutionNodes;
	}
	public KMeansSolution clone() {
		BitSet aux = (BitSet)getSolutionSet().clone();
		return new KMeansSolution(aux, getSize());
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
	
	public void flipElement(int n) {
		getSolutionSet().flip(n);
	}
	public BitSet getSolutionSet() {
		return solutionSet;
	}

	public void setSolutionSet(BitSet solutionSet) {
		this.solutionSet = solutionSet;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		return getSolutionSet().toString() + ", " + getScore();
	}
	
}
