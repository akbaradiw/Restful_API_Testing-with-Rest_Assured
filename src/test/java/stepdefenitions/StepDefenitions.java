package stepdefenitions;

import java.util.Map;

import org.testng.Assert;

import com.example.model.ResponseItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import apiengine.Assertions;
import apiengine.Endpoints;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import resources.DataRequest;

public class StepDefenitions {

    // Given A list of item are available 
    // When I add item to list  
    // Then The item is available 

ResponseItem responseItem;
String json;
DataRequest dataRequest;
Endpoints endpoints;
Assertions assertions;

@BeforeStep
public void beforeStep() {
    responseItem = new ResponseItem();
    assertions = new Assertions();
}

 // non outline 
@Given("A list of item are available")
public void getAllProducts() {
    System.out.println("getAllProducts");

    endpoints = new Endpoints();
    Response response = endpoints.getAllProducts("objects");


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

endpoints = new Endpoints();
Response response = endpoints.addProduct("objects", json, "add");        
        
Assert.assertEquals(response.statusCode(), 200);
assertions.assertAddProduct(responseItem);

}


// non outline

@Then("The item is available")
public void getProduct( ) {

endpoints = new Endpoints();
Response response = endpoints.getProduct("objects", "6");
    Assert.assertEquals(response.statusCode(), 200);
    assertions.getProduct(responseItem);

} 
}


