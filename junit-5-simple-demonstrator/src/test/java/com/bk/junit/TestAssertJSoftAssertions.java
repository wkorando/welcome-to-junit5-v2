package com.bk.junit;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestAssertJSoftAssertions {

	@Test
	@Tag("failingTest")
	public void testSoftAssertions() {
		Person person = new Person("John", "Doe");
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(person.getFName()).isEqualTo("Anonymous");
		softly.assertThat(person.getLName()).isEqualTo("Person");
		softly.assertAll();
	}

	public class Person {
		private String fName;
		private String lName;

		public Person(String fName, String lName) {
			this.fName = fName;
			this.lName = lName;
		}

		public String getFName() {
			return fName;
		}

		public String getLName() {
			return lName;
		}

	}
}
