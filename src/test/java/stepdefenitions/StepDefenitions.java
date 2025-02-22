package stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefenitions {

    // Given A list of item are available 
    // When I add item to list  
    // Then The item is available 

@Given("A list of Product are available")
public void getAllProducts() {
    System.out.println("getAllProducts");

    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .when()                        
                        .get("objects");  
    System.out.println("getAllProducts" + response.asPrettyString());
    
}

@When("I add Product to list")
public void addProduct() {
    String json = "{"
    + "\"name\": \"Apple MacBook Pro 16\","
    + "\"data\": {"
    + "   \"year\": 2019,"
    + "   \"price\": 1849.99,"
    + "   \"CPU model\": \"Intel Core i9\","
    + "   \"Hard disk size\": \"1 TB\""
    + " }"
    + "}";

    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();    
    Response response = requestSpecification
                        .log()    
                        .all()
                        .pathParam("path", "objects")    
                        .pathParam("method", "add")
                        .body(json)
                        .contentType("application/json")
                        .when()                        
                        .post("{path}/{method}");  
    System.out.println("addProduct " + response.asPrettyString());

    
}

@Then("The Product is available")
public void getProduct() {

    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .pathParam("id", 6)
                        .pathParam("path", "objects")
                        .when()                        
                        .get("{path}/{id}");  
    System.out.println("getProduct" + response.asPrettyString());

}

}


