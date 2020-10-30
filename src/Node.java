import java.util.ArrayList;

public class Node<T> {
	ArrayList<T> tokenSequence;

	Node(ArrayList<T> curSequence) {
		tokenSequence = curSequence;
	}

	ArrayList<Node> children;

	boolean addNode(Node node) {
		boolean found = false;

		if (node.getTokenSequence().equals(tokenSequence)) { // if token sequence of THIS node is the token sequence of
																// the added node
			found = true;
		} else if (amIASuffix(node) || (tokenSequence.size() == 0)) {

			int i = 0;
			while (i <= children.size()) {
				found = children.get(i).addNode(node);
				if (found = false) {
					break;
				}
				i++;
			}

			if (!found) {
				children.add(node);
			}

		}
		return found;

	}

	ArrayList<T> getTokenSequence() {

		return tokenSequence;

	}

	boolean amIASuffix(Node node) {
		boolean suffix = false;
		// try to figure this out using notes
		// if (node.tokenSequence.subList(2, 4))

		return suffix;

	}

	void print() {

	}

}
