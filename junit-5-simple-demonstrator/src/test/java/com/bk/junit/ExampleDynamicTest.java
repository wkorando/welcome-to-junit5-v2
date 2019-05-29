package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Simple example of writing a dynamic test.
 * @author williamkorando
 *
 */
public class ExampleDynamicTest {

	@TestFactory
	public List<DynamicTest> exampleTestFactory() {
		return Arrays.asList(
				dynamicTest("Dynamic square " + 2, () -> assertEquals(4, 2 * 2)),//
				dynamicTest("Dynamic true " + true, () -> assertTrue(true)));
	}
}
