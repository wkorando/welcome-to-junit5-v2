package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

public class TestInterceptorAPI {

//	@RegisterExtension
//	AddStringsToTestsInterceptor interceptor = new AddStringsToTestsInterceptor("Add value by interceptor");

	@RegisterExtension
	Object object = new PrintMessageBeforeEachTest();

	@Test
	public void testInterceptor() {
//		assertEquals("Add value by interceptor", arg);
	}
}
