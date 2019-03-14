/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {


/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		scaffold= new GLine(getWidth()/2-BEAM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60,getWidth()/2-BEAM_LENGTH,getHeight()-60);
		add(scaffold);
		beam = new GLine (getWidth()/2-BEAM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60,getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60);
		add(beam);
		rope= new GLine(getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60,getWidth()/2,getHeight()-SCAFFOLD_HEIGHT+ROPE_LENGTH-60);
		add(rope);
		view = new GLabel ("");
	
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
	view.setFont("Times New Roman-15");
	view.setLabel(word);
	add(view,getWidth()/4,getHeight()-60);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		count++;
	switch(count) {
		case 1:
			head = new GOval((getWidth()-HEAD_RADIUS)/2,getHeight()-SCAFFOLD_HEIGHT+ROPE_LENGTH-60,HEAD_RADIUS,HEAD_RADIUS);
			add(head);
			break;
		case 2:
			body = new GLine(getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2,getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH);
			add(body);
			break;
		case 3:
			armRight = new GLine(getWidth()/2-UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD,getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD);
			add(armRight);
			lowArmRight = new GLine(getWidth()/2-UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD,getWidth()/2-UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(lowArmRight);
			break;
		case 4:
			armLeft = new GLine(getWidth()/2+UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD,getWidth()/2,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD);
			add(armLeft);
			lowArmLeft = new GLine(getWidth()/2+UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD,getWidth()/2+UPPER_ARM_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(lowArmLeft);
			break;
		case 5:
			hipRight= new GLine(getWidth()/2,getHeight()-SCAFFOLD_HEIGHT+HEAD_RADIUS-60+(HEAD_RADIUS+2)/2+BODY_LENGTH,getWidth()/2-HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH);
			add(hipRight);
			legRight= new GLine(getWidth()/2-HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT+HEAD_RADIUS-60+(HEAD_RADIUS+2)/2+BODY_LENGTH,getWidth()/2-HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH);
			add(legRight);
			break;
		case 6:
			footRight = new GLine(getWidth()/2-HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH,getWidth()/2-HIP_WIDTH-FOOT_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH);
			add(footRight);
			break;
		case 7:
			hipLeft= new GLine(getWidth()/2,getHeight()-SCAFFOLD_HEIGHT+HEAD_RADIUS-60+(HEAD_RADIUS+2)/2+BODY_LENGTH,getWidth()/2+HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH);
			add(hipLeft);
			legLeft= new GLine(getWidth()/2+HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT+HEAD_RADIUS-60+(HEAD_RADIUS+2)/2+BODY_LENGTH,getWidth()/2+HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH);
			add(legLeft);
			break;
		case 8:
			footLeft = new GLine(getWidth()/2+HIP_WIDTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH,getWidth()/2+HIP_WIDTH+FOOT_LENGTH,getHeight()-SCAFFOLD_HEIGHT-60+HEAD_RADIUS+(HEAD_RADIUS+2)/2+BODY_LENGTH+LEG_LENGTH);
			add(footLeft);
			break;
		
		default:
			defaul =new GLabel ("Doslo je do greske");
			add(defaul,getWidth(),getHeight());
		
	}

	wrLett+=letter;
	wrongLetter = new GLabel(wrLett);
	add(wrongLetter,getWidth()/4,getHeight()-40);
	
	
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	/**
	 * private instance
	 */
	private int count=0;
	private GLine scaffold;
	private GLine body;
	private GLine beam;
	private GLine rope;
	private GLine hipRight;
	private GLine hipLeft;
	private GLine legLeft;
	private GLine legRight;
	private GLine footRight;
	private GLine footLeft;
	private GLine armLeft;
	private GLine armRight;
	private GLine lowArmLeft;
	private GLine lowArmRight;
	private GOval head;
	private GLabel defaul;
	private GLabel view;
	private GLabel wrongLetter;
	private String wrLett="";

	
}
