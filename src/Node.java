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
		//node.getTokenSequence().size()
		
		if (node.getTokenSequence().equals(tokenSequence.subList(node.getTokenSequence().size(), tokenSequence.size()-1))) {
			suffix = true;
			
		}
		
		if (!suffix) {
			System.out.println("yes");
		}

		return suffix;
		
	}

	void print() {

	}

}
