package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPI {

	@Test(groups = "positiveScenario")
	public void testGetAPI() {
		String endPoint = "library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI";
		RestAssured.baseURI = "https://developer.apple.com/";
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "application/json");
		request.header("Content-Type", "application/json");
		Response response = request.get(endPoint);
		System.out.println(response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(groups = "negativeScenarioFor404")
	public void testGetAPINegative() {
		String endPoint = "library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI1";
		RestAssured.baseURI = "https://developer.apple.com/";
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "application/json");
		request.header("Content-Type", "application/json");
		Response response = request.get(endPoint);
		System.out.println(response.asString());
		Assert.assertEquals(response.getStatusCode(), 404);
	}

	@Test(groups = "negativeScenarioFor403")
	public void testGetAPINoContent() {
		String endPoint = "library/archive/documentation/AudioVideo/Conceptual";
		RestAssured.baseURI = "https://developer.apple.com/";
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "application/json");
		request.header("Content-Type", "application/json");
		Response response = request.get(endPoint);
		System.out.println(response.asString());
		Assert.assertEquals(response.getStatusCode(), 403);
	}
}
