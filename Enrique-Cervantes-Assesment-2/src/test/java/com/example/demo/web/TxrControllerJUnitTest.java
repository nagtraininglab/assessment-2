package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

abstract class TxrServiceJUnitTest implements TxrService {
	
	@Mock
	TxrService mockService;
	
	@Rule public MockitoRule mockRule = MockitoJUnit.rule();
	
	
	@Test
	void test() {
		ClassToTest test = new ClassToTest(mockService);
		boolean check = test.txr(99.9,"1", "2");
		assertTrue(check, true);
	}

}