package scr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class anagrams {

	public static void main(String[] args) {
		String x = JOptionPane.showInputDialog("Type in a word for anagrams of it.");
		System.out.println((match(x)));

	}

	static public void print(ArrayList<String> x) {
		System.out.println(x);
	}

	static public ArrayList<String> match(String input) {
		//char buf[] = new char [100000];
		String text;
		ArrayList<String> result = new ArrayList<String>();
		ArrayList compilation = new ArrayList();
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader("C:\\Users\\jungw\\Documents\\GitHub\\Level-4-Test\\src\\scr\\words.txt");
			//br.read(buf);
			br = new BufferedReader(fr);		
		

		
		//ArrayList<String> compilation = new ArrayList<String>();
		char[] word1; 
		char[] word2 = input.toLowerCase().toCharArray();
		HashMap<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> lettersInWord2 = new HashMap<Character, Integer>();
		String str;
		
		while ( (str = br.readLine())!= null)  {
			lettersInWord1.clear();
			lettersInWord2.clear();
			
			//System.out.println(str);
			word1 = str.toLowerCase().toCharArray();
			int count = 0;			
			for (char c : word1) {

				if (lettersInWord1.containsKey(c)) {
					count = lettersInWord1.get(c) + 1;
				} else {
					count = 1;
				}
				lettersInWord1.put(c, count);
				//System.out.println(c);
				//System.out.println(count);
			}
			
			count = 0;
			for (char c : word2) {

				if (lettersInWord2.containsKey(c)) {
					count = lettersInWord2.get(c) + 1;
				} else {
					count = 1;
				}
				lettersInWord2.put(c, count);
			}
			boolean equivalent = false;
			
			if ( word1.length == word2.length && lettersInWord1.size() > 0 
					&& lettersInWord2.size()>0 
					&& lettersInWord1.size()==lettersInWord2.size()) {
				int value1, value2;
				boolean isKey1, isKey2;
				for (char c: word1) {
					
					isKey1 = lettersInWord1.containsKey(c);
					isKey2 = lettersInWord2.containsKey(c);
					if (Arrays.equals(word1, word2)) {
						equivalent = false;
						break;
					} else if (isKey1 == false || isKey2 == false) {
						equivalent = false;
						break;
					} else {
						value1 = lettersInWord1.get(c);
						value2 = lettersInWord2.get(c);
						if (isKey1 && isKey2 && value1 == value2) {
							equivalent = true;
						} else {
							equivalent = false;
						}
					}
				}
				
				if (equivalent == true) {
					System.out.println("Hashmap equals");
					System.out.println(lettersInWord1);
					System.out.println(word1);
					System.out.println(lettersInWord2);
					System.out.println(word2);
					result.add(String.valueOf(word1));
					return result;
				}
							
			}
		
		}
	}//catch
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
	}//match
}//class
