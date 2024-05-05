package restAssuredAutomation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class WaysToCreatePostRequestBody {
	String id;
	//@Test(priority=1)
	public void testPostUsingHashmap() {
		
		HashMap data= new HashMap();
		
		data.put("name", "shalini");
		data.put( "location", "India");
		data.put( "phone", "1234567");
		
	    String	courseArr[] = {"Java", "Selenium"};
		data.put("courses", courseArr);
		
	
      id =  given()
           .contentType("application/json")
           .body(data)       
        .when()
           .post("http://localhost:3000/students")
           .jsonPath().getString("id");
           
      /*  .then()
          .statusCode(201)
          .body("name", equalTo("shalini"))
          .body("location", equalTo("India"))
          .body("phone", equalTo("1234567"))  
          .body("courses[0]", equalTo("Java"))
          .body("courses[1]", equalTo("Selenium"))
          .header("Content-Type","application/json")
         
          
          .log().all();*/
          
				
}
	//@Test(priority=1)
public void testPostUsingOrgJSONlib() {
		
	 JSONObject data = new JSONObject();
	 data.put("name", "shaliniMane");
	 data.put("location", "India1");
	 data.put("phone", "12345673");
	 String coursesArr[] = {"Java1","selenium1"};
	 data.put("courses", coursesArr);
		
      id =  given()
           .contentType("application/json")
           .body(data.toString())       
        .when()
           .post("http://localhost:3000/students")
           .jsonPath().getString("id");
           
      /*  .then()
          .statusCode(201)
          .body("name", equalTo("shalini"))
          .body("location", equalTo("India"))
          .body("phone", equalTo("1234567"))  
          .body("courses[0]", equalTo("Java"))
          .body("courses[1]", equalTo("Selenium"))
          .header("Content-Type","application/json")
         
          
          .log().all();*/
          
				
}
	@Test(priority=2, dependsOnMethods = {"testPostUsingPOJOclass"} )
	public void testDelete()
	{
		given()
		
		.when()
		 .delete("http://localhost:3000/students/"+id)
		
		.then()
		  .statusCode(200);
		 
	}
	
	
	//@Test(priority=1)
		public void testPostUsingPOJOclass() {
			
			Pojo_Postqeruest data= new Pojo_Postqeruest();
			data.setName("Shalu112");
			data.setLocation("Pune");
			data.setPhone("3434343434");
			String courserArr[]= {"C","c++"};
			data.setCourses(courserArr);
		
	      id =  given()
	           .contentType("application/json")
	           .body(data)       
	        .when()
	           .post("http://localhost:3000/students")
	           .jsonPath().getString("id");
	           
	      /*  .then()
	          .statusCode(201)
	          .body("name", equalTo("shalini"))
	          .body("location", equalTo("India"))
	          .body("phone", equalTo("1234567"))  
	          .body("courses[0]", equalTo("Java"))
	          .body("courses[1]", equalTo("Selenium"))
	          .header("Content-Type","application/json")
	         
	          
	          .log().all();*/
	          
					
	}
		@Test(priority=1)
				public void testPostUsingExternalJSONFile() throws FileNotFoundException {
					
		  // File f = new File("/Users/shalinimane/eclipse-workspace/demosdetRestAssured/body.json");
		   File f = new File(".//body.json");
		   
		   FileReader fr = new FileReader(f);
		   JSONTokener jt= new JSONTokener(fr);
		   JSONObject data= new JSONObject(jt);
					
				
			       given()
			           .contentType("application/json")
			           .body(data.toString())       
			        .when()
			           .post("http://localhost:3000/students");
			          // .jsonPath().getString("id");
			           
			      /*  .then()
			          .statusCode(201)
			          .body("name", equalTo("shalini"))
			          .body("location", equalTo("India"))
			          .body("phone", equalTo("1234567"))  
			          .body("courses[0]", equalTo("Java"))
			          .body("courses[1]", equalTo("Selenium"))
			          .header("Content-Type","application/json")
			         
			          
			          .log().all();*/
			          
							
			}
			
}
