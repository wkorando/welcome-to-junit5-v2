package com.ibm.developer.junit5extensions;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.jupiter.api.extension.TestWatcher;

public class OmniExtension implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback,
		BeforeAllCallback, BeforeEachCallback, BeforeTestExecutionCallback, ExecutionCondition, ParameterResolver,
		TestExecutionExceptionHandler, TestInstancePostProcessor, TestTemplateInvocationContextProvider, TestWatcher {
	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("beforeAll");
	}

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		System.out.println("testDisabled");

	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		System.out.println("testSuccessful");

	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		System.out.println("testAborted");

	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		System.out.println("testFailed");

	}

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		System.out.println("supportsTestTemplate");
		return true;
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		System.out.println("provideTestTemplateInvocationContexts");
		return null;
	}

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		System.out.println("postProcessTestInstance");

	}

	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		System.out.println("handleTestExecutionException");
		throw throwable;
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		System.out.println("supportsParameter");
		return true;
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		System.out.println("resolveParameter");
		return null;
	}

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		System.out.println("evaluateExecutionCondition");

		return ConditionEvaluationResult.enabled("");
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		System.out.println("beforeTestExecution");

	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("beforeEach");

	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		System.out.println("afterTestExecution");

	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		System.out.println("afterEach");

	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		System.out.println("afterAll");

	}

}
