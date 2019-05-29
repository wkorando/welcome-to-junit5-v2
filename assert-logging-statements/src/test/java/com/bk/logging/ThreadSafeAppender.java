package com.bk.logging;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Thread safe implementation of an appender.
 * 
 * @author williamkorando
 *
 */
public class ThreadSafeAppender extends AppenderBase<ILoggingEvent> {
	static ThreadLocal<List<ILoggingEvent>> threadLocal = new ThreadLocal<>();

	@Override
	public void append(ILoggingEvent e) {
		List<ILoggingEvent> events = threadLocal.get();
		if (events == null) {
			events = new ArrayList<>();
			threadLocal.set(events);
		}
		events.add(e);
	}

	public static List<ILoggingEvent> getEvents() {
		return threadLocal.get();
	}

	public static void clearEvents() {
		threadLocal.remove();
	}

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
}
