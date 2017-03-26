package com.pingconsole.test.rest.util;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.pingconsole.test.rest.domain.HeaderDTO;
import com.pingconsole.test.rest.domain.RestAPITestDTO;
import com.pingconsole.test.rest.domain.RestAPITestResultDTO;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestTestUtil {
	
	public static RestAPITestResultDTO testRestAPI(RestAPITestDTO restAPITestDTO){
		
		RestAPITestResultDTO restAPITestResultDTO = new RestAPITestResultDTO();
		RequestSpecification rs = given();
		if(!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())){
			setHeaders(rs,restAPITestDTO.getHeaders());
		}
		if(!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())){
			setHeaders(rs,restAPITestDTO.getHeaders());
		}
		if(restAPITestDTO.getAuthorization() != null){
			setHeaders(rs,restAPITestDTO.getHeaders());
		}
		rs.contentType(ContentType.JSON);
		
		
		return restAPITestResultDTO;
	}

	private static void setHeaders(RequestSpecification rs, List<HeaderDTO> headers) {
		for (HeaderDTO headerDTO : headers) {
			rs.header(headerDTO.getKey(), headerDTO.getValue());
		}
	}
	
	

}
