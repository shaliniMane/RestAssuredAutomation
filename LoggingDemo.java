package restAssuredAutomation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

public class LoggingDemo {
	@Test(priority=1)
	public void testLogs()

	{
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		//  .log().body();
		//.log().all();
		//.log().cookies();
		.log().headers();
		
		
	}
}
