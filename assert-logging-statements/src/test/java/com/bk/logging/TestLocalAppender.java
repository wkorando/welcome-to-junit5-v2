package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

public class TestLocalAppender {
	@BeforeAll
	public static void setup() {
		LocalAppender.pauseTillLogbackReady();
	}

	@Test
	@ResourceLock(value = "LOGGING", mode = ResourceAccessMode.READ_WRITE)
	public void testLocalAppenderA() {
		OtherLogProducingService service = new OtherLogProducingService();

		LocalAppender localAppender = LocalAppender.initialize("com.bk.logging.OtherLogProducingService");

		service.writeSomeLoggingStatements("Other logging servie A");
		assertThat(localAppender.getEvents()).extracting("message")
				.containsOnly("Let's assert some logs! Other logging servie A", "This message is in a separate thread");

		LocalAppender.cleanup(localAppender);
	}

	@Test
	@ResourceLock(value = "LOGGING", mode = ResourceAccessMode.READ_WRITE)
	public void testLocalAppenderB() {
		OtherLogProducingService service = new OtherLogProducingService();

		LocalAppender localAppender = LocalAppender.initialize("com.bk.logging.OtherLogProducingService");

		service.writeSomeLoggingStatements("Other logging servie B");
		assertThat(localAppender.getEvents()).extracting("message")
				.containsOnly("Let's assert some logs! Other logging servie B", "This message is in a separate thread");

		LocalAppender.cleanup(localAppender);
	}

	/*
	 * By declaring as READ, can execute in parallel with other READ test cases, but
	 * not at the same time as a READ_WRITE test cases
	 */
	@Test
	@ResourceLock(value = "LOGGING", mode = ResourceAccessMode.READ)
	public void justAnotherTest() {
		OtherLogProducingService service = new OtherLogProducingService();
		service.writeSomeLoggingStatements("Local appender");

		// Executing just to add some logs
	}

	@Test
	@ResourceLock(value = "LOGGING", mode = ResourceAccessMode.READ)
	public void yetAnotherTest() {
		OtherLogProducingService service = new OtherLogProducingService();
		service.writeSomeLoggingStatements("Local appender");

		// Executing just to add some logs
	}

}
