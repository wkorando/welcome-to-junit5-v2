package com.bk.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagsTest {

	@Test
	@Tag("excludeTag")
	public void excludeTagTest() {
		// no-op
	}

	@Test
	@Tag("includeTag")
	public void includeTagTest() {
		// no-op
	}
}