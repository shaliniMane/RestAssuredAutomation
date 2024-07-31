package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 //hghg
/*
given()
content type, st cookies, add auth, add param, set headers, info etc....
when()
get, post,put,delete
then()
validate status code, extract response, extract header cookies & response body...*/

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequest {
	int id;
	@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		    .statusCode(200)
		    .body("page",equalTo(2))
		    .log().all();
	}
	@Test(priority=2)
	void createUser()
	{
		
		HashMap data= new HashMap();
		data.put("name", "shalini");
		data.put("Job", "Automation tester");
		
     id=given()
           .contentType("application/json")
           .body(data)
		.when()
		   .post("https://reqres.in/api/api/users")
		   .jsonPath().getInt("id");
        
        
		//.then()
		  //  .statusCode(201)
		   // .log().all();
		    
		  
	}
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap data= new HashMap();
		data.put("name", "shalini Mane");
		data.put("Job", "Automation tester Engg");
		given()
		           .contentType("application/json")
		           .body(data)
		.when()
		.put("https://reqres.in/api/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/user/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}

}
/*//Get
https://reqres.in/api/users/2
	//Post
	https://reqres.in/api/api/users
	{
	    "name": "morpheus",
	    "job": "leader"
	}
//Put
https://reqres.in/api//api/users/2
	
{
    "name": "morpheus",
    "job": "zion resident"
}
//delete
https://reqres.in/api/users/userid
	204*/