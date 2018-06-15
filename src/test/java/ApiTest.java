import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
    @Test
    public void test_LoginHasMetrolab() {
        given().
                when().
                get("https://api.github.com/repos/metrolab/SingleDateAndTimePicker").
                then().
                body(containsString("metrolab"));
    }
}
