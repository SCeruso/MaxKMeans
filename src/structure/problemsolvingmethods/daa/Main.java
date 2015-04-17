package structure.problemsolvingmethods.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
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
