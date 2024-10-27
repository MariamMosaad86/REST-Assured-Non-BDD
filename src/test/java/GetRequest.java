import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class GetRequest {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/api/users/2";
        RequestSpecification request = RestAssured.given();
        Response response = request.get();
        response.prettyPrint();

/*
       Response response1= RestAssured.given().baseUri("https://reqres.in/api/users/2").when().get();
        response1.prettyPrint();
        response1.then().statusCode(200).and().statusLine("HTTP/1.1 200 OK")
                .and().body("data.id[0]", Matchers.equalTo(2));
*/
    }
}
