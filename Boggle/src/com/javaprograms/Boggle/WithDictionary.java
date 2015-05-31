package com.javaprograms.Boggle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This class uses a reader to read a dictionary file
// It adds words to its' repository when running the solver, to use as its check for
// whether or not a certain combination is a word

public abstract class WithDictionary {
	

	protected List<String> readDictionary(){
		String word;
		List<String> words = new ArrayList<String>();
		
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader("dict.txt"));
			
			while ((word = bufferedReader.readLine()) != null) {
				words.add(word);
			}
			
			bufferedReader.close();
		
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return words;
	}

}
