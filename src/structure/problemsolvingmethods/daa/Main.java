package structure.problemsolvingmethods.daa;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		BitSet a = new BitSet(4);
		BitSet b = new BitSet(3);
		a.insert(1);
		//a.insert();
		b.insert(1);
		
		System.out.println(BitSet.containsSet(a, b));

	}

}
