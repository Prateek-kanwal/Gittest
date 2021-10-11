package RestAssured_testing.RestAssured_testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RahulshettyAPI {
	
	

@Test
public void post() {
	 RestAssured.baseURI ="https://rahulshettyacademy.com";
	Response Resp =given().queryParam("Key", " qaclick123").body("{\n"
			+ "  \"location\": {\n"
			+ "    \"lat\": -38.383494,\n"
			+ "    \"lng\": 33.427362\n"
			+ "  },\n"
			+ "  \"accuracy\": 50,\n"
			+ "  \"name\": \"Frontline house\",\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\n"
			+ "  \"types\": [\n"
			+ "    \"shoe park\",\n"
			+ "    \"shop\"\n"
			+ "  ],\n"
			+ "  \"website\": \"http://google.com\",\n"
			+ "  \"language\": \"French-IN\"\n"
			+ "}\n"
			+ "\n"
			+ "").when().post("/maps/api/place/add/json");
	
	String Responsestring= Resp.asString();
	JsonPath json=new JsonPath(Responsestring);
	String placeid=json.getString("place_id");
    System.out.println(placeid); 
    
    given().queryParam("Key", "qaclick123").header("Content-Type","application/json").body("{\n"
	  		+ "\"place_id\":\""+placeid+"\",\n"
	  		+ "\"address\":\"70 Summer walk, USA\",\n"
	  		+ "\"key\":\"qaclick123\"\n"
	  		+ "}\n"
	  		+ "").when().put("/maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
  //  System.out.println("Now GET"); 
    
   String body1= given().queryParam("place_id", "1122e1f949c7eec57046941abaa3c9d4").queryParam("key", "qaclick123")
    .header("Content-Type","application/json").when().get("/maps/api/place/get/json").asString();

    JsonPath json1=new JsonPath(body1);
   String accuracy =json1.getString("accuracy"); 
    Assert.assertEquals(accuracy, "51");
    
}	

/* @Test
public void f() {
	  RestAssured.baseURI ="https://rahulshettyacademy.com";
	  given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json").body("{\n"
	  		+ "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n"
	  		+ "\"address\":\"70 Summer walk, USA\",\n"
	  		+ "\"key\":\"qaclick123\"\n"
	  		+ "}\n"
	  		+ "").when().put("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
}

*/
}