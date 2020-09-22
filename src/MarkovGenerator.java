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
			int tokenIndex = alphabet.indexOf(input.get(i)); // setting tokenIndex before changing values
			
			if (!alphabet.contains(i)) { //if alphabet doesn't contain i in the for loop
				
				tokenIndex = alphabet.size(); //set tokenIndex to the size of alphabet if i is not found in alphabet

				ArrayList<Integer> myRow = new ArrayList(); //creating a new arrayList for a new row in the transition table
				for (int j = 0; j < alphabet.size(); j++) { //iterating through the new row that's the size of alphabet
					myRow.add(0); //add a zero to the end of the row, aka add it to the column			
					}
			
			alphabet.add(input.get(i)); //adding the current token to alphabet 

			}
			
			//adding the counts now to the transition table
			if (lastIndex > -1) { //this indicates that it isn't the first time through because there is a previous token
				ArrayList<Integer> rowCount = transitionTable.get(lastIndex); //getting the correct row from transitionTable with lastIndex
				Integer myElement = rowCount.get(tokenIndex); //getting the correct value in the column from the tokenIndex
				myElement++; //adding one to the cross referenced value									
			}
			
			lastIndex = tokenIndex; //setting the current to the previous value for the next time through
		}
					
	}
	
//	void printProbability(){
//		for (int i = 0; i < alphabet.size(); i++) {
//			System.out.println("Token: "+ alphabet.get(i) + " | Probability: "+ alphabet_counts.get(i)/sum); //this prints out the token number
//		}
//	}
}

