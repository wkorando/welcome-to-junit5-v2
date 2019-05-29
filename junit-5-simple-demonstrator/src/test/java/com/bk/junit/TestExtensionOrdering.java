package com.bk.junit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

public class TestExtensionOrdering {

	@RegisterExtension
	@Order(3)
	static ExampleJUnit5Extension extensionA = new ExampleJUnit5Extension("A");
	@RegisterExtension
	@Order(2)
	static ExampleJUnit5Extension extensionB = new ExampleJUnit5Extension("B");
	@RegisterExtension
	@Order(1)
	static ExampleJUnit5Extension extensionC = new ExampleJUnit5Extension("C");

	@Test
	public void testCaseA() {
		// Do nothing
	}

	@Test
	public void testCaseB() {
		// Do nothing
	}

	public static class ExampleJUnit5Extension
			implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

		private String value;

		public ExampleJUnit5Extension(String value) {
			this.value = value;
		}

		@Override
		public void beforeAll(ExtensionContext context) throws Exception {
			System.out.println("Executing beforeAll with value:" + value);
		}

		@Override
		public void afterAll(ExtensionContext context) throws Exception {
			System.out.println("Executing afterAll with value:" + value);
		}

		@Override
		public void afterEach(ExtensionContext context) throws Exception {
			System.out.println("Executing afterEach with value:" + value);

		}

		@Override
		public void beforeEach(ExtensionContext context) throws Exception {
			System.out.println("Executing beforeEach with value:" + value);
		}

	}

}
