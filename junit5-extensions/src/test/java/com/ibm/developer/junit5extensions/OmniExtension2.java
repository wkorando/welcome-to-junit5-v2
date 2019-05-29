package com.ibm.developer.junit5extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class OmniExtension2 implements BeforeAllCallback {

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("OmniExtension2 prints before all test classes again!!");
	}

}
