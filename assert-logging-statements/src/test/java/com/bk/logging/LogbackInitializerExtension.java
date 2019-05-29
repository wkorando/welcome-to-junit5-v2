package com.bk.logging;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

/**
 * Example of a custom JUnit 5 extension. Automatically handles pausing the
 * execution of a test cases until logback without having to implement
 * a @BeforeAll method in each test class. 
 * 
 * @see LogbackInitializer 
 * 
 * @author William.Korando
 *
 */
public class LogbackInitializerExtension implements BeforeAllCallback {

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		pauseTillLogbackReady();
	}

	private static void pauseTillLogbackReady() {
		do {

		} while (!isLogbackReady());
	}

	private static boolean isLogbackReady() {
		try {
			LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		} catch (ClassCastException castException) {
			return false;
		}
		return true;
	}
}
