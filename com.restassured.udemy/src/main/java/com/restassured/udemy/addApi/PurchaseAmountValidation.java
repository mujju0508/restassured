package com.restassured.udemy.addApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class PurchaseAmountValidation {
	
	
	
	@Test(enabled = false)
	public void sumTest() {
		JsonPath js = new JsonPath(Payload.coursePrise());
		int actutalPurchaseAmount =js.getInt("dashboard.purchaseAmount");
		int price,copies,sum,totalcost=0;
		int courseCount= js.getInt("courses.size()");
		for(int i=0;i<courseCount;i++) {
			price=js.getInt("courses["+i+"].price");
			copies=js.getInt("courses["+i+"].copies");
			sum=price*copies;
			totalcost=totalcost+sum;
		}
		System.out.println("Total cost is" + totalcost);
		assertEquals(actutalPurchaseAmount, totalcost);
	}
	
	@Test
	public void addPlace() {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
	String addPlaceresponse =	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().body().asString();
		System.out.println("JSON response is");
		System.out.println(addPlaceresponse);
		JsonPath js= new JsonPath(addPlaceresponse);
		
		String placeId =js.getString("place_id");
		System.out.println("PlaceID is " +placeId );
	}

}


