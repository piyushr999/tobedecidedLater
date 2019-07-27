package com.hcl.trainingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingcenter.dto.UserDto;
import com.hcl.trainingcenter.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("")
	public ResponseEntity<Object> loginUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(loginService.loginUser(userDto), HttpStatus.OK);

	}
}
