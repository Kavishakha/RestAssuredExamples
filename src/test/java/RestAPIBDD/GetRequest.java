package RestAPIBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {

	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.when()
					.get("employees")
					.then()
					.log()
					.all()
					.statusCode(200);	
	}
}

