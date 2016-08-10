package com.ezequiel.training.codingtests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GapsInBinary {

	public static void main(String[] args) {
		int array[] = {-1000, -500, -100, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 100, 101, 1000, 2000, 3000, 8888, 9999, 90009};
		
		for (int i : array) {
			theMethod(i);
		}
	}
	
	
	public static void theMethod(int N) {
		
		System.out.println("N: " + N);
		
		final String binaryString = Integer.toBinaryString(N);
		
		System.out.println("BinaryString: " + binaryString);
		
		char[] charArray = binaryString.toCharArray();
		
		List<String> list = new ArrayList<>();
		
		String theString = null;
		
		int i = 0;
		List<Word> wordList = new ArrayList<>();
		Word theWord = null;
		while(i < charArray.length){
			char theChar = charArray[i++];
//			i++;
			if(theWord == null){
				theWord = new Word(theChar);
			} else {
				theWord.add(theChar);
			}
			if(theWord.finished){
				if(theWord.size > 0){
					wordList.add(theWord);
				}
				theWord = null;
				i--;
			}
		}
		Collections.sort(wordList);
		System.out.println(Arrays.toString(wordList.toArray()));
		System.out.println();
	}
	
	private static class Word implements Comparable<Word>{
		boolean started = false;
		boolean finished = false;
		int size = 0;
		public Word(char c) {
			if(c == '1'){
				started = true;
			}
		}
		public void add(char c) {
			if(c == '0'){
				size++;
			} else {
				finished = true;
			}
		}
		@Override
		public int compareTo(Word o) {
			return Integer.compare(size, o.size);
		}
		@Override
		public String toString() {
			return String.valueOf(size);
		}
	}
}
