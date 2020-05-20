import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response =
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body(PayLoad.addPlace()).
                when().post("maps/api/place/add/json").
                then().assertThat().statusCode(200).body("scope", equalTo("APP")).
                header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");

        System.out.println(placeId);
        // Add place -> update place with new address -> get place to validate new address
        String newAddress = "70 New St, USA";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body("{\n" +
                        "\t\"place_id\": \""+placeId+"\",\n" +
                        "\t\"address\": \"70 New St, USA\",\n" +
                        "\t\"key\": \"qaclick123\"\n" +
                        "}").
        when().put("maps/api/place/update/json").
        then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // Get new address
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(getPlaceResponse);
        String actualAddress = js1.getString("address");

        System.out.println(actualAddress);
        // add new assertion to check compare assertions
        Assert.assertEquals(actualAddress,newAddress);

    }
}
