package com.restassured.udemy.addApi;

import static org.testng.Assert.assertEquals;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js= new JsonPath(Payload.coursePrise());
		int coursecount=js.getInt("courses.size()");
		System.out.println("size count is "+ coursecount);
		
		// print purchase amount
		int amount=js.getInt("dashboard.purchaseAmount");
		System.out.println("Course purchase Amount is "+ amount);
		
		//Print first course title
		
		String title= js.getString("courses[0].title");
		System.out.println("first course title is : "+ title );
		
		// print course tile and prise
		
		for(int i=0;i<coursecount;i++) {
			//System.out.println(js.getString("courses["+i+"].title"));
			System.out.println(js.getString("courses["+i+"].title"));
			System.out.println(js.getInt("courses["+i+"].price"));
			System.out.println(js.getInt("courses["+i+"].copies"));
		}
		
		
		
		// Print the no copies sold by RPA
		for(int i=0;i<coursecount;i++) {
			String courseTitle=js.getString("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("Selenium Python")) {
				System.out.println("no of copies sold by RPA is :" + js.getInt("courses["+i+"].copies"));
				break;
			}
			
		}
		
			//Verify if sum of all courses prise is matches with purchase amount  
		
		int actualcost =js.getInt("dashboard.purchaseAmount");
		int total=0;
		for(int i=0;i<coursecount;i++) {
			int price,copies,sum=0 ;
		    price=js.getInt("courses["+i+"].price");
		   copies=js.getInt("courses["+i+"].copies");
		   sum= price*copies;
			total=total+sum;
		  
	}
		System.out.println("total cost is" +total);
		assertEquals(actualcost, total);
		}
	

}
