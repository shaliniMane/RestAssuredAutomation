package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PathandQueryParameter {
//https://reqres.in/api/users?page=2&id=2
	@Test
	void testQuertAndPathParameters()
	{
		given()
		  .pathParam("mypath", "users")
		  .queryParam("page", 2)
		  .queryParam("id", 5)
		  
		.when()
		   .get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
