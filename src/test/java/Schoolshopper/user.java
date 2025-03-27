package Schoolshopper;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class user {

    @Test(enabled=false)
    public void getUser() {
        // Set JWT Token
        String JWT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25JZCI6IjA4MDdiYjU1LTI2YmMtNDU2ZC04ZDRjLWJmYzVhYTYwYTMxMCIsImVtcElkIjoiIiwiaW1hZ2UiOiIiLCJ1c2VyVHlwZSI6IkRlbW8iLCJ1c2VySWQiOiI4Nzk2OGY5Ni1jMGFiLTRlMWItYWQ5Ni1mYzM3MThkYTZjMzUiLCJ1c2VybmFtZSI6ImRlZXBhayIsImlhdCI6MTczODczNTU3MCwiZXhwIjoyMDU0MDk1NTcwfQ.hDrihmC1OiOkUpDC9yQJpuOGDLO10GhvjwDr48vAENvms2micqyWgU9ksqGWNSWCTgukhVvBY9KxsRy1aWjXrg";  // Truncated for security
 String ORG_ID ="91304da4-f6ed-4053-b998-0640b1793ba7";
        // Send GET request and extract response
        Response response = given()
                .log().all()  // Log request details
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + JWT_TOKEN)
                .header("organization_id", ORG_ID)
                  .when()
                .get("https://shopper.edunext.app/rest/shop/addUser")
        .then()
                .log().all()  // Log response details
                .extract().response();

        // Extract response values
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();

        // ✅ Validate HTTP Status Code
        Assert.assertEquals(statusCode, 200, "Expected HTTP status code 200");

        // ✅ Ensure Response Body is Not Empty
        Assert.assertFalse(responseBody.isEmpty(), "Response body should not be empty");

        // ✅ Parse JSON Response
        JsonPath jsonPath = new JsonPath(responseBody);
        if (jsonPath.getInt("status") == 404) {
            Assert.fail("API returned error: " + jsonPath.getString("message"));
        }

       
        // ✅ Log formatted response
        System.out.println("Formatted Response: " + response.prettyPrint());
    }
    @Test
    public void adduser(){
    	String loginPayload1 = "{ \"name\": \"test3\", \"mobileNo\": \"1231231235\", \"emailId\": \"test92@gmail.com\", \"employeeId\": \"4638737\" }";
    	 String JWT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25JZCI6IjA4MDdiYjU1LTI2YmMtNDU2ZC04ZDRjLWJmYzVhYTYwYTMxMCIsImVtcElkIjoiIiwiaW1hZ2UiOiIiLCJ1c2VyVHlwZSI6IkRlbW8iLCJ1c2VySWQiOiI4Nzk2OGY5Ni1jMGFiLTRlMWItYWQ5Ni1mYzM3MThkYTZjMzUiLCJ1c2VybmFtZSI6ImRlZXBhayIsImlhdCI6MTczODczNTU3MCwiZXhwIjoyMDU0MDk1NTcwfQ.hDrihmC1OiOkUpDC9yQJpuOGDLO10GhvjwDr48vAENvms2micqyWgU9ksqGWNSWCTgukhVvBY9KxsRy1aWjXrg";  // Truncated for security
    	 String ORG_ID ="3bc080b5-e702-41f3-9ce2-11b2b02b1b9e"; 
    	 
    	Response response = given()
    			  .contentType("application/json") 
    			  .header("Authorization", "Bearer " + JWT_TOKEN)
                  .header("organization_id", ORG_ID)
    			  
    			  .body(loginPayload1)
                  .when()
                  .post("https://shopper.edunext.app/rest/shop/addUser") // Adjust endpoint as per API documentation
                  .then()
                  .extract().response();
    	   int statusCode = response.getStatusCode();
           Assert.assertEquals(statusCode, 200, "Expected status code 200, but got " + statusCode);
           
           System.out.println("Response Status Code: " + response.getStatusCode());
           System.out.println("Response Body: " + response.getBody().asString());
           System.out.println("Response Headers: " + response.getHeaders().toString());

          
           
           
           
    	
    	   
    	
    	
    }
}
