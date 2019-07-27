package com.hcl.trainingcenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	public ResponseEntity<Object> loginUser() {

		return new ResponseEntity<>("", HttpStatus.OK);

	}
}
