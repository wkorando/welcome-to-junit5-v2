package com.bk.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

@Timeout(3) // Sets timeout limit for each test in class to three seconds
@TestMethodOrder(OrderAnnotation.class)
public class TimeoutTest {

	static int testCounter = 0;

	@BeforeAll
	@Timeout(2) // If this timeout is exceeded, all tests are failed
	public static void classSetupWithTimeout() throws InterruptedException {
		// ...complex setup code
	}

	@BeforeEach
	@Timeout(2) // If timeout is exceeded current test is failed, but next test will be
				// attempted
	public void methodSetupWithTimeout() throws InterruptedException {
		Thread.sleep(1500 * testCounter);
	}

	@AfterAll
	@Timeout(2) // If timeout is exceeded current test is failed, but next test will be
				// attempted
	public static void methodTeardownWithTimeout() throws InterruptedException {
		Thread.sleep(1500 * testCounter);
		System.out.print("methodTeardownWithTimeout");
	}

	@Test
	@Timeout(unit = TimeUnit.MILLISECONDS, value = 500L) // Default unit is seconds, but other options available
	@Order(1)
	public void testTestCaseTimeout() throws InterruptedException {
		Thread.sleep(600);
	}

	@Test
	@Order(2)
	public void testExceedsClassTimeLimit() throws InterruptedException {
		Thread.sleep(3500);
	}

	@Test
	@Order(3)
	public void timeoutTest1() {
		testCounter = testCounter + 1;
	}

	@Test
	@Order(4) // Will fail due to timeout
	public void timeoutTest2() {
		testCounter = testCounter + 1;
	}

	@Test
	@Order(5) // Will fail due to timeout, but still attempted
	public void timeoutTest3() {
		testCounter = testCounter + 1;
	}
}
