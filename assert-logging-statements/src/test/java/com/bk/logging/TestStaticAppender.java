package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("SINGLE_THREAD_ONLY") // Tag to allow these tests to be ignored when executing the test suite in
							// parallel.
public class TestStaticAppender {

	@BeforeEach
	public void clearLoggingStatements() {
		StaticAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatementsA() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("A");
		assertThat(StaticAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A",
				"This message is in a separate thread");
	}

	@Test
	public void testAssertingLoggingStatementsB() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("B");
		assertThat(StaticAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B",
				"This message is in a separate thread");
	}

}
