//Programmer: Divya Chakkaram
//Date: Oct 27, 2020
//Description

import processing.core.*; //importing processing libraries

import java.util.*; //importing java tools

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

//make sure this class name matches your file name, if not fix.
public class MidiWorldMain extends PApplet {
	boolean isPlaying = false; // setting boolean isPlaying to false

	MelodyPlayer player; // play a midi sequence
	MidiFileToNotes midiNotes; // read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("MidiWorldMain"); // change this to match above class & file name

	}

	// setting the window size to 300x300
	public void settings() {
		size(600, 240); // changing the window size to be longer

	}

	// doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);
		background(108, 186, 126); // changing the background color to teal

		// create my generators for pitch and rhythm
		ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
		ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();

		// returns a url
		String filePath = getPath("mid/gardel_por.mid");
		// playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); // creates a new MidiFileToNotes -- reminder -- ALL objects in Java
													// must
		// be created with "new". Note how every object is a pointer or reference.
		// Every. single. one.

		// which line to read in --> this object only reads one line (or ie, voice or
		// ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);

		pitchGenerator.train(midiNotes.getPitchArray());
		rhythmGenerator.train(midiNotes.getRhythmArray());

		player = new MelodyPlayer(this, 100.0f);
		player.setup();
		player.setMelody(pitchGenerator.generate(20));
		player.setRhythm(rhythmGenerator.generate(20));

	}

	public void draw() {

		if (isPlaying) { // if the boolean is true
			player.play(); // play each note in the sequence -- the player will determine whether is time
							// for a note onset
		}

		fill(241, 232, 223); // changing color of text
		textSize(18); // setting the size of the text
		text("Press p to start the melody!", 170, 30);
		text("Press s to stop the melody!", 170, 60);

		fill(63, 34, 7); // changing color of text
		textSize(15);

		text("Press 'a' to run suffix tree output for:  abracadabra", 105, 90);
		text("Press 'b' to run suffix tree output for:  acadaacbda", 105, 120);
		text("Press 'c' to run suffix tree output for:  abcccdaadcdaabcadad", 80, 150);
		text("Press 'd' to run Suffix tree output for: Mary Had a Little Lamb", 78, 180);
		text("Press '7' to run the Unit 1 test, project 3.", 145, 210);// instructions for how Unit 3 test will run

	}

	// this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {

			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	// this function is not currently called. you may call this from setup() if you
	// want to test
	// this just plays the midi file -- all of it via your software synth. You will
	// not use this function in upcoming projects
	// but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	// this starts & restarts the melody.
	public void keyPressed() {
		MidiFileToNotes unitOneTest; // read a midi file
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid"); // do mary had a little lamb

		unitOneTest = new MidiFileToNotes(filePath); // creates a new MidiFileToNotes -- reminder -- ALL objects in Java
														// must
														// be created with "new". Note how every object is a pointer or
														// reference. Every. single. one.

		// which line to read in --> this object only reads one line (or ie, voice or
		// ie, one instrument)'s worth of data from the file
		unitOneTest.setWhichLine(0);

		if (key == 'p') {
			isPlaying = true; // changes the value of the boolean to true
			println("Melody started!"); // if p is pressed, it will print to console that Melody has started

		} else if (key == 's') {
			isPlaying = false; // changes the value of the boolean back to false
			player.reset(); // resetting the playing sequence
			println("Melody stopped!"); // if s is pressed, it will print to console that Melody has stopped

		} else if (key == '7') {
			for (int n = 1; n <= 10; n++) {
				MarkovChain<Integer> mPitchChain = new MarkovChain<Integer>(n);
				MarkovChain<Double> mRhythmChain = new MarkovChain<Double>(n);

				mPitchChain.train(unitOneTest.getPitchArray());
				mRhythmChain.train(unitOneTest.getRhythmArray());

				mPitchChain.printOrdersTransTable();
				mRhythmChain.printOrdersTransTable();
			}

		} else if (key == 'a') { //if you press the key a
			System.out.println("------------------------------");
			System.out.println("abracadabra: PST L=3");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a", "b", "r", "a", "c", "a", "d", "a", "b", "r", "a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.0); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above arrayList testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList

		} else if (key == 'b') {
			System.out.println("------------------------------");
			System.out.println("acadaacbda: PST L=3");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a","c","a","d","a","a","c","b","d","a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.0); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			

		} else if (key == 'c') {
			System.out.println("------------------------------");
			System.out.println("abcccdaadcdaabcadad: PST L=3");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = {"a","b","c","c","c","d","a","a","d","c","d","a","a","b","c","a","d","a","d"}; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3,(float)0.0); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList

		} else if(key == 'd') {			
			String filePath1 = getPath("mid/MaryHadALittleLamb.mid"); // playing Mary Had A Little Lamb midi file
			
			midiNotes = new MidiFileToNotes(filePath1); // creates a new MidiFileToNotes
			midiNotes.setWhichLine(0);
			
			System.out.println("------------------------------");
			System.out.println("Mary Had a Little Lamb: PST L=3");
			System.out.println("------------------------------");
			//print out the PST for the input song file above, and the order length given above
			
			Tree<Integer> testTree = new Tree<Integer>(3, (float)0.0); //create a new Tree of Integers, with order length of 3
			testTree.train(midiNotes.getPitchArray()); //train the Tree of Integers with midinotes.getPitchArray()
			testTree.print(); //print out the PST of order length 3 for the Tree of integers
			
			
		} else if (key == 'e') {
			System.out.println("------------------------------");
			System.out.println("abracadabra: PST L=3, Pmin = 0.1");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a", "b", "r", "a", "c", "a", "d", "a", "b", "r", "a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.1); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above arrayList testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'f') {
			System.out.println("------------------------------");
			System.out.println("acadaacbda: PST L=3, Pmin = 0.1");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a","c","a","d","a","a","c","b","d","a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.1); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'g') {
			System.out.println("------------------------------");
			System.out.println("abcccdaadcdaabcadad: PST L=3, Pmin = 0.1");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = {"a","b","c","c","c","d","a","a","d","c","d","a","a","b","c","a","d","a","d"}; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3,(float)0.1); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'h') {
			String filePath1 = getPath("mid/MaryHadALittleLamb.mid"); // playing Mary Had A Little Lamb midi file
			
			midiNotes = new MidiFileToNotes(filePath1); // creates a new MidiFileToNotes
			midiNotes.setWhichLine(0);
			
			System.out.println("------------------------------");
			System.out.println("Mary Had a Little Lamb: PST L=3, Pmin = 0.1");
			System.out.println("------------------------------");
			//print out the PST for the input song file above, and the order length given above
			
			Tree<Integer> testTree = new Tree<Integer>(3, (float)0.1); //create a new Tree of Integers, with order length of 3
			testTree.train(midiNotes.getPitchArray()); //train the Tree of Integers with midinotes.getPitchArray()
			testTree.print(); //print out the PST of order length 3 for the Tree of integers
		
		} else if (key == 'i') {
			System.out.println("------------------------------");
			System.out.println("abracadabra: PST L=3, Pmin = 0.15");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a", "b", "r", "a", "c", "a", "d", "a", "b", "r", "a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.15); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above arrayList testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'j') {
			System.out.println("------------------------------");
			System.out.println("acadaacbda: PST L=3, Pmin = 0.15");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = { "a","c","a","d","a","a","c","b","d","a" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.15); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'k') {
			System.out.println("------------------------------");
			System.out.println("abcccdaadcdaabcadad: PST L=3, Pmin = 0.15");
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = {"a","b","c","c","c","d","a","a","d","c","d","a","a","b","c","a","d","a","d"}; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3,(float)0.15); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		} else if (key == 'l') {
			String filePath1 = getPath("mid/MaryHadALittleLamb.mid"); // playing Mary Had A Little Lamb midi file
			
			midiNotes = new MidiFileToNotes(filePath1); // creates a new MidiFileToNotes
			midiNotes.setWhichLine(0);
			
			System.out.println("------------------------------");
			System.out.println("Mary Had a Little Lamb: PST L=3, Pmin = 0.15");
			System.out.println("------------------------------");
			//print out the PST for the input song file above, and the order length given above
			
			Tree<Integer> testTree = new Tree<Integer>(3, (float)0.15); //create a new Tree of Integers, with order length of 3
			testTree.train(midiNotes.getPitchArray()); //train the Tree of Integers with midinotes.getPitchArray()
			testTree.print(); //print out the PST of order length 3 for the Tree of integers
			
		} else if (key == 'q') {
			System.out.println("------------------------------");
			//print out the PST for the string above, and the order length given above
			
			String[] myList = {"g", "g", "g", "e", "f", "f", "f", "d", "g", "g", "g", "e", "a", "a", "a", "g", "e", "e", "e", "c", "g", "g", "g", "d", "g", "f", "f", "f", "d", "g", "g", "f", "e", "g", "g", "f", "e", "g", "g", "f", "e", "c", "g" }; //create individual strings
			ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); //set the String list above to an arrayList of Strings, TestList

			Tree<String> testTree = new Tree<String>(3, (float)0.05); //create a new Tree of Strings, with order length of 3
			testTree.train(testList); //train the above Tree with testList
			testTree.print(); //print out the PST of order length 3 for testList ArrayList
			
		}
	}

}
