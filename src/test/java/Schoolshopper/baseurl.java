package Schoolshopper;

import io.restassured.RestAssured;

public class baseurl {
   // static {
      //  RestAssured.baseURI = "https://shopper.edunext.app/";//use under static or method for static
	//The static block runs once when the class is first loaded, so RestAssured.baseURI is properly initialized.
  //  }
    public static void setBaseURI() {
        RestAssured.baseURI = "https://shopper.edunext.app/";
    }
}
