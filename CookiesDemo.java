package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CookiesDemo {
	//@Test(priority=1)
	//sample testgggg okkkk
	void testCookies()
	{
		given()
		
		.when()
		  .get("https://www.google.com/")
		.then()
		.cookie("AEC", "AQTF6Hx5JHxKTPa-wO--92BHf8mHsULfpIp6bGW77iNl9FG8v1jcVr9HePo")
		 .log().all();
	}
	@Test(priority=2)
	void getcookiesInfo()
	{
     Response res=	given()
		
		.when()
		    .get("https://www.google.com/");
     
     //Get single cookie info
	       //  String	cookie_value=  res.getCookie("AEC");
	         //System.out.println("Value of cookie is="+cookie_value);
     //Get all cookies info
   Map <String,String> cookie_values=res.getCookies();
   System.out.println(cookie_values.keySet());
   for(String k: cookie_values.keySet())
   {
	   String cookie_value= res.getCookie(k);
	   System.out.println(k + "  "+ cookie_value);
   }
     
		
	}

}
