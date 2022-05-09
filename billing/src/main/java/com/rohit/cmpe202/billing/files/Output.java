package com.rohit.cmpe202.billing.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Output {
	private void create_file(String contents, String fileName) throws FileNotFoundException {
		File directory = new File("OutputFolder");
		if(!directory.exists()) {
			directory.mkdir();
		}
		File file= new File("OutputFolder/" + fileName);
		try(PrintWriter writer=new PrintWriter(file)){
				writer.write(contents);
		}
	}
public void writeFile(String contents) throws FileNotFoundException{
	create_file(contents, "output.csv");
	System.out.println("Finished writing to CSV File");
}

public void writeError(String contents) throws FileNotFoundException{
	create_file(contents, "error.txt");
	System.out.println("Finished writing to Error File");
}

public void writeCards(String contents) throws FileNotFoundException{
	create_file(contents, "Cards.txt");
	System.out.print("Finished Writing to Cards file");
}
}
