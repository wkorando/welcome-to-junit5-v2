package com.bk.junit;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class FailsAllTheTimeListener implements TestExecutionListener {

	@Override
	public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
		throw new RuntimeException("The FailsAllTheTimeListener - Failed yet again");
	}

}
