package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
public class TestBasicAuthentication {
	@Test(priority=1)
	void testBasicauthentication()
	{
		given()
		      .auth().basic("postman", "password")
		.when()
		     .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true))
		   .log().all();
	}

	
		@Test(priority=2)
		void testDigestauthentication()
		{
			given()
			      .auth().digest("postman", "password")
			.when()
			     .get("https://postman-echo.com/basic-auth")
			.then()
			   .statusCode(200)
			   .body("authenticated", equalTo(true))
			   .log().all();
		}
		
			@Test(priority=3)
			void testPreemptiveauthentication()
			{
				given()
				      .auth().preemptive().basic("postman", "password")
				.when()
				     .get("https://postman-echo.com/basic-auth")
				.then()
				   .statusCode(200)
				   .body("authenticated", equalTo(true))
				   .log().all();
			}

			@Test(priority=4)
			void testbearerauthentication()
			{
				String bearertoken="github auth token";
				given()
				      .header("Authorization", "Bearer "+bearertoken)
				.when()
				    .get("https://api.github.com/user/repos")
				.then()
				   .statusCode(200)
				   
				   .log().all();
			}
			//@Test(priority=5)
			void testAuth1authentication() {
				
				given()
				  .auth().oauth("consumerky", "consumerSecrat", "accessToken", "tokenSecrate")
				.when()
				     .get("url")
				.then()
				   .statusCode(200)
				   .log().all();
				
			}
			@Test(priority=6)
			void testAuth2authentication() {
				
				given()
				  .auth().oauth2("githubauth token")
				
				.when()
				   .get("https://api.github.com/user/repos")
				.then()
				 .statusCode(200)
				 .log().all();
				
			}
			
			@Test(priority=7)
			void testAPIKeyAuthentication()
			{
				
			}
}
