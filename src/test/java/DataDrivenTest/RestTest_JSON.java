package DataDrivenTest;

import DataDriven.Data_Driven_Json;
import io.restassured.RestAssured;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest_JSON {
    @Test
    public void validateStatusCode(){
        given().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200);
    }
    @Test
    public void validateData(){
        given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data[0].'id'",equalTo(7)).
                and().assertThat().body("data[0].'email'",equalTo("michael.lawson@reqres.in")) .
                and().assertThat().body("data[0].'first_name'",equalTo("Michael")).
                and().assertThat().body("data[0].'last_name'",equalTo("Lawson")).
                and().assertThat().body("data[0].'avatar'",equalTo("https://reqres.in/img/faces/7-image.jpg"));

    }
    @Test
    public void validInvalidData(){
        String response= RestAssured.get("https://reqres.in/api/users?page=100000000").andReturn().asString();
        Assert.assertTrue(response.contains("contributions towards server costs are appreciated!"));
    }
      @Test(dataProvider = "jsonData")
      public void DataDrivenTest( String id,String email,String Fname , String Lname , String avatar){
        String response=RestAssured.get("https://reqres.in/api/users?page=2").asString();
         Assert.assertTrue(response.contains(id));
         Assert.assertTrue(response.contains(email));
         Assert.assertTrue(response.contains(Fname));
         Assert.assertTrue(response.contains(Lname));
         Assert.assertTrue(response.contains(avatar));

      }
    @Test(dataProvider = "jsonData")
    public void DataDrivenTest2( String id,String email,String Fname , String Lname , String avatar){
        /*given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data[0].'id'",equalTo(id));*/
        given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data[0].'email'",equalTo(email)).
                and().assertThat().body("data[0].'first_name'",equalTo(Fname)).
                and().assertThat().body("data[0].'last_name'",equalTo(Lname)).
                and().assertThat().body("data[0].'avatar'",equalTo(avatar));

    }
    @DataProvider(name="jsonData")
    public Object[][] readData() throws IOException, InvalidFormatException {
        Data_Driven_Json obj=new Data_Driven_Json();
        return obj.readJsonData("ExcelSheet/Data_Driven_Rest_Json.xlsx","Sheet1");
    }
}
