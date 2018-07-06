package com.epam.lab.app.view.enums;

public enum MenuCommand {
	EXIT(1, "Exit"), TASK_2(2, "Task2"), TASK_3(3, "Task3"), TASK_4(4, "Task4"), TASK_5(5, "Task5"), TASK_6(6,
			"Task6"), TASK_7(7, "Task7"), DEFAULT();
	private int number;
	private String className;

	private MenuCommand() {

	}

	private MenuCommand(int number, String className) {
		this.number = number;
		this.className = className;
	}

	public static MenuCommand get(int number) {
		MenuCommand currentCommand = DEFAULT;
		for (MenuCommand command : MenuCommand.values()) {
			if (command.number == number) {
				currentCommand = command;
			}
		}
		return currentCommand;
	}

	public int getNumber() {
		return number;
	}

	public String getClassName() {
		return className;
	}

}
