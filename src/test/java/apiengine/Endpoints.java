package apiengine;

import com.example.constant.Constant;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
RequestSpecification requestSpecification; 

public Endpoints() {
            RestAssured.baseURI = Constant.BASE_URL;
        requestSpecification = RestAssured
                                .given();
}



    public Response  getAllProducts(String path ) {
    Response response = requestSpecification
                        .log()
                        .all()
                        .when()                        
                        .get("objects"); 
    return response;                     

}  

public Response addProduct(String path, String json, String method)  {
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

public Response getProduct (String path, String id) {
   Response response = requestSpecification
                        .log()
                        .all()
                        .pathParam("id", "6")
                        .pathParam("path", "objects")
                        .when()                        
                        .get("{path}/{id}");  
    return response;

  
}



}
