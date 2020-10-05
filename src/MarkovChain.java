
public class MarkovChain<T> {

}

//suggestion for Algorithim 

//for i = orderM -1 to (i < size of the input - 1) do
//{
//			
//	1.	Create the current sequence (eg. curSequence) of size orderM from the input
//	Remember to start the index into the input at 0 (with this algorithm) 
//		a.	add the previous tokens to a container (eg ArrayList). 
//		b.	You may do this in a for-loop or use .subList()
//			i.	https://beginnersbook.com/2013/12/how-to-get-sublist-of-an-arraylist-with-example/
//				
//	2.	Find  curSequence in uniqueAlphabetSequences
//	if curSequence is not found
//	{
//		1. set rowIndex to the size of uniqueAlphabetSequences
//				
//		2. add the curSequence to uniqueAlphabetSequences
//
//		3. add a new row to the transition table the size of the alphabet
//	}
//
//	3.	Find the current next token (tokenIndex)
//	{
//		tokenIndex = the next index of the token in the alphabet (i+1)
//			
//		if tokenIndex is not found in the alphabet
//		{
//			1. tokenIndex = size of the alphabet 
//			2. add the token to the alphabet
//			3. expand transitionTable horizontally
//		}
//	}
//			
//	4.	Update the counts – since we started after the beginning, rowIndex will not be -1
//		a.	Get the row using rowIndex
//		b.	Get the column using tokenIndex
//		c.	Add one to that value retrieved from the transition table
//}
//
//


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