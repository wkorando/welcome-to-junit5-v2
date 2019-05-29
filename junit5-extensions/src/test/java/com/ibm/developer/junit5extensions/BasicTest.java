package com.ibm.developer.junit5extensions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@ExtendWith(OmniExtension.class)
@TestMethodOrder(MethodOrderer.class)
public class BasicTest {

	@RegisterExtension
	OmniExtension omniExtension = new OmniExtension();
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAllInClass");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEachInClass");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("afterEachInClass");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("afterAllInClass");
	}

	@Test
	@Order(1)
	public void passingTest(String test, String test2, String test3) {
		System.out.println("passingTest");
	}

	@TestTemplate
	public void testTemplate() {
		System.out.println("testTemplate");
	}

//	@Test
//	@Disabled
//	public void skippedTest(String test) {
//		System.out.println("skippedTest");
//	}
//
//	@Test
//	public void failingTest() {
//		System.out.println("failingTest");
//		assertTrue(false);
//	}
}
