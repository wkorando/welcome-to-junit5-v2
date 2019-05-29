package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestHandleExceptionsJUnit5 {

	@Test
	public void testExceptionHandling() {
		Exception e = assertThrows(SpecificException.class, () -> onlyThrowsExceptions());
		assertEquals("An exception was thrown!", e.getMessage());
	}
	
	
	@Test
	@Tag("failingTest")
	public void testExceptionHandlingFailWrongExceptionType() {
		assertThrows(Exception.class, () -> doesntThrowExceptions(), "Wrong exception type thrown!");
	}
	
	@Test
	@Tag("failingTest")
	public void testExceptionHandlingFailNoExceptionThrown() {
		assertThrows(SpecificException.class, () -> doesntThrowExceptions(), "An exception wasn't thrown!");
	}

	public void onlyThrowsExceptions() throws SpecificException {
		throw new SpecificException("An exception was thrown!");
	}
	
	public void doesntThrowExceptions() {
		//do nothing
	}
	
	public class SpecificException extends Exception{

		public SpecificException(String message) {
			super(message);
		}
		
	}
}
