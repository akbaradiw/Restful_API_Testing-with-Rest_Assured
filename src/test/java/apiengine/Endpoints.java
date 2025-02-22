package apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
RequestSpecification requestSpecification; 


    public Response  getAllProducts(String path ) {
 RestAssured.baseURI = "https://api.restful-api.dev";
    requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .when()                        
                        .get("objects"); 
    return response;                     

}  

public Response addProduct(String path, String json, String method) { {

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
        return response;

}

  
}


}
