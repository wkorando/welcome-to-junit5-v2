package com.bk.logging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherLogProducingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OtherLogProducingService.class);

	public void writeSomeLoggingStatements(String message) {
		LOGGER.info("Let's assert some logs! " + message);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> future = executor.submit(() -> LOGGER.info("This message is in a separate thread"));
		do {
			// wait for future to complete
		} while (!future.isDone());
	}
}
