package com.bk.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {

	@Test
	public void parallelTestA(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	public void parallelTestB(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

}
