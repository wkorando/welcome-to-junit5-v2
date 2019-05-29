package com.ibm.developer.junit5extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class OmniExtension4 implements BeforeAllCallback {

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("OmniExtension4 prints before all test classes again!!");
	}

}
