//Programmer: Divya Chakkaram
//Date: Sep 9, 2020
//Description

import java.util.ArrayList; //importing ArrayList from Java into Eclipse IDE

public class ProbabilityGenerator <T> { //generic class for the Probability Generator
	
	ArrayList<T> alphabet; //take the pitches of unique notes and put into this ArrayList, alphabet
	ArrayList<Integer> alphabet_counts;//this is an ArrayList for keeping track of/counting how many times each unique pitch occurs
	float sum;//variable used to find the total number of newTokens in the projects
	
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>(); //initializing alphabet ArrayList
		alphabet_counts = new ArrayList<Integer>(); //initializing alphabet_counts ArrayList
	}
	
	//it is training probability generator with new data
	void train(ArrayList<T> newTokens) 
	{
		for (int i = 0; i < newTokens.size(); i++  ) { //parsing through each note in newTokens.size(), which is the total ArrayList size
			//list of alphabet to find newTokens in the alphabet
				int index = alphabet.indexOf(newTokens.get(i)); //setting index equal to the index of newTokens.get(i) in the alphabet ArrayList
				if (index == -1) { //if index doesn't exist in alphabet
					alphabet.add(newTokens.get(i));//add newTokens.get(i) to 
					alphabet_counts.add(0);	
					index = alphabet.size()-1;
				} 
				
				alphabet_counts.set(index, alphabet_counts.get(index)+1);									
		}
		
		sum += newTokens.size();
		
		System.out.println(alphabet_counts);
		System.out.println(alphabet);
			
	}
	
	void printProbability(){
		
	}
	
	T generate()
	{
		T newToken = null;
		//do something here - generate one token
		return newToken;
	}
	
	ArrayList<T> generate(int length)
	{
		ArrayList<T> newSequence = new ArrayList<T>();
		for(int i = 0; i < length; i++)
		{
			newSequence.add(generate());
		}
		
		return newSequence;
	}
	
}
