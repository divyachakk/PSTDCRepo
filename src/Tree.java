import java.util.ArrayList;

public class Tree<T> {
	Node root;
	ArrayList<T> curSequence = new ArrayList<T>();
	int L; // maximum token sequence length

	Tree(int length) {
		L = length;

	}

	void train(ArrayList<T> input) {
		for (int i = 1; i <= L; i++) { // i is the current order number

			for (int j = 0; j < input.size() - (i - 1); j++) { // j is the index into the input
				ArrayList<T> curSequence = new ArrayList<T>();
				for (int q = j ; q < j + i; q++) { // j - (L - 1) - q <= j have to change what q is looking
															// through to get it to parse through orderM size
					curSequence.add(input.get(q));
				}
				System.out.println(curSequence);
				 Node newNode = new Node(curSequence);
				 System.out.println(newNode);
				 root.addNode(newNode);

			}
		}

	}

	void print() {

	}

}
