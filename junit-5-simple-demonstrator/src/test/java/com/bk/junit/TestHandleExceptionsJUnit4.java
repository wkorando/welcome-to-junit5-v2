package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestHandleExceptionsJUnit4 {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test(expected = SpecificException.class)
	public void testSpecificExceptionHandling() throws SpecificException {
		onlyThrowsExceptions();
	}
	

	@Test(expected = Exception.class)//Passes because Exception is super type of SpecificException
	public void testExceptionHandling() throws SpecificException {
		onlyThrowsExceptions();
	}

	@Test(expected = SpecificException.class)
	public void testExceptionHandlingVerifyExceptionFields() throws SpecificException {
		try {
			onlyThrowsExceptions();
		} catch (SpecificException e) {
			assertEquals("An exception was thrown!", e.getMessage());
			throw e;
		}
	}

	@Test
	public void testUseExpectedException() throws SpecificException {
		expectedException.expect(SpecificException.class);
		expectedException.expectMessage("An exception was thrown!");
		onlyThrowsExceptions();
	}
	
	@Test
	public void testUseExpectedExceptionWithSuperType() throws SpecificException {
		expectedException.expect(Exception.class);//Passes because Exception is super type of SpecificException
		expectedException.expectMessage("An exception was thrown!");
		onlyThrowsExceptions();
	}

	public void onlyThrowsExceptions() throws SpecificException {
		throw new SpecificException("An exception was thrown!");
	}

	public class SpecificException extends Exception {

		public SpecificException(String message) {
			super(message);
		}

	}
}
