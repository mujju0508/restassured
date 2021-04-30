package com.restassured.udemy.addApi;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;


public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI =RestAssured.baseURI ="https://rahulshettyacademy.com";
 String response =given().log().all().queryParam("key", "qaclick123")
.header("Content-Type","application/json").body(Payload.addPlace()).when().post("maps/api/place/add/json").then().log().all()
.assertThat().statusCode(200).body("scope",equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

 JsonPath js= new JsonPath(response); 
 
 System.out.println("++++++++++++++++++++++++++++++++++++");
 System.out.println(response);
 String place_id=js.getString("place_id");
 String scope=js.getString("scope");
 
 System.out.println(place_id);
 System.out.println(scope);
 String newAddress= "Whitefield basawanagar Bangalore, India";
 
 String getresponse=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
 		+ "\"place_id\":\""+place_id+"\" ,\r\n"
 		+ "\"address\":\""+newAddress+"\",\r\n"
 		+ "\"key\":\"qaclick123\"\r\n"
 		+ "}\r\n"
 		+ "").when().put("maps/api/place/update/json")
 			 .then().log().all().assertThat().statusCode(200).extract().response().asString();
 JsonPath js1 = new JsonPath(getresponse);
 
 
 
 String getplaceresponse =given().log().all().queryParam("key", "qaclick123")
		 .queryParam("place_id",place_id)
		 .when().get("maps/api/place/get/json")
 .then().log().all().assertThat().statusCode(200).extract().response().asString();
 
 JsonPath js2 = new JsonPath(getplaceresponse);
 String actualAddress =js2.getString("address");
 System.out.println("new from address from response is :" + actualAddress);
 
Assert.assertEquals(actualAddress, newAddress);
 
 
	}

}
