package com.bk.logging;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * This appender will capture all logging statements written by a test case,
 * however the executing test case must initialize and configure this appender
 * for it to work.
 * 
 * @author williamkorando
 *
 */
public class LocalAppender extends AppenderBase<ILoggingEvent> {
	private List<ILoggingEvent> events = new ArrayList<>();

	public LocalAppender() {
		start();
	}

	/**
	 * Factory method for reducing the noise of initializing and configuring a
	 * appender in a test case.
	 * 
	 * @return
	 */
	public static LocalAppender initialize(String... loggers) {
		LocalAppender localAppender = new LocalAppender();
		for (String loggerName : loggers) {
			localAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
			Logger logger = (Logger) LoggerFactory.getLogger(loggerName);
			logger.addAppender(localAppender);
		}
		return localAppender;
	}

	/**
	 * Logback can sometimes take a moment to initialize, this method will return
	 * false until Logbackis ready.
	 */
	public static void pauseTillLogbackReady() {
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

	public static void cleanup(LocalAppender localAppender) {
		/*
		 * Appenders cannot be easily removed when using logback, but by stopping an
		 * appender it does at least reduce resource utilization.
		 */
		localAppender.stop();
		localAppender.clearEvents();
	}

	@Override
	public void append(ILoggingEvent e) {
		events.add(e);
	}

	public List<ILoggingEvent> getEvents() {
		return events;
	}

	public void clearEvents() {
		events.clear();
	}
}
