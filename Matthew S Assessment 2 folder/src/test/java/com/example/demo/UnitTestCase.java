package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.TxrService;
import com.example.demo.service.TxrServiceImpl;

class UnitTestCase {

	private AccountRepository accountRepository;

	@Test
	void txrTest() {
		
	Optional<Account> opt_acc1_placeholder = accountRepository.findById("1");	//Save initial account data of Acc 1
	Account acc1_placeholder = opt_acc1_placeholder.get();
	
	Optional<Account> opt_acc2_placeholder = accountRepository.findById("2");	//Save initial account data of Acc 2
	Account acc2_placeholder = opt_acc2_placeholder.get();
	
	Account acc1_test = new Account();		//Create new test account 1
	Account acc2_test = new Account();		//Create new test account 2
	
	acc1_test.setBalance(100);				//Set the new test accounts with known values
	acc1_test.setNum("1");
	
	acc2_test.setBalance(100);
	acc2_test.setNum("2");
	
	accountRepository.save(acc1_test);		// Save the accounts with known dummy values to the repository	
	accountRepository.save(acc2_test);
	
	TxrService transferTest = new TxrServiceImpl();
	
	transferTest.txr(100,"1","2");			// Use the transfer service to make a transfer of 1 -> 2, 100
	
	
	Optional<Account> opt_acc1_test_confirmation = accountRepository.findById("1");	//Reload the dummy accounts with the post transfer value
	Account acc1_test_confirmation = opt_acc1_test_confirmation.get();
	
	Optional<Account> opt_acc2_test_confirmation = accountRepository.findById("2");
	Account acc2_test_confirmation = opt_acc2_test_confirmation.get();
	
	double result1 = acc1_test_confirmation.getBalance();							// save the result of the balances 	
	double result2 = acc2_test_confirmation.getBalance();
	
	assertEquals(0, result1);														// make sure the transfer acted correctly with known post
	assertEquals(200, result2);														//		post transfer values	
	
	accountRepository.save(acc1_placeholder);										// reload the original account data	
	accountRepository.save(acc2_placeholder);
	
	}
	

}



