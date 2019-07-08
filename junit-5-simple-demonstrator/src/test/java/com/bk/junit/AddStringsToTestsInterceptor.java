//package com.bk.junit;
//
//import java.lang.reflect.Method;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.InvocationInterceptor;
//import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
//
//public class AddStringsToTestsInterceptor implements InvocationInterceptor {
//
//	private String value;
//
//	public AddStringsToTestsInterceptor(String value) {
//		super();
//		this.value = value;
//	}
//
//	public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
//			ExtensionContext extensionContext) throws Throwable {
//		invocationContext.getArguments().set(0, value);
//		invocation.proceed();
//	}
//
//}
