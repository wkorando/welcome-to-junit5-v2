package com.bk.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.RegisterExtension;

public class TestRegisterExtensionUpdates {

	@RegisterExtension
	private PrintMessageBeforeEachTest beforeEachExtension = new PrintMessageBeforeEachTest();

	@RegisterExtension
	Object declareTypeNotExtensiopn = new PrintMessageBeforeEachTest();

	@RegisterExtension
	Object notAnExtension = new Object();

	@Test
	public void testNoOp() {
		//Do nothing 
	}
}