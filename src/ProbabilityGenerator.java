


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
