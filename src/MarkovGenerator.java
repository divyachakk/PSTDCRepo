import java.util.ArrayList;
import java.util.Arrays;

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {

	
	ArrayList<ArrayList<Integer>> transitionTable; 	//declaring an transitionTable ArrayList
	ArrayList<T> alphabet; //declared an empty arraylist for alphabet
	
	MarkovGenerator(){
		//to create the ArrayList
		transitionTable = new ArrayList();
		alphabet = new ArrayList<T>();

	}
	
	//use a for loop to interate through the input string with i
	//have to expand transition table to expand the alphabet
	//transitionTable.get(lastIndex) <- this will give you your row array to update the counts
	//row.get(tokenIndex) <- then add one to that lastIndex value??? minute 6.30
	//tokenIndex is always the size of the alphabet everytime you parse through the input string
	//when you update your counts, always look at what the lastIndex was
	
	void train(ArrayList<T> input) { 	//training is the process of filling the empty transition table
		
		int lastIndex = -1;

		for (int i = 0; i < input.size(); i++) { //for loop going one by one through the input ArrayList
			int tokenIndex = 0; // setting tokenIndex to 0 before changing values
			
			if (!alphabet.contains(i)) { //if alphabet doesn't contain i in the for loop
				
			tokenIndex = alphabet.size(); //set tokenIndex to the size of alphabet if i is not found in alphabet
			
			for (int j = 0; j < transitionTable.size(); j++) {
//				transitionTable= add_element(0);
//				transitionTable.add(0);
				
				ArrayList row = transitionTable.get(j);
				for (int k = 0; k < row.size(); k++) {
					ArrayList<Integer> myRow = new ArrayList(); //to add a row if i is not found in alphabet
					transitionTable.add(myRow); //adding the new row to the transitionTable
					
					}
				
				}
			
			}
			

			
			
		}
			
			
	}
		
}

