package com.bk.junit;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class ConsoleOutputListener implements TestExecutionListener {

	@Override
	public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
		entry.getKeyValuePairs().values().stream().forEach(c -> System.out.println("Captured output: " + c));
		TestExecutionListener.super.reportingEntryPublished(testIdentifier, entry);
	}

}
