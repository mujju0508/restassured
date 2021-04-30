package com.restassured.udemy.addApi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class DynamicJson {
	String id;
	List<String> bookid = new ArrayList<String>();

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn,String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String res = given().log().all().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle))
				.when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js= new JsonPath(res); 
		System.out.println("Response from JS");
		System.out.println();
		 id=js.getString("ID");
		System.out.println(id);
		bookid.add(id);
		int size =bookid.size();
		System.out.println("ID isze is"+ size);
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type","application/json").body(Payload.deleteBook(id)).when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	}
	
	
	// Delete BooK
	@Test(dataProvider = "BooksData",enabled = false)
	public void deleteBook(String isbn,String aisle) {
		this.id =isbn+aisle;
		System.out.println("boodId is "+ id);
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type","application/json").body(Payload.deleteBook(id)).when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
	}
	
	
	@DataProvider(name ="BooksData")
	public Object[][] getData() {
		
		
		return new Object[][] {{"asde","1121"},{"assf","1091"},{"attuk","19734"}};
	}
	
	
}
