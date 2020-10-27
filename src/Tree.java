import java.util.ArrayList;

public class Tree<T> {
	Node root;
	ArrayList<T> curSequence = new ArrayList<T>();
	int L; // maximum token sequence length

	Tree(int length) {
		L = length;

	}

	void train(ArrayList<T> input) {
		for (int i = L; i < L; i++) { // i is the current order number

			for (int j = 0; j < input.size() - (i - 1); j++) { // j is the index into the input
				curSequence.add(input.get(j));
				Node newNode = curSequence;
				root.addNode(newNode);

			}
		}

	}

	void print() {

	}

}
