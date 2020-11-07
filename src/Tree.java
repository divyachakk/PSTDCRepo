//Programmer: Divya Chakkaram
//Date: Oct 27, 2020

import java.util.ArrayList;

public class Tree<T> {
	Node root; //create the Node root
	int L; // maximum token sequence length
	int totalInputTokens;
	float pMin;

	Tree(int length, float p) { //Tree with constructor of length
		L = length; //set global and local variables for L and length equal to each other
		root = new Node(new ArrayList<T>()); //set the Node root equal to a new Node filled with constructor value of a new ArrayList
		pMin = p;
	}

	void train(ArrayList<T> input) { //train method in Tree
		for (int i = 1; i <= L; i++) { // i is the current order number, going through the value of L set manually

			for (int j = 0; j < input.size() - (i - 1); j++) { // j is the index into the input
				ArrayList<T> curSequence = new ArrayList<T>(); //create a new ArrayList, curSequence
				for (int q = j; q < j + i; q++) { // j - (L - 1) - q <= j have to change what q is looking
													// through to get it to parse through orderM size
					curSequence.add(input.get(q)); //to the ArrayList curSequence, add the value of the input ArrayList at q, through the for loop
				}

				Node newNode = new Node(curSequence); //create a new Node, and set it equal to a new Node with a constructor value of newly filled curSequence ArrayList
				root.addNode(newNode); //to the root, "parent" node, add the newNode values 

			}
		}
		
		totalInputTokens =+ input.size();
		root.pMinElimination(totalInputTokens, (float)0.15);
	}

	void print() { //print method
		root.print(); //root node being printed from a method in Node class
	}

}
