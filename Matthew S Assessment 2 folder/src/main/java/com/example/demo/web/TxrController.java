package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.BalanceException;
import com.example.demo.service.TxrService;

@CrossOrigin(origins = { "*" })
@RestController
public class TxrController {

	@Autowired
	private TxrService txrService;

	@PostMapping(value = "/api/txr", consumes = { "application/json" }, produces = { "application/json" })
	public TxrResponse txr(@RequestBody TxrRequest request) {
		boolean b = txrService.txr(request.getAmount(), request.getFromAccNumber(), request.getToAccNumber());
		TxrResponse txrResponse = new TxrResponse();
		txrResponse.setMessage(b ? "success" : "failed");
		return txrResponse;
	}

	@ExceptionHandler(value = { BalanceException.class, AccountNotFoundException.class })
	public TxrResponse handleExcpetion(Exception ex) {
		TxrResponse txrResponse = new TxrResponse();
		txrResponse.setMessage(ex.getMessage());
		return txrResponse;
	}

}
