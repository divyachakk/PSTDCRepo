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
					alphabet.add(newTokens.get(i));//add newTokens.get(i) to alphabet array
					alphabet_counts.add(0);//add zero to the alphabet counts array if particular newTokens(i) doesn's exist	
					index = alphabet.size()-1;//put index value at the end of alphabet array
				} 
				
				alphabet_counts.set(index, alphabet_counts.get(index)+1);//move along alphabet_counts array while adding index value								
		}
		
		sum += newTokens.size(); //every time new value is added to the ArrayList, add it to the sum variable
		
		System.out.println(alphabet_counts);//print out what is happening in alphabet_counts
		System.out.println(alphabet);//print out what is happening in alphabet
			
	}
	
//	void printProbability(){
//		
//	}
	
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
