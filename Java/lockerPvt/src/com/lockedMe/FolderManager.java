package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/* FolderManager class is used to handle the directory
 * It includes
 * private String root: the path for the directory that contains the files.
 * private ArrayList<File> files: the files in the root directory
 * public void listFiles: print the files in the directory
 * public void addFile: Add a new file to the directory
 * public void deleteFile: Delete a file from the directory
 * public void searchFile: search for a file in the directory
 */
public class FolderManager {

	private String root;
	private ArrayList<File> files;

	public FolderManager(String root) {
		this.root = root;

		File directory = new File(this.root);

		files = new ArrayList<File>(Arrays.asList(directory.listFiles()));
	}

	public String getRoot() {
		return root;
	}

	public void listFiles() {
		System.out.println("\nCurrent files in the directory:");
		files.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

	/*
	 * addFile adds a file to the current directory Parameters String fname: the
	 * String fname: file name entered by the user
	 */

	public void addFile(String fname) {
		File newFile = new File(getRoot() + "/" + fname);
		try {
			if (newFile.createNewFile()) {
				System.out.println(newFile.getName() + " Created successfully");
				if (!files.add(newFile))
					System.out.println("Error adding" + newFile.getName() + " file");

			} else {
				System.out.println("A file with the same name already exists");
			}
		} catch (IOException e) {
			System.out.println("IOException\n" + e.getMessage());
		}

	}

	/*
	 * deleteFile deletes a file from the directory Parameters
	 * Parameters
	 * String fname: The file name from the user
	 */
	public void deleteFile(String fname) {
		File file = new File(this.getRoot() + "/" + fname);
		if (file.delete()) {
			System.out.println("File deleted successfully");
			if (!files.remove(file))
				System.out.println("Error removing file from the list\n");

		} else {
			System.out.println("File not found!!!");
		}

	}

	/* searchFile searches the file and checks if it exists or not
	 * String fname: The name of the file entered by the user.
	 */
	public void searchFile(String fname) {
		File file = new File(getRoot() + '/' + fname);
		if (files.contains(file)) {
			System.out.println(fname + " exists");
		} else {
			System.out.println(fname + " doesn't exist");
		}
	}
}

/*
 * Class Input has two methods that takes input from the user and handles that input
 * Methods:
 * public static int getInteger: takes an integer from the user and handles it.
 * public String getString: takes a String from the user and handles it.
 */
class Input {
	public static int getInteger() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter a number: ");
		int n = -1;
		try {
			n = input.nextInt();
			input.nextLine();
		} catch (InputMismatchException e) {
			return -1;
		}
		return n;
	}

	public static String getString(String task) {
		Scanner input = new Scanner(System.in);
		System.out.print(task);
		String str;
		try {
			str = input.nextLine();
		} catch (InputMismatchException e) {
			return null;
		}
		return str;
	}
}