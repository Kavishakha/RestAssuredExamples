package restAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void test1() throws IOException {
		
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		
		Map<String,Object> MapObj = new HashMap<String,Object>();
		
		MapObj.put("name", "Saritha");
		MapObj.put("salary", "8300");
		
		Response response = request
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(MapObj)
							.put("employees/4");
		
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(200, responseCode);
	}
}
