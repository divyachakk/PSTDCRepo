//Programmer: Divya Chakkaram
//Date: Oct 27, 2020

import java.util.ArrayList;

public class Node<T> {
	ArrayList<T> tokenSequence; // create a new ArrayList, tokenSequence
	int count = 1;

	Node(ArrayList<T> curSequence) { // Node constructor takes curSequence ArrayList
		tokenSequence = curSequence; // set the constructor variable value equal to the global variable value
	}

	ArrayList<Node> children = new ArrayList<Node>(); // create a new ArrayList of Nodes, children, to be filled one by
														// one with the addNode function and newNodes

	boolean addNode(Node node) { // boolean method to addNodes
		boolean found = false; // start the boolean variable found equal to false

		if (node.getTokenSequence().equals(tokenSequence)) { // if token sequence of THIS node is the token sequence of
																// the added node
			found = true; // set found variable equal to true
			count++;
			// System.out.println(count);
		} else if (amIASuffix(node) || (tokenSequence.size() == 0)) { // however if the added node is a suffix and the
																		// size of the tokenSequence equals zero

			int i = 0;
			while (i < children.size() && !found) { // while i is parsing through the children ArrayList and not found
				found = children.get(i).addNode(node); // set found variable equal to children.get(i).addNode(node),
														// checking to see if the node already exists
				i++; // increase variable i by 1 and go back through while loop
			}

			if (!found) { // if not found
				children.add(node); // add the new node to the children ArrayList
				found = true; // set found variable back to true
			}

		}
		return found; // return value of boolean found variable

	}

	ArrayList<T> getTokenSequence() {

		return tokenSequence; // returning the added node tokenSequence

	}

	boolean amIASuffix(Node node) { // checking to see if the added node is a suffix of the input
		boolean truth = false; // set the boolean truth to false
		if (tokenSequence.equals(node.getTokenSequence().subList(node.getTokenSequence().size() - tokenSequence.size(),
				node.getTokenSequence().size()))) { // check if the particular node's value equals a suffix value at the
													// end of the input string
			truth = true; // if above is true, set variable truth to true
		} else { // if particular node is not a suffix of the input arrayList
			truth = false; // set variable truth to false
		}

		return truth; // return value of boolean variable truth

	}

	void print() { // print method
		System.out.println(tokenSequence); // print out the tokensequence of addednode

		for (int i = 0; i < children.size(); i++) { // going through children arraylist and each node in children
			children.get(i).print(1); // print out the node value
		}

	}

	void print(int numSpacesBefore) { // print method with overloaded constructor

		for (int i = 1; i <= numSpacesBefore; i++) { // going from one through the number of spaces filled in the
														// constructor
			System.out.print(" "); // print out a space
		}

		System.out.print("-->"); // print an arrow
		System.out.println(tokenSequence); // println the tokenSequence value

		for (int j = 0; j < children.size(); j++) { // for each node in children
			children.get(j).print(numSpacesBefore + 1); // print out the respective node value with overloaded
														// constructor
		}

	}

	boolean pMinElimination(int totalTokens, float pMin) {
		boolean shouldRemove = false;
		float empiricalProb = 0;

		empiricalProb = count / (totalTokens - tokenSequence.size() - 1);
		shouldRemove = empiricalProb < pMin;

		if (!shouldRemove || empiricalProb == 0) { // how do you let the empty tokenSequence pass?
			// for each node
			for (int i = children.size(); i > 0; i--) { // do you include the zero? in other words, i >= 0?
				if (children.get(i).pMinElimination(totalTokens, (float) 0.1)) { //what is the value you put in the first spot
					children.remove(i);
				}
			}

		}

		return shouldRemove;
	}

}
