package com.christopherortega.taskmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager extends TaskMethods {

	public static void main(String[] args) throws Exception {

		// task manager
		tasks = new ArrayList<TaskProperties>();
		userInput = new Scanner(System.in);
		// display menu
		boolean running = true;
		readTextFile();
		do {
			displayMenu();
			int menuChoice = readUserInput();
			switch (menuChoice) {
			case 1:
				System.out.println("============");
				System.out.print("What do you want to add: ");
				// add task method
				String taskName = userInput.nextLine();
				addTask(taskName);
				break;
			case 2:
				if (tasks.size() > 0) {
//					clearScreen();
					System.out.println("============");
					System.out.print("Task to be removed: ");
					listTasks();
					int removeId = readUserInput();
					// remove method
					if (removeId <= tasks.size() + 1) {
						removeTask(removeId);
					} else {
						System.out.println("Invalid selection");
					}
				}
				break;
			case 3:
				if (tasks.size() > 0) {
					System.out.println("============");
					System.out.print("Item to complete: ");
					listTasks();
					int completeId = readUserInput();
					if (completeId <= tasks.size() + 1) {
						completeTask(completeId);
					} else {
						System.out.println("Invalid selection");
					}
				}
				break;
			case 4:
				// list method
				listTasks();
				break;
			case 0:
				break;
			default:
				System.out.println("UNKNOWN");
			}
			FileWriter writer = new FileWriter("tasks.txt");
			for (TaskProperties str : tasks) {
				try {
					writer.write(str + System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			writer.close();

		} while (running);

	}
}
