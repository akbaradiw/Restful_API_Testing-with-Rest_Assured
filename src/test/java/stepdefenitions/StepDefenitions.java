package stepdefenitions;

import java.util.Map;

import org.testng.Assert;

import com.example.model.ResponseItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.DataRequest;

public class StepDefenitions {

    // Given A list of item are available 
    // When I add item to list  
    // Then The item is available 

ResponseItem responseItem;
String json;
DataRequest dataRequest;

 // non outline 
@Given("A list of item are available")
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

    JsonPath addJsonPath = response.jsonPath();
    responseItem = addJsonPath.getObject("", ResponseItem.class);

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem .name,"Apple AirPods");
    
}

@When("I add item to list {string}")    
public void addProducts (String payload) throws  JsonMappingException, JsonProcessingException {
    dataRequest = new DataRequest();
 for(Map.Entry<String, String> entry : dataRequest.addItem().entrySet()){
            if (entry.getKey().equals(payload)) {
                json = entry.getValue();
                break;
            }
        }

        
System.out.println("Add Objects " + response.asPrettyString());    

JsonPath addJsonPath = response.jsonPath();

responseItem = addJsonPath.getObject("", ResponseItem.class);
}


// non outline

@Then("The item is available")
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

    JsonPath addJsonPath = response.jsonPath();
    responseItem = addJsonPath.getObject("", ResponseItem.class);

    
    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"Apple AirPods");
    Assert.assertEquals(responseItem.data.generation, "3rd");
    Assert.assertEquals(responseItem.data.price, 120);

} 
}


