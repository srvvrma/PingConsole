package com.pingconsole;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.response.Response;

public class RestTest {
	
	@Test
	public void givenU(){
		Response r = get("http://jsonplaceholder.typicode.com/posts/1");
		r.getBody().jsonPath().prettify();
	}

}
