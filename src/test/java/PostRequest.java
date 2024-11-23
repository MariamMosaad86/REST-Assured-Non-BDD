import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PostRequest {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification request = RestAssured.given();
        request.body("{\"name\": \"morpheus\",\"job\": \"leader\"}");
        request.header("Content-Type", "application/json");

        Response response = request.post();
        response.prettyPrint();

        // Assertions using then():
        response.then().statusCode(201).and().statusLine("HTTP/1.1 201 Created");


        // Assertions using TestNG framework:
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();
        long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);


        Assert.assertEquals(statusCode, 201);
        Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
        Assert.assertTrue(responseTime < 3000);

        // JsonPath
        JsonPath path = response.jsonPath();

        String id = path.getString("id");
        System.out.println("ID is : " + id);

        String name = path.getString("name");
        Assert.assertEquals(name,"morpheus");

    }
}
