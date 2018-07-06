package com.epam.lab.app.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;

public class Task4 implements Task {
	private static final Logger logger = LogManager.getLogger(Task4.class);

	public void show() {
		try {
			Class<?> droid = Class.forName("com.epam.lab.app.model.Droid");
			List<Method> methods = new ArrayList<>();
			methods.add(droid.getMethod("restoreHealthPoints"));
			methods.add(droid.getMethod("addDamage", int.class));
			methods.add(droid.getMethod("getName"));
			Droid testDroid = new Droid("R2D2");
			methods.get(0).invoke(testDroid);
			logger.info("New damage: " + methods.get(1).invoke(testDroid, 10));
			logger.info("Name: " + methods.get(2).invoke(testDroid));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
