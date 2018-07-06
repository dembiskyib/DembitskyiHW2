package com.epam.lab.app.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.model.Droid;

public class Task5 implements Task {
	private static final Logger logger = LogManager.getLogger(Task5.class);

	public void show() {
		try {
			Class<?> droidClass = Class.forName("com.epam.lab.app.model.Droid");
			Method firstMethod = droidClass.getMethod("myMethod", String.class, int[].class);
			Method secondMethod = droidClass.getMethod("myMethod", String[].class);
			Droid testDroid = new Droid();
			int[] intArgs = { 1, 2, 3, 4 };
			String[] stringArgs = { "String arg1", "String arg2", "String arg3", "String arg4" };
			logger.info("First method:");
			firstMethod.invoke(testDroid, "String arg", intArgs);
			logger.info("\nSecond method:");
			secondMethod.invoke(testDroid, (Object) stringArgs);
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
