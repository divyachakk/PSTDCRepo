//Programmer: Divya Chakkaram
//Date: Sep 14, 2020
//Description

//this website helped me understand how to cleanly sum previous values in an arraylist
//https://stackoverflow.com/questions/40901009/how-to-sum-current-index-with-all-previous-numbers-inside-an-arraylist

//this website helped me figure out how to normalize my probdist values in alphabet_counts and create the probs arraylist
//https://stackoverflow.com/questions/60536462/is-it-possible-divide-an-arraylist-by-a-double-and-create-a-new-list

import java.util.ArrayList; //importing ArrayList from Java into Eclipse IDE
import java.util.Collections;

public class ProbabilityGenerator <T> { //generic class for the Probability Generator
	
	ArrayList<T> alphabet; //take the pitches of unique notes and put into this ArrayList, alphabet
	ArrayList<Integer> alphabet_counts;//this is an ArrayList for keeping track of/counting how many times each unique pitch occurs
	float sum;//variable used to find the total number of newTokens in the projects
	ArrayList<Float> probs;
	ArrayList<Float> sumProbs;
	float filler;
	
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>(); //initializing alphabet ArrayList
		alphabet_counts = new ArrayList<Integer>(); //initializing alphabet_counts ArrayList
		probs = new ArrayList<Float>();
		sumProbs = new ArrayList<Float>();
		float filler = 0;
	}
	
	//it is training probability generator with new data
	void train(ArrayList<T> newTokens) 
	{
		for (int i = 0; i < newTokens.size(); i++  ) { //parsing through each note in newTokens.size(), which is the total ArrayList size
			//list of alphabet to find newTokens in the alphabet
				int index = alphabet.indexOf(newTokens.get(i)); //setting index equal to the index of newTokens.get(i) in the alphabet ArrayList
				if (index == -1) { //if index doesn't exist in alphabet
					alphabet.add(newTokens.get(i));//add newTokens.get(i) to alphabet array
					alphabet_counts.add(0);//add zero to the alphabet counts array if particular newTokens(i) doesn's exist	
					index = alphabet.size()-1;//put index value at the end of alphabet array
				} 
				
				alphabet_counts.set(index, alphabet_counts.get(index)+1);//move along alphabet_counts array while adding index value								
		}
		
		sum += newTokens.size(); //every time new value is added to the ArrayList, add it to the sum variable
			
	}
	
	void printProbability(){
		for (int i = 0; i < alphabet.size(); i++) {
			System.out.println("Token: "+ alphabet.get(i)); //this prints out the token number
		}
		
		for (int i = 0; i < alphabet_counts.size(); i++) {
			System.out.println("Probability: "+ alphabet_counts.get(i)/sum); //this normalizes and prints out the prob distr values of the unique tokens
		}
	}
	
	T generate() {
		for (float ac: alphabet_counts) { //this adds the values of normalized probability distribution to an ArrayList - probs
			probs.add(ac/sum);
		}
		
		for(int i = 0; i < probs.size()-1; i++) { //this adds the values of probs, with current and previous value summed together, to the ArrayList sumProbs
			filler += probs.get(i);
			sumProbs.add(filler);	
		}
		
		
		T newToken = null;
		float randIndex = (float)Math.random(); //this randomly picks a number between 0.0 and 1.0, excluding 1.0
	
		boolean found = false; //sets found to false
		int i = 0; //initializes index i to 0
		
		while(!found) { //found doesn't equal true
			found = randIndex <= sumProbs.get(i);
			//System.out.println(found);
			i++; //adds one to the index i everytime you go through the loop
		}
		
		newToken = alphabet.get(i-1); //newToken, after going through the while loop, then returns a value from the alphabet ArrayList
		
		return newToken;
	}
	
	ArrayList<T> generate(int length) {
		ArrayList<T> newSequence = new ArrayList<T>();
		for(int i = 0; i < length; i++) {
			newSequence.add(generate());
		}
		
		return newSequence;
	}
	
}
