package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {

	@Test
	public void test1() {
		
		Map<String, Object> MapObj = new HashMap<String, Object>();
		
		MapObj.put("name", "Kunal");
		MapObj.put("salary", "20000");
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.when()
					.post("employees/create")
					.then()
					.log()
					.all()
					.statusCode(201)
					.body("name", Matchers.equalTo("Kunal"));		
	}
	
	@Test
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.when()
					.get("employees")
					.then()
					.log()
					.all()
					.statusCode(200);		
	}
	
	@Test
	public void test3() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.when()
					.get("employees/1")
					.then()
					.log()
					.all()
					.statusCode(200)
					.body("name", Matchers.equalTo("Pankaj"));		
	}
	
	@Test
	public void test4() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.when()
					.get("employees")
					.then()
					.log()
					.all()
					.statusCode(200)
					.body("[1].name", Matchers.equalTo("David"));		
	}
}
