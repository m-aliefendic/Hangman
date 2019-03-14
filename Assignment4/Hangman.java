/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	public static void main(String[] args) {
		new Hangman().start(args);
	}
	
	public void init() {
		 canvas = new HangmanCanvas();
		 add(canvas);
		}
	
    public void run() {
    		canvas.reset();
    		println("Welcome to Hagman!");
    		String letter =null;
    		String word="";
    		String dashWord="";
    		HangmanLexicon hangLex =new HangmanLexicon();
    		int pos= rgn.nextInt(0,hangLex.listSize()-1);
    		word=hangLex.getWord(pos);
    		dashWord=wordToDashString(word);
    		
/** slijedi petlaj koja se zavrsava pogadjanjem rijeci ili */	
    while(gameIsOver()) {
    	while (true) {
    		 letter = readLine("Your gasses: ");
    		 if(letter.length()==1)
    			 break;
    		 println("Wrong gasses try again");
    		} 	 
    	dashWord=chackingForGuesses(word,letter,dashWord);
    	 canvas.displayWord(dashWord);
    	if(checkingForAnd(dashWord)) {
    		break;
    		}
    	}
    if(checkingForAnd(dashWord)) {
    	println("That guess is corect");
    	println("You gaussed the word: "+word);
    	println("You win");
    	
    }
    else{
    	println("You're completely hung");
    	println("The word was: "+ word);
    	println("You lose");
    	
    }
  
    
  }
    
   /**
    * provjerava da li u rijeci ima ne pogodjenih slolova
    * @param dashWord rijec koja se pogaja
    * @return vraca tacno ako u rijeci nema critica
    */
	private boolean checkingForAnd(String dashWord) {
		for(int i =0; i<dashWord.length();i++) {
			if('-'==dashWord.charAt(i)) {
				return false;
			}
		}
		 return true;		
	}

/**
 * vraca izgled rijeci prevedenu u crtice 
 */
    private String wordToDashString(String word) {
    	String dashWord="";
		for(int i=0;i<word.length();i++) {	
				dashWord+="-";
			} 
				println("The word looks like this"+dashWord);
				println("You have "+ count +" guesses");
			
	
			return dashWord;	
	}
    
    
/**
 * provjerava da upsano slovo ima u ponudjenoj rijeci 
 * @param word rijec koja se pogadja
 * @param letter upisano slovo na   readln
 * @param dashWord sakrivena rijec
 * @return
 */
    private String chackingForGuesses(String word,String letter,String dashWord) {
    	boolean ima=false;
    	letter=letter.toUpperCase();
		for(int i=0;i<word.length();i++) {	
		
					if(dashWord.charAt(i)==letter.charAt(0)) {
						break;	
					}
					if(letter.charAt(0)==word.charAt(i)) {
								String A=dashWord.substring(0, i);
								String C=dashWord.substring(i+1);
								dashWord="";
								dashWord=A+letter.charAt(0)+C;
								ima=true;			
					}			
			}
		
			if(checkingForAnd(dashWord)) { // provjerava da li je rijec pogodjena, ako jest prekida ispis
				return dashWord;
				}
			
			if(ima) {
					println("That guess is corect");
					println("The word looks like dis"+dashWord);
					println("You have "+ count +" guesses");
				}else {
					count--;
					canvas.noteIncorrectGuess(letter.charAt(0));
					println("There are no "+letter+"'s in the word");
					if(count>1) println("You have "+ count +" guesses");	
						   else println("You have only one guesses");
				}
			
			return dashWord;
    }
    
/**
 * provjrava da li je brojac dosao do nule, a koji 
 * predstavlja broj mogucih promasaja
 * 
 * @return vraca false ako je brojac dosao do nule i prekida wihile loop
 */
	private boolean gameIsOver() {
		if(count!=0)
			return true;
		else	
			return false;
	}

	private HangmanCanvas canvas;
	RandomGenerator rgn =new RandomGenerator();
	int count=8; //broj mogucih pokusaja pogadjanja rijeci
}
