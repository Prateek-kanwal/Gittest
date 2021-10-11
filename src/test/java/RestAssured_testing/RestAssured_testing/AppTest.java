package RestAssured_testing.RestAssured_testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
   //   RestAssured.baseURI ="https://rahulshettyacademy.com";
     // Response rest=get("https://reqres.in/api/users?per_page=20");
    //  System.out.println(rest.getStatusCode());
      //given().queryParam("Key", "test").header("Content-Type","application/json").body("")
      //.when().post("")
      //.then().log().all().assertThat().statusCode(200);
     RestAssured.baseURI ="https://reqres.in";
     /*  Response rest=get("/api/users/2");
    ResponseBody body= rest.body();
      System.out.println(body.asString());
      System.out.println(rest.getStatusCode());
    */  
   // given().when().get("/api/users/2").then().log().all().assertThat().body("data.id", equalTo(2)).header("Server", equalTo("cloudflare"));
      
      String body1=  given().body("{\r\n"
      		+ "    \"name\": \"morpheus\",\r\n"
      		+ "    \"job\": \"leader\"\r\n"
      		+ "}").when().post("/api/users").asString();
      System.out.println(body1);
      
      JsonPath json=new JsonPath(body1);
     System.out.println(json.getString("id")); ;
    }
}
