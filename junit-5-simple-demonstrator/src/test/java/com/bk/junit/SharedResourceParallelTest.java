package com.bk.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

public class SharedResourceParallelTest {

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ_WRITE)
	public void readWriteTestA(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ_WRITE)
	public void readWriteTestB(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}
	
	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ)
	public void readOnlyTestA(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ)
	public void readOnlyTestB(TestInfo info) throws InterruptedException {
		System.out.println("Executing " + info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}
}
