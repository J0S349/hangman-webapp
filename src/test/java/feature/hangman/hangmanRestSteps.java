package feature.hangman;

/**
 * Created by Peeps on 9/28/16.
 */

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.xpath.operations.String;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import edu.csumb.cst438fa16.hangman.rest.HangmanResource;
public class hangmanRestSteps extends JerseyTest {

    Response response;

    @Override
    protected Application configure() {
        return new ResourceConfig(HangmanResource.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @When("^When I call the start endpoint$")
    public void iCallTheStartEndpoint(String endpoint) throws Throwable {

        WebTarget webTarget = target("start");
        response = webTarget.request().get();
    }

    // This will test whether we get back the '...' after we started
    @Then("^Then the result of start endpoint should be \'([^\']*)\'$")
    public void testingExpectedOuput(String output){
        WebTarget webTarget = target("start");
        String thestart = webTarget.request().get(String.class);
        assertThat(thestart, equalTo(output));
    }

    @When("^When I call the match endpoint with \'([^\']*)\'$")
    public void testingMatchWithNoInput(String input){
        WebTarget webTarget = target("match").queryParam("oldPattern", "...")
                .queryParam("oldGuesses", "")
                .queryParam("newGuesses", input);
        response = webTarget.request().get();
    }

    @Then("^Then the result of match endpoint should be \'([^\']*)\'$")
    public void testingMatchWithInput(String expectedResult){
        assertThat(response.readEntity(String.class), equalTo(expectedResult));
    }

}
