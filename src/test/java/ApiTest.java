import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


public class ApiTest {
    @Test
    public void check_ApiStatus() {
        given().
                when().
                get("https://api.myjson.com/bins/n8jcu").
                then().
                statusCode(200);
    }

    //check the structure of the json for the given endpoint
    //(check that all the keys are in the response: id, name, full name, owner, etc…)
    @Test
    public void check_Structure() {
        given().
                when().
                get("https://api.myjson.com/bins/n8jcu").
                then().
                assertThat().
                body("",hasKey("id"))
                .body("", hasKey("name"))
                .body("", hasKey("full_name"))
                .body("", hasKey("owner"));
    }

    //check for the presence of the word “metrolab” in the field “owner->login”
    @Test
    public void check_OwnerLogin() {
        given().
                when().
                get("https://api.myjson.com/bins/n8jcu").
                then().
                assertThat().
                body("owner",hasEntry("login","metrolab"));
    }

    @Test
    public void test_FailedOnPurpose() {
        given().
                when().
                get("https://api.myjson.com/bins/n8jcu").
                then().
                assertThat().
                body("",hasKey("failing attribute"));
    }
}
