package ua.nik.ECTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SWAPITest {

	@Test (groups = {"api", "all"})
	public void checkThatCountOfPeopleEqualsTo87(){
		when().get("https://swapi.co/api/people/").then().statusCode(200).body("count", equalTo(87));
	}

	@Test (groups = {"api", "all"})
	public void checkThatWeHaveLukeAmongPeople() {
		when().get("https://swapi.co/api/people/").then().statusCode(200).body("results.name", hasItem("Luke Skywalker"));
	}

	@Test (groups = {"api", "all"})
	public void checkThreeFirstPersons() {
		when().get("https://swapi.co/api/people/").then().statusCode(200).body("results.name[0]", equalTo("Luke Skywalker")).body("results.name[1]", equalTo("C-3PO")).body("results.name[2]", equalTo("R2-D2"));
	}
}
