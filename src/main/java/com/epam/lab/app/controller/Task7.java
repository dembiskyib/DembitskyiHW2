package com.epam.lab.app.controller;

import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;

public class Task7 implements Task {
	private static final Logger logger = LogManager.getLogger(Task7.class);

	public void show() {
		showClassInformation(new Droid());
	}

	private <T> void showClassInformation(T object) {
		Class<?> objectClass = object.getClass();
		logger.info(objectClass.getSimpleName() + " extends " + objectClass.getSuperclass().getSimpleName()
				+ "\n\nFields:");
		Arrays.asList(objectClass.getDeclaredFields())
				.forEach(field -> logger.info(field.getType().getSimpleName() + " " + field.getName()));
		logger.info("\nConstructors: ");
		Arrays.asList(objectClass.getConstructors())
				.forEach(constructor -> logger.info(constructor.getDeclaringClass().getSimpleName() + "("
						+ getParameters(constructor.getParameters()) + ")"));
		logger.info("\nMethods: ");
		Arrays.asList(objectClass.getDeclaredMethods())
				.forEach(method -> logger.info(method.getReturnType().getSimpleName() + " " + method.getName() + "("
						+ getParameters(method.getParameters()) + ")"));

	}

	private String getParameters(Parameter[] parameters) {
		String parametersString = new String();
		for (int i = 0; i < parameters.length; i++) {
			parametersString = parametersString + parameters[i].getType().getSimpleName() + " ";
		}
		parametersString = parametersString.trim().replace(" ", ", ");
		return parametersString;
	}
}
