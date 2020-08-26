package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MoneyTxrServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void txrTest1() {
		TxrServiceImpl txrService = new TxrServiceImpl();
		System.out.println("Inside Txr test 1");
		assertEquals(txrService.txr(1,2,10), true);
	}
	
	@Test
	void txrTest2() {
		TxrServiceImpl txrService = new TxrServiceImpl();
		System.out.println("Inside Txr test 2");
		assertEquals(txrService.txr(2,1,10), true);
	}

	@Test
	void txrTes3() {
		TxrServiceImpl txrService = new TxrServiceImpl();
		System.out.println("Inside Txr test 3");
		assertEquals(txrService.txr(18384,1,1), false);
	}
}
