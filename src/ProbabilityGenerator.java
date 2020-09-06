
import java.util.ArrayList;

//comment everything that you can
//Programmer: Divya Chakkaram
//Date
//Description

public class ProbabilityGenerator <T> {
	
	ArrayList<T> alphabet; //comment here
	ArrayList<Integer> alphabet_counts;//comment here
	
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();
	}
	
	//it is training probability generator with new data
	void train(ArrayList<T> newTokens) 
	{
		for (int i = 0; i < newTokens.indexOf(i) - 1; i++  ) { //trying to go through a for loops through the array
			//list of alphabet to find newTokens in the alphabet
			 
			//int index = newTokens.indexOf(i);
			
			
		}
	
//	 for i = 0 to size of newtokens - 1
//     {
//
//             index = find index of newtokens[i] in alphabet
//
//             if (index is NOT found)
//             {
//                     add newtokens[i] to alphabet container/array
//
//                     add a 0 to your alphabet counts array                                
//
//             }      
//
//              alphabet_counts[index]++ //note – syntax will look different – eg. if using ArrayList
//     }
	
//{
		//code the training function, populate alphabet each time with newTokens	
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
