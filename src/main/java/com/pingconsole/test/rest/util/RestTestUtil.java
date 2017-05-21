package com.pingconsole.test.rest.util;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.pingconsole.test.rest.domain.Authorization;
import com.pingconsole.test.rest.domain.HeaderDTO;
import com.pingconsole.test.rest.domain.HttpMethod;
import com.pingconsole.test.rest.domain.RestAPITestDTO;
import com.pingconsole.test.rest.domain.RestAPITestResultDTO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTestUtil {

	public static RestAPITestResultDTO testRestAPI(RestAPITestDTO restAPITestDTO) {

		RestAPITestResultDTO restAPITestResultDTO = new RestAPITestResultDTO();
		RequestSpecification rs = RestAssured.given();
		if (!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())) {
			setHeaders(rs, restAPITestDTO.getHeaders());
		}
		if (!CollectionUtils.isEmpty(restAPITestDTO.getHeaders())) {
			setHeaders(rs, restAPITestDTO.getHeaders());
		}
		if (restAPITestDTO.getAuthorization() != null) {
			setAuthorization(rs, restAPITestDTO.getAuthorization());
		}
		rs.contentType(ContentType.JSON);

		Response r = makeRequest(restAPITestDTO, rs);

		restAPITestResultDTO.setResponseTime(r.getTime());
		restAPITestResultDTO.setStatusCode(r.getStatusCode());

		restAPITestResultDTO.setResponse(r.getBody().jsonPath().prettify());

		return restAPITestResultDTO;
	}

	private static void setAuthorization(RequestSpecification rs, Authorization authorization) {
		switch (authorization.getAuthType()) {
		case Authorization.NO_AUTH:

			break;

		case Authorization.BASIC_AUTH:

			break;
		case Authorization.DIGEST_AUTH:

			break;
		case Authorization.OAUTH_1_0:

			break;
		case Authorization.OAUTH_2_0:

			break;
		case Authorization.HAWK_AUTH:

			break;
		case Authorization.AWS_SIGN:

			break;

		default:
			break;
		}

	}

	private static Response makeRequest(RestAPITestDTO restAPITestDTO, RequestSpecification rs) {
		Response r = null;
		switch (restAPITestDTO.getMethod()) {
		case HttpMethod.GET:
			r = rs.get(restAPITestDTO.getRestAPIUrl());
			break;

		case HttpMethod.POST:
			r = rs.post(restAPITestDTO.getRestAPIUrl());
			break;

		case HttpMethod.PUT:
			r = rs.put(restAPITestDTO.getRestAPIUrl());
			break;

		case HttpMethod.OPTION:
			r = rs.options(restAPITestDTO.getRestAPIUrl());
			break;

		default:
			break;
		}
		return r;
	}

	private static void setHeaders(RequestSpecification rs, List<HeaderDTO> headers) {
		for (HeaderDTO headerDTO : headers) {
			rs.header(headerDTO.getKey(), headerDTO.getValue());
		}
	}

}
