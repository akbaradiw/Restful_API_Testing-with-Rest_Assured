package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulApi {

    public static void main(String[] args) {
        getAllObjects();
        getSingleObjects();
        addObjects();
        int[] ids = {3,5,10};
        getListObjects(ids);
        updateObjects();
        partiallyUpdateObjects();
        deleteObjects();

    }

public static void getAllObjects(){
    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .when()                        
                        .get("objects");  
                        
    System.out.println("All Objects " + response.asPrettyString());                    
}


public static void getSingleObjects(){
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
}

public static void getListObjects(int[] ids){
    RestAssured.baseURI = "https://api.restful-api.dev";
    
    for (int id : ids) {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                            .log().all()
                            .pathParam("id", id)
                            .when().get("objects/{id}");  
                            
        System.out.println("Object with ID " + id + ": " + response.asPrettyString());  
    }
}


public static void addObjects(){

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
                        
    System.out.println("Add Objects " + response.asPrettyString());                    
}



public static void updateObjects(){

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
}

public static void partiallyUpdateObjects(){

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
}

public static void deleteObjects(){


    RestAssured.baseURI = "https://api.restful-api.dev";
    RequestSpecification requestSpecification = RestAssured
                                                .given();
    Response response = requestSpecification
                        .log()
                        .all()
                        .pathParam("path", "objects")
                        .pathParam("id", "7")
                        .contentType("application/json")
                        .when()                        
                        .delete("{path}/{id}");  
                        
    System.out.println("Delete Objects " + response.asPrettyString());                    
}





}
