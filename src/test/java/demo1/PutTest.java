package demo1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class PutTest {
	@Test
	public void test1() {
		//String Root_URI = "https://petstore.swagger.io/v2";
		baseURI = "https://petstore.swagger.io/v2";
		File jsonDataFile = new File("src/test/resources/payloads/Example2.java");
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonDataFile)
		.when()
			//.post(Root_URI+"/pet")
		.put("/pet")
		.then()
		.log().all()
			.statusCode(200);
			
	}
}
