package com.epam.lab.app.controller;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;

public class Task3 implements Task {
	private static final Logger logger = LogManager.getLogger(Task3.class);

	public void show() {
		Droid droid = new Droid();
		List<Field> fields = Arrays.asList(droid.getClass().getDeclaredFields());
		fields.forEach(field -> {
			Arrays.asList(field.getDeclaredAnnotations()).forEach(annotation -> logger.info(annotation));
		});
	}
}
