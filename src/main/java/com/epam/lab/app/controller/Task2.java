package com.epam.lab.app.controller;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;
import com.epam.lab.app.model.MyAnnotation;

public class Task2 implements Task {
	private static final Logger logger = LogManager.getLogger(Task2.class);

	public void show() {
		Droid droid = new Droid();
		List<Field> fields = Arrays.asList(droid.getClass().getDeclaredFields());
		fields.forEach(field -> {
			if (Objects.nonNull(field.getDeclaredAnnotation(MyAnnotation.class))) {
				logger.info(field.getName());
			}
		});
	}
}
