package restAssuredAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
@Test(priority=1)
	public void testHeaders()
	{
		given()
		
		.when()
		  .get("https://www.google.com/")
		  
		.then()
		    .header("Content-Type", "text/html; charset=ISO-8859-1")
		    .and()
            .header("content-Encoding", "gzip")
            .and()
            .header("Server", "gws")
           
		   .log().all() ;
		   
	}
@Test(priority=2)
public void getßHeaders()
{
	Response res= given()
	
	.when()
	   .get("https://www.google.com/");
	//Get single header value
	String headervalue=res.getHeader("Content-Type");
	System.out.println("The value of content header is: "+ headervalue);
	
	   // Get value of all headers
	Headers myheaders=res.getHeaders();
	
	for(Header hd:myheaders)
	{
		System.out.println(hd.getName()+ "     "+hd.getValue());
	}
	
}
}
