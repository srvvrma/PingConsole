package com.pingconsole.test.rest.util;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.pingconsole.test.rest.domain.HeaderDTO;
import com.pingconsole.test.rest.domain.RestAPITestDTO;
import com.pingconsole.test.rest.domain.RestAPITestResultDTO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTestUtil {
	
  public static RestAPITestResultDTO testRestAPI(RestAPITestDTO restAPITestDTO){
		
		RestAPITestResultDTO restAPITestResultDTO = new RestAPITestResultDTO();
		RequestSpecification rs = RestAssured.given();
		if(!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())){
			setHeaders(rs,restAPITestDTO.getHeaders());
		}
		if(!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())){
			setHeaders(rs,restAPITestDTO.getHeaders());
		}
		if(restAPITestDTO.getAuthorization() != null){
			//setHeaders(rs,restAPITestDTO.getHeaders());
		}
		rs.contentType(ContentType.JSON);
		Response r = rs.get(restAPITestDTO.getRestAPIUrl());
		restAPITestResultDTO.setResponse(r.getBody().jsonPath().prettify());
		
		return restAPITestResultDTO;
	}

	private static void setHeaders(RequestSpecification rs, List<HeaderDTO> headers) {
		for (HeaderDTO headerDTO : headers) {
			rs.header(headerDTO.getKey(), headerDTO.getValue());
		}
	}
	

}
