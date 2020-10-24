import java.util.ArrayList;

public class Node<T> extends Tree<T> {

	Node(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	ArrayList<T> tokenSequence;
	ArrayList<Node> children;

	boolean addNode(Node node) {
		boolean found = false;

		if (node.tokenSequence == root.tokenSequence) { // if token sequence of THIS node is the token sequence of the
														// added node
			found = true;
		} else if (amIASuffix(node) || (tokenSequence.size() == 0)) {

			// 1.try to add the node to all the children nodes.
			// 2.Did one your child nodes add the node? **keep track of this via the found
			// variable**
			// If NOT found and the length of node’s tokenSequence is one less than this
			// tokenSequenceAdd the node to our children array.
			// Thus-found=true.children.add(node);

			//what does everything above this say
			if (found = true) { 
				children.add(node);
			}

		}
		return found;

	}

	void print() {

	}

	boolean amIASuffix(Node node) {
		//try to figure this out using notes

		return false;

	}

}
