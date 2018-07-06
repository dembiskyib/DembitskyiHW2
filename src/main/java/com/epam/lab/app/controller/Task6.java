package com.epam.lab.app.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;

public class Task6 implements Task {
	private static final Logger logger = LogManager.getLogger(Task6.class);

	public void show() {
		try {
			Class<?> droidClass = Class.forName("com.epam.lab.app.model.Droid");
			Droid droid = new Droid();
			Field nameField = droidClass.getDeclaredField("name");
			nameField.setAccessible(true);
			Class<?> nameFieldClass = nameField.getType();
			if (nameFieldClass.equals(String.class)) {
				nameField.set(droid, "NewName");
				showName(droid);
			} else if (nameFieldClass.equals(byte.class) || nameFieldClass.equals(short.class)
					|| nameFieldClass.equals(int.class) || nameFieldClass.equals(long.class)
					|| nameFieldClass.equals(float.class) || nameFieldClass.equals(double.class)) {
				nameField.set(droid, 1);
				showName(droid);
			} else if (nameFieldClass.equals(boolean.class)) {
				nameField.set(droid, true);
			} else {
				Class<?> possibleClass = Class.forName(nameFieldClass.getName());
				Constructor<?> constructor = possibleClass.getConstructor();
				if (Objects.nonNull(constructor)) {
					Object possibleObject = constructor.newInstance(new Object[] {});
					nameField.set(droid, possibleObject);
					showName(droid);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void showName(Droid droid) {
		logger.info("Name: " + droid.getName());
	}
}
