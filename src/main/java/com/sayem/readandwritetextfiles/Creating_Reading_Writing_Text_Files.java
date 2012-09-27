package com.sayem.readandwritetextfiles;

import java.io.*;

public class Creating_Reading_Writing_Text_Files {


	public static void main(String[] args) throws IOException {

	// Creating a text file
	File create = new File("C:\\Users\\Sayem\\Dropbox\\testing\\temp.txt");	
	create.createNewFile();

	// Writing a text file
	FileWriter write = new FileWriter("C:\\Users\\Sayem\\Dropbox\\testing\\temp.txt");
	BufferedWriter out = new BufferedWriter(write);
	out.write("hello we are writing in a file");
	out.newLine();
	out.write("This is a new line");
	out.flush();

	// Reading a text file
	FileReader read = new FileReader("C:\\Users\\Sayem\\Dropbox\\testing\\temp.txt");
	BufferedReader bfr = new BufferedReader(read);	
	String x ="";	

	//System.out.println(bfr.readLine());
	//System.out.println(bfr.readLine());
	//System.out.println(bfr.readLine());
	

	while((x = bfr.readLine()) != null){
		System.out.println(x);

	}	

  }

}

