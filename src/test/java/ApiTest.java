import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


public class ApiTest {
    @Test
    public void check_ApiStatus() {
        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                statusCode(200);
    }
    @Test
    public void test_OwnerLogin() {
        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                assertThat().
                body("owner",hasEntry("login","metrolab"));
    }
}
