//Programmer: Divya Chakkaram
//Date: Oct 13, 2020
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
	boolean isPlaying = false; //setting boolean isPlaying to false

	MelodyPlayer player; // play a midi sequence
	MidiFileToNotes midiNotes; // read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("MidiWorldMain"); // change this to match above class & file name

	}

	// setting the window size to 300x300
	public void settings() {
		size(600, 335); // changing the window size to be longer

	}

	// doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);
		background(105, 207, 190); // changing the background color to teal

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
		
		String[] myList = {"a", "b", "a", "c","a", "d"};
		ArrayList<String> testList = new ArrayList(Arrays.asList(myList)); 
		
		String[] suffixList = {"c","a", "d"};
		ArrayList<String> testSuffix = new ArrayList(Arrays.asList(suffixList));
		
		Tree<String> testTree = new Tree<String>(3);
		testTree.train(testList);
		
		Node test = new Node(testList);
		Node suffix = new Node(testSuffix);
		test.amIASuffix(suffix);
		
	}

	public void draw() {
	
		

		if (isPlaying) { //if the boolean is true
			player.play(); // play each note in the sequence -- the player will determine whether is time
							// for a note onset
		}

		fill(255, 255, 255); // changing color of text
		textSize(18); // setting the size of the text
		text("Press p to start the melody!", 170, 30);
		text("Press s to stop the melody!", 170, 60);
		
		fill(13, 19, 41); // changing color of text
		textSize(15);

		text("Press '7' to run the Unit 1 test, project 3.", 145, 310);// instructions for how Unit 3 test will run

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
			isPlaying = true; //changes the value of the boolean to true
			println("Melody started!"); // if p is pressed, it will print to console that Melody has started
			
		} else if (key == 's') {
			isPlaying = false; //changes the value of the boolean back to false
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

		}

	}

}
