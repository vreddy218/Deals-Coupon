package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwtFilters.JwtUtils;
import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.SecurityService;

@RestController
@CrossOrigin( "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SecurityService customerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	
	@GetMapping("/dashboard")
	private String testingToken()
	{
		return "<h1>Welcome to Dashboard<h1>"; 
	}
	
	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		Customer customer=new Customer();
		customer.setUsername(username);
		customer.setPassword(password);
		 
		try {
			customerRepository.save(customer);
			}
		catch(Exception e)
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error during subscription"+username));	
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Successfully subcribed "+username));
	}
	
	
	
	 
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		

		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(Exception e)
		{
		return ResponseEntity.ok(new AuthenticationResponse("Error during authentication"+username));
		}
		
		UserDetails loadedUser=customerService.loadUserByUsername(username);
		
		String generatedToken=jwtUtils.generateToken(loadedUser);

		return ResponseEntity.ok(new AuthenticationResponse(generatedToken ));
	
}
}