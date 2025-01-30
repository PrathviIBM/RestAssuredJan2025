package handson;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class loginPost {

	@Test
	public void test1() {
		baseURI = "https://demo.testfire.net/api";
		File jsonDataFile = new File("src/test/resources/payloads/postlogin.java");
		
		String var1 =
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonDataFile)
		.when()
		.post("/login")
		.then()
		.extract()
		.path("Authorization");
		
		given()
		.contentType(ContentType.JSON)
		.header("Authorization", var1)
	.when()
		.get("https://demo.testfire.net/api/login")
	.then()
		.assertThat()
		
		.log().all();
	}

}
