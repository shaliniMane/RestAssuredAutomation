package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponses {
	@Test(priority=1)
	void testxmlresponse()
	{
		// Approach 1
		
	/*	given()
		
		.when()
		   .get("https://mocktarget.apigee.net/xml")
		.then()
		   .statusCode(200)
		   .header("content-Type", "application/xml; charset=utf-8")
		   .body("root.firstName", equalTo("John"))
		   .body("root.lastName", equalTo("Doe"));
		//System.out.println(root.lastName);
		*/
		
		// approach 2
		Response res= 
				   given()
				     
				   .when()
				       .get("https://mocktarget.apigee.net/xml");
		            Assert.assertEquals(res.getStatusCode(), 200);
		            Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		            
		           String lname=res.xmlPath().get("root.lastName").toString();
		            Assert.assertEquals(lname, "Doe");
		            
	}
	@Test(priority=2)
	void testxmlresponseBody()
	{
		
		Response res =
				given()
				  
				    .when()
				       .get("https://mocktarget.apigee.net/xml");
		
		    XmlPath xmlobj= new XmlPath(res.asString());
		    
		  System.out.println("  "+xmlobj.getList("root"));   ;     
	}
	

}
