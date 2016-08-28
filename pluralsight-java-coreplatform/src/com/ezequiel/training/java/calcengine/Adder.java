package com.ezequiel.training.java.calcengine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ezequiel on 04/08/16.
 */
public class Adder {

	private String inFile, outFile;
	
	public Adder(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}
	
	public void doAdd() throws IOException{
		int total = 0;
		String line = null;
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
			while((line = reader.readLine()) != null){
				total += Integer.parseInt(line);
			}
		}

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
			writer.write("Total: " + total);
		}
	}
	
	
	public static void main(String[] args) {
		String inFiles[] = {"./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt", "./file6.txt"};
		String outFiles[] = {"./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt", "./file5.out.txt", "./file6.out.txt"};
		
		for (int i = 0; i < inFiles.length; i++) {
			try {
				Adder adder = new Adder(inFiles[i], outFiles[i]);
				adder.doAdd();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
