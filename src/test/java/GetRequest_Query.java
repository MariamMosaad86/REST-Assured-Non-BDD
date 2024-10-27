import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetRequest_Query {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification request = RestAssured.given();
        request.queryParam("page", "2");

        Response response = request.get();
        response.prettyPrint();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        JsonPath path = response.jsonPath();
        String firstName = path.getString("data.first_name[0]");
        int firstId=path.getInt("data.id[0]");
        String url=path.getString("support.url");


        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(firstName, "Michael");
        Assert.assertEquals(firstId,7);
        Assert.assertEquals(url,"https://reqres.in/#support-heading");



    }
}
