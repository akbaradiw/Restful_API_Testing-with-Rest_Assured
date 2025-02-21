package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.model.ResponseItem;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidationTest {

 ResponseItem responseItem;



@Test
public void addObjects(){

    String json = "{\n" + //
    "   \"name\": \"Test\",\n" + //
    "   \"data\": {\n" + //
    "      \"year\": 2019,\n" + //
    "      \"price\": 2049,\n" + //
    "      \"CPU model\": \"Intel Core i9\",\n" + //
    "      \"Hard disk size\": \"1 TB\"\n" + //
    "   }\n" + //
    "}";

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
                        
    System.out.println("Add Objects " + response.asPrettyString());    
    
    JsonPath addJsonPath = response.jsonPath();

    responseItem = addJsonPath.getObject("", ResponseItem.class);


    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"Test");
    Assert.assertNotNull(responseItem.id);
    Assert.assertNotNull(responseItem.createdAt);
    Assert.assertEquals(responseItem.dataItem.year, 2019);
    Assert.assertEquals(responseItem.dataItem.price, 2049);
    Assert.assertEquals(responseItem.dataItem.cpuModel, "Intel Core i9");
    Assert.assertEquals(responseItem.dataItem.hardDiskSize, "1 TB");
}

@Test
public void getSingleObjects(){
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
                        
    System.out.println("Single Objects " + response.asPrettyString());    
    
    JsonPath addJsonPath = response.jsonPath();

     responseItem = addJsonPath.getObject("", ResponseItem.class);


    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"Apple AirPods");
    Assert.assertEquals(responseItem.dataItem.generation, "3rd");
    Assert.assertEquals(responseItem.dataItem.price, 120);  

   

}

@Test
public void getListObjects() {
    int[] ids = {6, 7, 8}; 

    RestAssured.baseURI = "https://api.restful-api.dev";

    for (int id : ids) {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                .log().all()
                .pathParam("id", id)
                .when()
                .get("objects/{id}");

        System.out.println("Object with ID " + id + ": " + response.asPrettyString());

        JsonPath addJsonPath = response.jsonPath();

        responseItem = addJsonPath.getObject("", ResponseItem.class);

        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println("Retrieved object name: " + responseItem.name);

        // Jika hanya ingin memeriksa objek "Apple AirPods", pastikan ID-nya benar
        if (responseItem.name.equals("Apple AirPods")) {
            Assert.assertEquals(responseItem.dataItem.generation, "3rd");
            Assert.assertEquals(responseItem.dataItem.price, 120);
        }
        if (responseItem.name.equals("Macbook Air")) {
            Assert.assertEquals(responseItem.dataItem.generation, "13");
            Assert.assertEquals(responseItem.dataItem.price, 1200);
        }

    if (responseItem.name.equals("Apple Watch Series 8")) {
            Assert.assertEquals(responseItem.dataItem.generation, "8");
            Assert.assertEquals(responseItem.dataItem.price, 1200);
        }
    }
}

@Test
public void getAllObjects(){
    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .when()                        
                        .get("objects");  
                        
    System.out.println("All Objects " + response.asPrettyString()); 
    
    JsonPath addJsonPath = response.jsonPath();

    responseItem = addJsonPath.getObject("", ResponseItem.class);
     

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem .name,"Apple AirPods");

}

@Test
public void updateObjects(){

    String json = "{\n"
    + "\"name\": \"Singkong MacBook Pro 16\",\n"
    + "\"data\": {"
    + "   \"year\": 2219,\n"
    + "   \"price\": 1249.99,\n"
    + "   \"CPU model\": \"Ontel Core i9\",\n"
    + "   \"Hard disk size\": \"2 TB\"\n"
    + " }"
    + "}";


    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .pathParam("path", "objects")
                        .pathParam("id", "7")
                        .body(json)
                        .contentType("application/json")
                        .when()                        
                        .put("{path}/{id}");  
                        
    System.out.println("Update " + response.asPrettyString());  
    JsonPath addJsonPath = response.jsonPath();

    responseItem = addJsonPath.getObject("", ResponseItem.class);


    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"Singkong MacBook Pro 16");
    Assert.assertEquals(responseItem.dataItem.year, 2219);
    Assert.assertEquals(responseItem.dataItem.price, 1249.99);
    Assert.assertEquals(responseItem.dataItem.cpuModel, "Ontel Core i9");
    Assert.assertEquals(responseItem.dataItem.hardDiskSize, "2 TB");
       
}

@Test
public void partiallyUpdateObjects(){

    String json = "{\n"
    + "  \"name\": \"Singkong MacBook Pro 16\"\n"
    + "}";


    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .pathParam("path", "objects")
                        .pathParam("id", "7")
                        .body(json)
                        .contentType("application/json")
                        .when()                        
                        .patch("{path}/{id}");  
                        
    System.out.println("Partially Update Objects " + response.asPrettyString());
    JsonPath addJsonPath = response.jsonPath();

    responseItem = addJsonPath.getObject("", ResponseItem.class);

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"Singkong MacBook Pro 16");                    
}

@Test
public void deleteObjects(){

    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()                        
                        .all()
                        .pathParam("path", "objects")
                        .pathParam("id", "7")
                        .when()                        
                        .delete("{path}/{id}");  
                        
    System.out.println("Delete Objects " + response.asPrettyString());
  JsonPath addJsonPath = response.jsonPath();

     responseItem = addJsonPath.getObject("", ResponseItem.class);

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseItem.name,"");


}

}


