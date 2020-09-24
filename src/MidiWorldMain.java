//Programmer: Divya Chakkaram
//Date: Sep 21, 2020
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

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("MidiWorldMain"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(600,300); //changing the window size to be longer

	}

	//doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);
		background(105,207,190); //changing the background color to teal
		
		//create my generators for pitch and rhythm
		ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
		ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();


		// returns a url
		String filePath = getPath("mid/gardel_por.mid");
		// playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
		//be created with "new". Note how every object is a pointer or reference. Every. single. one.


		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);
		
		pitchGenerator.train(midiNotes.getPitchArray());
		rhythmGenerator.train(midiNotes.getRhythmArray());
		

		player = new MelodyPlayer(this, 100.0f);
		player.setup();
		player.setMelody(pitchGenerator.generate(20));
		player.setRhythm(rhythmGenerator.generate(20));
	}

	public void draw() {
		//boolean for playing 'is playing'
//		boolean isPlaying = false;
//		player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset
		fill(13,19,41); //changing color of text
		textSize(20); //setting the size of the text
		text("Press any key to start the melody!",130,50);
		text("Press '1' to run the Unit 1 test, project 1.", 105, 100);//instructions for how Unit 1 test will run
		text("Press '2' to run the Unit 2 test, project 1.", 105, 150);//instructions for how Unit 2 test will run
		text("Press '3' to run the Unit 3 test, project 1.", 105, 200);//instructions for how Unit 3 test will run
		text("Press '4' to run the Unit 1 test, project 2.", 105, 250);//instructions for how Unit 1 test will run


	}

	//this finds the absolute path of a file
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

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		MidiFileToNotes unitOneTest; //read a midi file
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid"); //do mary had a little lamb

		unitOneTest = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.

		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		unitOneTest.setWhichLine(0);
		
		
		if (key == ' ') {
//			player.play();
			player.reset(); //resetting the playing sequence
			println("Melody started!"); //if any key is pressed, it will print to console that Melody has started
		}
		
		else if (key =='1') { //pressing the key "1" for Unit test 1

			//create my generators for pitch and rhythm
			ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();

			// returns a url
			String filePath1 = getPath("mid/MaryHadALittleLamb.mid"); //playing Mary Had A Little Lamb midi file
			// playMidiFile(filePath);

			midiNotes = new MidiFileToNotes(filePath1); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
			//be created with "new". Note how every object is a pointer or reference. Every. single. one.

			// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
			midiNotes.setWhichLine(0);
			
			pitchGenerator.train(midiNotes.getPitchArray());
			rhythmGenerator.train(midiNotes.getRhythmArray());

			player = new MelodyPlayer(this, 100.0f);
			player.setup();
			player.setMelody(pitchGenerator.generate(20));
			player.setRhythm(rhythmGenerator.generate(20));
			
			pitchGenerator.printProbability(); //prints the probability distribution values and tokens for the pitches
			rhythmGenerator.printProbability();//prints the probability distribution values and tokens for the rhythms

		} 
		else if (key == '2') { //pressing the key "2" for Unit test 2
			//create my generators for pitch and rhythm
			ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();
			
			pitchGenerator.train(midiNotes.getPitchArray()); //trains the pitchGenerator
			rhythmGenerator.train(midiNotes.getRhythmArray()); //trains the rhythmGenerator
		
			System.out.println(pitchGenerator.generate(20)); //prints out the notes for the pitches from the generated melody
			System.out.println(rhythmGenerator.generate(20)); //prints out the rhythms from the generated melody
			
		}
		else if (key == '3') { //press the key '3' for the Unit Test 3
			ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();
			
			pitchGenerator.train(midiNotes.getPitchArray());
			rhythmGenerator.train(midiNotes.getRhythmArray());
			
			ProbabilityGenerator<Integer> probDistGenPitch = new ProbabilityGenerator<Integer>(); //declares and initializes another probability Generator for the new pitch value probabilities
			ProbabilityGenerator<Double> probDistGenRhythm = new ProbabilityGenerator<Double>(); //declares and initializes another probability Generator for the new rhythm value probabilities
			
			
            for (int i = 1; i <= 10000; i++) { //for loop going through the 10000 melodies
            	ArrayList <Integer> newSongPitch = pitchGenerator.generate(20); //declaring and initializing an ArrayList of Integers, newSongPitch, for the generated notes' pitch probability Generator
            	ArrayList<Double> newSongRhythm = rhythmGenerator.generate(20); //declaring and initializing an ArrayList of Doubles, newSongRhyth, for the generated notes' rhythm probability Generator
            	probDistGenPitch.train(newSongPitch);	//training the pitch probability generator with the ArrayList of generated pitches
            	probDistGenRhythm.train(newSongRhythm); //training the rhythm probability generator with the ArrayList of generated rhythms
            }    
            
            probDistGenPitch.printProbability(); //printing out the pitch probability distribution of the 10,000 melodies 
            probDistGenRhythm.printProbability(); //printing out the rhythm probability distribution of 10,000 melodies
            
		}
		else if (key == '4') {
			MarkovGenerator<Integer> mpitchGenerator = new MarkovGenerator<Integer>();
			MarkovGenerator<Double> mrhythmGenerator = new MarkovGenerator<Double>();
			
			// returns a url
			String filePath1 = getPath("mid/MaryHadALittleLamb.mid"); //playing Mary Had A Little Lamb midi file
			// playMidiFile(filePath);

			midiNotes = new MidiFileToNotes(filePath1); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
			//be created with "new". Note how every object is a pointer or reference. Every. single. one.

			// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
			midiNotes.setWhichLine(0);
			
			mpitchGenerator.train(midiNotes.getPitchArray());
			mrhythmGenerator.train(midiNotes.getRhythmArray());

//			player = new MelodyPlayer(this, 100.0f);
//			player.setup();
//			player.setMelody(mpitchGenerator.generate(20));
//			player.setRhythm(mrhythmGenerator.generate(20));
			
			mpitchGenerator.printTransitionTable(); //prints the transitionTable for pitches
			mrhythmGenerator.printTransitionTable();//prints the transitionTable for rhythm		
			
			}
		
		}
	}
