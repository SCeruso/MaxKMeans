package structure.problemsolvingmethods.daa;

public class BitSet {
	private int[] set;
	private int size;
	public static final int BLOCK_SIZE = 32;
	
	public BitSet() {
		setSize(0);
	}

	public BitSet(int size) throws IllegalArgumentException {
		resize(size);
	}
	
	public void resize(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("No se puede crear un conjunto con menos de 1 elemento");
		else {
			setSize(size);
			setSet(new int [(int)Math.ceil((double)((double)size / (double)BLOCK_SIZE))]);
		}
		for (int i = 0; i < getSet().length; i++)
			getSet()[i] = 0;
	}
	
	public void insert(int n) throws IllegalArgumentException{
		int block;
		int pos;
		int aux = 1;
		
		if (n >= size)
			throw new IllegalArgumentException("El elemento " + n + " no pertenece al conjunto, este tan solo tiene " + getSize() + " elementos.");
		else {
			block = n / BLOCK_SIZE;
			pos = n % BLOCK_SIZE;
			aux = aux << (pos);
			getSet()[block] = getSet()[block] | aux;
		}
	}
	
	public void remove(int n) throws IllegalArgumentException{
		int block;
		int pos;
		int aux = 1;
		
		if (n >= size)
			throw new IllegalArgumentException("El elemento " + n + " no pertenece al conjunto, este tan solo tiene " + getSize() + " elementos.");
		else {
			block = n / BLOCK_SIZE;
			pos = n % BLOCK_SIZE;
			aux = aux << (pos);
			aux = ~aux;
			getSet()[block] = getSet()[block] & aux;
		}
	}
	
	public boolean containsElement(int n) throws IllegalArgumentException {
		int aux = 1;
		int block;
		int pos;
		
		if (n >= size)
			throw new IllegalArgumentException("El elemento " + n + " no pertenece al conjunto, este tan solo tiene " + getSize() + " elementos.");
		
		block = n / BLOCK_SIZE;
		pos = n % BLOCK_SIZE;
		aux = aux << (pos);
		aux = aux & getSet()[block];
		
		return aux == 0? false : true;
		
	}
	public String toString() {
		String result = "";
		for (int i = 0; i < getSize(); i++) {	
			if (containsElement(i))
				result += "1";
			else 
				result += "0";	
		}
		return result;
	}
	public static boolean containsSet(BitSet set1, BitSet set2) {
		boolean result = true;
		
		for (int i = 0; i< set1.getSize(); i++) {
			if (set1.containsElement(i))
				if (set2.getSize() > i) {
					if (!set2.containsElement(i)) {
						result = false;
						break;
					}
				}
				else {
					result = false;
					break;
				}
				
		}
		return result;
	}
	
	public static boolean equals(BitSet set1, BitSet set2) {
		return containsSet(set1, set2) && containsSet(set2, set1);
	}
	public int[] getSet() {
		return set;
	}

	public void setSet(int[] set) {
		this.set = set;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
