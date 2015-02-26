package com.faculdade.linguagem_programacao.trabalho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface IOAdapter {
	void saveTextInAFile(String text, String path);

	String getTextFromAFile(String path);
}

class NativeCppIO {
	static {
		try {
			 System.load("Z:/C++/Projects/ClassLibrary1/x64/Release/ClassLibrary1.dll");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	// Call the method saveTextFile from our c++ native code (inside of the
	// jnicppio library)
	public native void saveTextFile(String text, String path);

	// Call the method getTextFromFile from our c++ native code (inside of the
	// jnicppio library)
	public native String getTextFromFile(String path);
}

class CppIO implements IOAdapter {
	private NativeCppIO cppIO = new NativeCppIO();

	public void saveTextInAFile(String text, String path) {
		try {
			cppIO.saveTextFile(text, path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getTextFromAFile(String path) {
		return cppIO.getTextFromFile(path);
	}
}

class JavaIO implements IOAdapter {
	public void saveTextInAFile(String text, String path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			writer.write(text);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public String getTextFromAFile(String path) {
		String text = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				text += line + "\n";
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return text;
	}
}

public class TestAdapter {
	public static void main(String[] args) {
		IOAdapter cppIO = new CppIO();
		cppIO.saveTextInAFile("testeIOAdapter c++", "c:/files/file.txt");
		// System.out.println (cppIO.getTextFromAFile("c:/files/file.txt"));

		IOAdapter javaIO = new JavaIO();
		javaIO.saveTextInAFile("testeIOAdapter java", "c:/files/file.txt");
		System.out.println(javaIO.getTextFromAFile("c:files/file.txt"));
	}
}