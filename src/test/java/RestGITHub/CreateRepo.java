package RestGITHub;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {

	@Test
	public void test1() {
		
		File file1 = new File("file1.json");
		
		RestAssured.given()
					.baseUri("https://api.github.com")
					.auth()
					.oauth2("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")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(file1)
					.when()
					.post("user/repos")
					.then()
					.log()
					.all()
					.statusCode(201);
					
	}
}
