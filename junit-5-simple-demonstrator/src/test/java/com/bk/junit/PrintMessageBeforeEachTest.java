package com.bk.junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PrintMessageBeforeEachTest implements BeforeEachCallback {
	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("Printing Message Before Each Line");
	}

}
