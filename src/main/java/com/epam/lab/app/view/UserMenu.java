package com.epam.lab.app.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.controller.Task;
import com.epam.lab.app.controller.Task2;
import com.epam.lab.app.controller.Task3;
import com.epam.lab.app.controller.Task4;
import com.epam.lab.app.controller.Task5;
import com.epam.lab.app.controller.Task6;
import com.epam.lab.app.controller.Task7;
import com.epam.lab.app.view.enums.MenuCommand;

public class UserMenu {
	private static final Logger logger = LogManager.getLogger(UserMenu.class);
	Scanner scanner;

	public UserMenu() {
		scanner = new Scanner(System.in);
	}

	public void createUI() {
		boolean end = false;
		while (!end) {
			printMenu();
			MenuCommand command = MenuCommand.get(scanner.nextInt());
			switch (command) {
			case TASK_2:
				showTask(new Task2());
				break;
			case TASK_3:
				showTask(new Task3());
				break;
			case TASK_4:
				showTask(new Task4());
				break;
			case TASK_5:
				showTask(new Task5());
				break;
			case TASK_6:
				showTask(new Task6());
				break;
			case TASK_7:
				showTask(new Task7());
				break;
			case EXIT:
				end = true;
				break;
			case DEFAULT:
				logger.info("Wrong input");
				break;
			}
		}
	}

	private void printMenu() {
		logger.info("Print:");
		List<MenuCommand> menuCommand = Arrays.asList(MenuCommand.values());
		menuCommand.stream().filter(command -> Objects.nonNull(command.getClassName()))
				.forEach(command -> logger.info(command.getNumber() + " - " + command.getClassName()));
	}

	public void showTask(Task task) {
		task.show();
	}
}
