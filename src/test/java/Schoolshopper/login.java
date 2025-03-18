package Schoolshopper;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class login {
    @Test
    public void login() {
        // Set the base URI for the API

    //baseurl config = new baseurl();
    	   baseurl.setBaseURI();  // Set base URI before making requests
    	
       

        // Define the login payload (credentials)
        String loginPayload = "{ \"mobileNo\": \"9999988554\", \"password\": \"6MKBb\" }";

        // Send POST request with login credentials in the body
        Response response = given()
           .contentType("application/json") // Set Content-Type header to JSON
                .body(loginPayload) // Attach the login payload
                .when()
                .post("rest/userLogin") // Adjust endpoint as per API documentation
                .then()
                .extract().response(); // Extract response
     // Assert status code is 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);

        // Print the status code and response body for debugging
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Extract the name from the response JSON
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("data.employeeName"); // Extract "name" from JSON

        // Print the extracted name
        System.out.println("User Name: " + name);
    }
}
