package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description = "Verify if Login API is working...")

	public void createAccountTest() {
		
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
		.userName("Test123456")
		.email("testuser1234@yopmail.com")
		.firstName("test123456")
		.password("Test12345")
		.lastName("User123")
		.mobileNumber("1112223334")
		.build();
		
		
		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);

	}
}
