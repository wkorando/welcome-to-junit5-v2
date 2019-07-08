package com.bk.junit.parallel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ParallelTestD {

	@Test
	public void parallelTestA(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getTestClass().get().getName() + "." + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(500L);
	}

	@Test
	public void parallelTestB(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getTestClass().get().getName() + "." + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(500L);
	}

	@Test
	public void parallelTestC(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getTestClass().get().getName() + "." + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(500L);
	}

	@Test
	public void parallelTestD(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getTestClass().get().getName() + "." + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(500L);
	}

	@Test
	public void parallelTestE(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getTestClass().get().getName() + "." + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(500L);
	}
}