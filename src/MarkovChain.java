//Programmer: Divya Chakkaram
//Date: Oct 13, 2020
//Description:

import java.util.ArrayList;

public class MarkovChain<T> extends MarkovGenerator<T> {
	ArrayList<T> curSequence = new ArrayList<T>();
	ArrayList<ArrayList<T>> uniqueAlphabetSequences = new ArrayList();
	int orderM;

	MarkovChain(int order) {
		orderM = order;
	}

	void train(ArrayList<T> input) {

		for (int i = orderM - 1; i < input.size() - 1; i++) {

			ArrayList<T> curSequence = new ArrayList<T>();
			for (int q = i - (orderM - 1); q <= i; q++) {
				curSequence.add(input.get(q));
			}

			int rowIndex = uniqueAlphabetSequences.indexOf(curSequence);
			if (rowIndex == -1) {
				rowIndex = uniqueAlphabetSequences.size();
				uniqueAlphabetSequences.add(curSequence);


				ArrayList<Integer> newRow = new ArrayList();
				for (int j = 0; j < alphabet.size(); j++) {
					newRow.add(0);

				}
				transitionTable.add(newRow);

			}

			int tokenIndex = alphabet.indexOf(input.get(i + 1)); // im technically not getting the next token in the
																// alphabet (i+1) tho
			if (tokenIndex == -1) {
				tokenIndex = alphabet.size();
				alphabet.add(input.get(i + 1)); 
				for (int k = 0; k < transitionTable.size(); k++) {
					transitionTable.get(k).add(0);
				}

			}

			ArrayList<Integer> Row1 = transitionTable.get(rowIndex); // what is rowIndex - this may be why the row is
																		// empty
			int myColumn = Row1.get(tokenIndex);
			myColumn++;
			Row1.set(tokenIndex, myColumn);

		}

		//System.out.println(transitionTable);
		// System.out.println(uniqueAlphabetSequences);

	}
	
	void printOrdersTransTable(){
		System.out.println(alphabet);//print out the alphabet arraylist before going through transition table/row arraylists

		 for (int j = 0; j < transitionTable.size(); j++) { //iterating through the transition table
			 ArrayList<Integer> sumrow = transitionTable.get(j); //initializing the arraylist sumrow to trnasitiontable.get(j)
			 float sum = 0; //initializing sum to 0
			  for (int k = 0; k < sumrow.size(); k++) { //iterating through sumrow arraylist values one by one
				  sum += sumrow.get(k); //adding the values to the variable sum
			  }
			  System.out.print(uniqueAlphabetSequences.get(j)); //printing out alphabet from iterating through transition table values
				  for (int o = 0; o <sumrow.size(); o++) { //iterating through sumrow values again
					  if (sum == 0) { //if the value of sum = 0, print out "0.0" for the space
						  System.out.print(" 0.0 ");
					  }
					  else { //if sum doesn't equal 0, print out the values in the sumrow one by one divided by the value of sum
					  System.out.print(" " + sumrow.get(o)/sum + " ");
					  }					  
				  }
				  
				  System.out.println(); //println a space
			  }
		}

}


//use this to think about how to find an ArrayList in an ArrayList<ArrayList<T>>

//ArrayList<ArrayList<T>> allTheSequences = new ArrayList();
//
////just adding random data
//
//for(int i=0; i<2; i++)
//allTheSequences.add(new ArrayList());
//
//
//
////adding more random data to 1st row
//
//allTheSequences.get(0).add(1);
//allTheSequences.get(0).add(1);
//
//
//
////adding more random data to 2nd row
//
//allTheSequences.get(1).add(2);
//allTheSequences.get(1).add(3);
//
//
//
////data to test
//ArrayList<T> testArray = new ArrayList();
//testArray.add(2);
//testArray.add(3);
//
//int index = allTheSequences.indexOf(testArray);
//
////index is 1 because it found a match. Woo!
////So, you do not have to code anything fancy or even differently than if you were checking a token.
////ArrayList works as advertised for ANY object (caveat: that has equals() overridden correctly).
//