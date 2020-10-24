import java.util.ArrayList;

public class Tree<T> {
	Node root;
	int L; // maximum token sequence length

	Tree(int length) {
		L = length;

	}

	void train(ArrayList<T> input) {
		for (int i = L; i < L; i++) { // i is the current order number

			for (int j = 0; j < input.size() - (i - 1); j++) { // j is the index into the input
				Node curSequence = (Node) input.get(j);
				Node newNode = curSequence;
				root.addNode(newNode);

			}
		}

	}

	void print() {

	}

}
