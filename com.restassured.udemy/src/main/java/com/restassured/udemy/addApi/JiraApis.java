package com.restassured.udemy.addApi;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class JiraApis {

	@Test
	public void createSession() {
		// Createing a Issue
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI ="http://localhost:8081/";
		
		String response =given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"username\":\"mujju0508\",\"password\":\"Afshan@786\"\r\n"
				+ "}").filter(session).when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().body().asString();
				
		JsonPath js =new JsonPath(response);
		String sessionId= js.getString("session.value");
		System.out.println("Session Id is: " + sessionId );
		
			
		// Add Comment
		
		 String addCommentResponse= given().log().all().pathParam("key", "10001")
		 							.header("Content-Type","application/json").body("{\r\n"
		 		+ "    \"body\": \"Added new comment to my new issues through automation.\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").when().filter(session).post("rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract().body().asString();
	}
}
