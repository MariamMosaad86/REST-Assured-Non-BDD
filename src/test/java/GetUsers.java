import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetUsers {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Users";
        RequestSpecification request = RestAssured.given();
        Response response = request.get();
        response.prettyPrint();

        JsonPath path = response.jsonPath();
        String firstId = path.getString("[0].id");
        String firstUserName=path.getString("[0].userName");

        Assert.assertEquals(firstId, "1");
        Assert.assertEquals(firstUserName,"User 1");


    }
}
