package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This appender is thread safe as a new list is created for every test case.
 * However this appender will only capture logging statements written within the
 * same thread as the test case the started the execution.
 * 
 * @author williamkorando
 *
 */
public class TestThreadSafeAppender {

	@BeforeAll
	public static void setup() {
		ThreadSafeAppender.pauseTillLogbackReady();
	}

	@BeforeEach
	public void clearLoggingStatements() {
		ThreadSafeAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatementsA() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("A");
		assertThat(ThreadSafeAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A");
	}

	@Test
	public void testAssertingLoggingStatementsB() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("B");
		assertThat(ThreadSafeAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B");
	}

}
