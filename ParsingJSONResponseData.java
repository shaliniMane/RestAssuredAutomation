package restAssuredAutomation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;





public class ParsingJSONResponseData {
	@Test(priority=1)
	public void testJSONResponse()
	{
		//Approch 1
	/*	given()
		   .contentType(ContentType.JSON)
		
		.when()
		    .get("http://localhost:3000/Store")
		    
		.then()
		   .statusCode(200)
		   .header("Content-Type", "application/json")
		   .body("books[3].title",equalTo("The Lord of the Rings"));*/
		//Approach 2
	Response res=	given()
		  .contentType(ContentType.JSON)
		.when()
		   .get("http://localhost:3000/Store");
		
		   Assert.assertEquals(res.getStatusCode(), 200);
		   Assert.assertEquals(res.header("Content-Type"), "application/json");
		String bookname =  res.jsonPath().get("books[3].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");
	
		//.then();
	
		   
	}
	@Test(priority=2)
	public void testJSONResponseBodydata()
	{
		
		Response res= 
			given()
				 .contentType(ContentType.JSON)
			 .when()
				  .get("http://localhost:3000/Store");
				     //  String res1= res.toString();
				         JSONObject jo = new JSONObject(res.asString());
		                
				           /*for(int i=0; i<jo.getJSONArray("books").length();i++)
				           {
				        	String booktitle=   jo.getJSONArray("books").getJSONObject(i).get("title").toString() ;
				        	System.out.println(booktitle);
				        	
				           }*/
				         
				         // search for title of the book in json
				         boolean status=false;
				         for(int i=0; i<jo.getJSONArray("books").length();i++)
				           {
				        	String booktitle=   jo.getJSONArray("books").getJSONObject(i).get("title").toString() ;
				        	if(booktitle.equals("The Lord of the Rings"))
				        	{
				        		status=true;
				        		break;
				        	}
				        	
				           }
				        Assert.assertEquals(status, true);
				        
				        //validate total price of book
				        double totalprice= 0;
				        for(int i=0; i<jo.getJSONArray("books").length();i++)
				           {
				        	String price=   jo.getJSONArray("books").getJSONObject(i).get("price").toString();
				        	
				            totalprice = totalprice + Double.parseDouble(price);
				            
				            
				           }
				        System.out.println("Total price:" + totalprice);
				        Assert.assertEquals(totalprice, 526.01);
	}
	}


