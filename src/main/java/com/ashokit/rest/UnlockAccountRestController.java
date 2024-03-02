package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.UnlockAccRequest;
import com.ashokit.service.UnlockAccountService;

@RestController
public class UnlockAccountRestController {
	
	@Autowired
	private UnlockAccountService service;
	
	@PostMapping("/unlockaccount")
	public String unlockAccount(@RequestBody UnlockAccRequest request) {
		return service.unlockAccount(request);
	}

}
