//Programmer: Divya Chakkaram
//Date: Sep 21, 2020
//Description:

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
			
			if (tokenIndex == -1) { //if the tokenIndex equals -1, then do this
				
				tokenIndex = alphabet.size(); //set tokenIndex to the size of alphabet if i is not found in alphabet

				ArrayList<Integer> myRow = new ArrayList(); //creating a new arrayList for a new row in the transition table
				for (int j = 0; j < alphabet.size(); j++) { //iterating through the new row that's the size of alphabet
					myRow.add(0); //add a zero to the end of the row, aka add it to the column			
					}
				
				transitionTable.add(myRow); //add myRow to transitionTable
				
				for (int k = 0; k < transitionTable.size(); k++) { //adding a zero to every specific row in transitionTable
					transitionTable.get(k).add(0); //get each row in transitionTable and then add a 0 to the end of it
				}

			alphabet.add(input.get(i)); //adding the current token to alphabet 

			}
			
			//adding the counts now to the transition table
			if (lastIndex > - 1) { //this indicates that it isn't the first time through because there is a previous token
				ArrayList<Integer> rowCount = transitionTable.get(lastIndex); //getting the correct row from transitionTable with lastIndex
				int myElement = rowCount.get(tokenIndex);
				myElement++; //adding one to the cross referenced value	
				rowCount.set(tokenIndex, myElement);  //getting and setting the correct value in the column from the tokenIndex
			}

			lastIndex = tokenIndex; //setting the current to the previous value for the next time through

		}

					
	}
	

	void printTransitionTable(){
		System.out.println(alphabet);//print out the alphabet arraylist before going through transition table/row arraylists

		 for (int j = 0; j < transitionTable.size(); j++) { //iterating through the transition table
			 ArrayList<Integer> sumrow = transitionTable.get(j); //initializing the arraylist sumrow to trnasitiontable.get(j)
			 float sum = 0; //initializing sum to 0
			  for (int k = 0; k < sumrow.size(); k++) { //iterating through sumrow arraylist values one by one
				  sum += sumrow.get(k); //adding the values to the variable sum
			  }
			  System.out.print(alphabet.get(j)); //printing out alphabet from iterating through transition table values
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
	
	T generate(T init token) {}
                   
        ArrayList<T> generate(T initToken, int numberOfTokensToGenerate){
        //this calls the above.
        }

        ArrayList<T> generate(int numberOfTokensToGenerate){
        }//this calls the above with a random initToken
		//have to use an outside instance of probabilityGenerator in generate
		//can also have user input for initToken in generate - have to account for any user errors tho
		//first thing to do, find the index of the input token in alphabet
		//after finding the index number, use that number to find which row in the transitiontable to generate - the row of counts
		//after getting the row, you have to total the counts 
		//divide each count by the total
		//generate from the probabilities given above
		//instead of recoding the above three steps, just inherit functionality from the probGenerator class
		//so, after going through the transitiontable and arriving at the row that corresponds from the index of alphabet, use
			//that data to go through the probabilitygenerator functionality (generate)
			//that means maybe change your probability generator generatre function to take in the row from the transitiontable
			//in as a parameter.
//		int initToken = 0;
//		return initToken;
	
		}


