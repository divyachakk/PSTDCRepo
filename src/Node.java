import java.util.ArrayList;

public class Node {
	int tokenSequence;
	ArrayList<Node> children;
	
	boolean addNode(Node node) {
		boolean found = false;

		if (node.tokenSequence == node.tokenSequence) { // if token sequence of THIS node is the token sequence
			found = true;
		} // else if (amIASuffix(node == tokenSequence.size() == 0){

		// }
		return found;

	}
	
	void print(){
		
	}

	boolean amIASuffix(Node node) {

		return false;

	}



}
