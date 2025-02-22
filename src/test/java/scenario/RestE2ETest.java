package scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.model.ResponseItem;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestE2ETest {

    ResponseItem responseItem;

    @Test
    public void scenarioE2E() {
        String json = "{\n" +
                "   \"name\": \"Test\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 2049,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        // Base URL
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Add product
        RequestSpecification requestSpecification = given()
                .log().all()
                .pathParam("path", "objects")
                .pathParam("method", "add")
                .body(json)
                .contentType("application/json");

        Response response = requestSpecification
                .when()
                .post("{path}/{method}");

        System.out.println("Add Objects Response: " + response.asPrettyString());

        JsonPath addJsonPath = response.jsonPath();
        responseItem = addJsonPath.getObject("", ResponseItem.class);

        // Validasi response
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(responseItem.name, "Test");
        Assert.assertNotNull(responseItem.id);
        Assert.assertNotNull(responseItem.createdAt);
        Assert.assertEquals(responseItem.data.year, 2019);
        Assert.assertEquals(responseItem.data.price, 2049);
        Assert.assertEquals(responseItem.data.CPUModel, "Intel Core i9");
        Assert.assertEquals(responseItem.data.hardDiskSize, "1 TB");

        String idObject = responseItem.id;

        // Get Product
        Response response2 = given()
                .pathParam("path", "objects")
                .pathParam("id", idObject)
                .log().all()
                .when()
                .get("{path}/{id}");

        System.out.println("Get Object Response: " + response2.asPrettyString());

        Assert.assertEquals(response2.statusCode(), 200);

        // Delete Product
        Response response3 = given()
                .pathParam("path", "objects")
                .pathParam("id", idObject)
                .log().all()
                .when()
                .delete("{path}/{id}");

        System.out.println("Delete Object Response: " + response3.asPrettyString());

        Assert.assertEquals(response3.statusCode(), 200);
    }
}
