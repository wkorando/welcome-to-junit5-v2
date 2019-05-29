package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestMockitoInjection {
	private BoringService service;

	public TestMockitoInjection(@Mock BoringService service) {
		this.service = service;
	}

	@Test
	public void testConstructorInjectedValue() {
		when(service.returnNumber()).thenReturn(2);
		assertEquals(2, service.returnNumber());
	}

	@Test
	public void testMethodInjection(@Mock BoringService service) {
		when(service.returnNumber()).thenReturn(3);
		assertEquals(3, service.returnNumber());
	}

	public class BoringService {
		public int returnNumber() {
			return 1;
		}
	}
}
