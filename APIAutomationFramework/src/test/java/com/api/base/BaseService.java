package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Base class act as a wrapper around the rest Assured library
public class BaseService { 
//BASE URL
// CREATING THE REQUEST
//HANDLING THE RESPONSE

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

}
