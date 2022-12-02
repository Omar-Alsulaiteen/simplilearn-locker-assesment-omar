package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	// The main function is used for the command line of the app.
	public static void main(String[] args) {
		// Welcome Message
		System.out.println("Welcom to LockedMe.com\nDeveloper details:");
		System.out.println("Developer's name: Omar Alsulaiteen\nJob Title: LockedMe Developer\n");

		FolderManager directory = new FolderManager("../../main_directory");
		int n = 0;

		/*
		 * Inside the loop the user will either input one of the options 1. to list the
		 * files in ascending order 2. to add, delete, or search for user 3. Exit the
		 * program
		 */
		loop: while (true) {

			System.out.println("Please choose one of the following options\n1. List all the files in the directory");
			System.out.println("2. Add/Delete/Search for a file\n3. Exit the program");
			n = Input.getInteger();

			// The first switch statement is used to handle the user input for the three
			// options
			switch (n) {
			case (1):
				directory.listFiles();
				break;
			case (2):
				loop2: while (true) {

					int k = 0;
					String fileName;
					System.out.println("\nPlease choose one of the following options\n1. Add a file to the directory");
					System.out.println("2. Delete a file \n3. Search for a file\n4. Go back to previous settings");
					k = Input.getInteger();

					// The second switch statement is used to handle the add, delete and the search
					// options are: add, delete and search for a file.
					switch (k) {
					case (1):
						fileName = Input.getString("Enter the file name for the new file: ");
						directory.addFile(fileName);
						break;
					case (2):
						fileName = Input.getString("Enter the file name you want to delete: ");
						directory.deleteFile(fileName);
						break;
					case (3):
						fileName = Input.getString("Enter the file name you want to search for: ");
						directory.searchFile(fileName);
						break;
					case (4):
						System.out.println();
						break loop2;
					default:
						System.out.println("Invalid value, please enter a valid value");
					}
					Input.getString("\nPress Enter to Continue");
					System.out.println();
				}
				break;

			case (3):
				System.out.println("Thank you for using LockedMe. See you next time!!!");
				break loop;
			default:
				System.out.println("Invalid value, please enter a valid value");

			}
			Input.getString("\nPress Enter to Continue");
			System.out.println();
		}

	}

}
