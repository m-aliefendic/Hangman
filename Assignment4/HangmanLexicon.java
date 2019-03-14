/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import java.util.ArrayList;

import acm.util.*;

public class HangmanLexicon  {
	
/**
 * konstruktor u kojim se na poziva metoda za prebaccivanje datoteke u listu	
 */
		public HangmanLexicon(){
			storeToList ();
		}
		
/**
 *vraca  string na broju koji prima kao parametar
* @param num parametar koji mu se dodjeljuje nakon poziva metode
* @return 
*/
		public String getWord(int num) {
			 
			return stLis.get(num);		
		}
		
/**		
 * 
 */
		private void  storeToList () {
			stLis=new ArrayList<String>();
			try {
				rd = new BufferedReader(new FileReader ("HangmanLexicon.txt"));
				
				while(true) {
					String line=rd.readLine();
					stLis.add(line);
					if(rd.readLine()==null)break;
				}
				
				rd.close();
			} catch (IOException e) {
				throw new ErrorException(e);
			}	
		}
/**
* metoda koja vraca duzinu niza
* @return
*/
		public int listSize() {
		return	stLis.size();
		}
		
		private ArrayList<String> stLis;
		private BufferedReader rd;
}



	

