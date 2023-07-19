package com.irrigation.irrigation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.irrigation.services.irrigateService;

@RestController
public class irrigateController {
	
	@Autowired
	irrigateService irrigateservice;
	
	@PostMapping("/irrigate")
	public ResponseEntity irrigate() {
		irrigateservice.irrigate();
		return new ResponseEntity(HttpStatus.OK);
		
	}

}
