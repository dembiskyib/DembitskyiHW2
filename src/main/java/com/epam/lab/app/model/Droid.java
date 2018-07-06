package com.epam.lab.app.model;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Droid {
	private static final Logger logger = LogManager.getLogger(Droid.class);
	@MyAnnotation(name = "name")
	private String name;
	@MyAnnotation(name = "healthPoints")
	private int healthPoints;
	private int damage;
	private int maxHealth;

	public Droid() {

	}

	public Droid(String name) {
		this.name = name;
	}

	public void restoreHealthPoints() {
		healthPoints = maxHealth;
		logger.info("HP restored");
	}

	public int addDamage(int additionalDamage) {
		return damage += additionalDamage;
	}

	public String getName() {
		return name;
	}

	public void myMethod(String string, int... intArgs) {
		logger.info("String: " + string + "\nIntArgs:");
		for (int i = 0; i < intArgs.length; i++) {
			logger.info(intArgs[i]);
		}
	}

	public void myMethod(String... strings) {
		logger.info("Strings:");
		Arrays.asList(strings).forEach(string -> logger.info(string));
	}
}
