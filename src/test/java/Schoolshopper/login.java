package Schoolshopper;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class login {

    @Test
    public void login() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://master.d3m3cfa2mnany2.amplifyapp.com/";

        // Define the login payload (credentials)
        String loginPayload = "{ \"mobileNo\": \"9999988554\", \"password\": \"6MKBb\" }";

        // Send POST request with login credentials in the body
        Response response = given()
                .contentType("application/json") // Ensure we set Content-Type header to JSON
                .body(loginPayload)             // Attach the login payload as the body
                .when()
                .post("login")                  // Correct endpoint (adjust as per API docs)
                .then()
                .extract().response();         // Extract the response

        // Print the status code and response body for debugging
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Check if the response is HTML (not JSON)
        String responseBody = response.getBody().asString();
        if (responseBody.contains("<html>")) {
            System.out.println("Received HTML response instead of JSON. It could be an error page.");
        } else {
            // Extract the employee name from the response JSON (assuming the response is JSON)
            String name = response.jsonPath().getString("data.employeeName");
            System.out.println("Extracted Name: " + name);
        }

        // Assert that the login was successful by checking the status code
        assert response.getStatusCode() == 200 : "Login failed!";
    }
}
