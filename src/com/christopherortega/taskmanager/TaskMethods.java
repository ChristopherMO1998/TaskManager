package com.christopherortega.taskmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskMethods {
	static Scanner userInput;
	static ArrayList<TaskProperties> tasks;
	FileWriter writer;

	public static void displayMenu() {
		System.out.println("--Task Master--");
		System.out.println("1. Add to the list");
		System.out.println("2. Remove from the list");
		System.out.println("3. Mark as complete");
		System.out.println("4. List the list");
		System.out.println("0. End of line----");
		System.out.println("Your choice: ");
	}

	public static int readUserInput() {
		int result = userInput.nextInt();
		userInput.nextLine();
		return result;
	}

	public static void addTask(String name) {
		tasks.add(new TaskProperties(name));
	}

	public static void removeTask(int id) {
		tasks.remove(id - 1);
	}

	// complete task
	public static void completeTask(int id) {
		tasks.get(id - 1).setComplete(true);
	}

	// list tasks
	public static void listTasks() {
		System.out.println("============");
		System.out.println("--toDo list--");
		System.out.println("============");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(i + 1 + ". " + tasks.get(i).toString());
		}
		System.out.println("============");
	}

	public static void clearScreen() {
		System.out.println(System.lineSeparator().repeat(16));
	}

	public static void readTextFile() throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				tasks.add(new TaskProperties(sCurrentLine));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
