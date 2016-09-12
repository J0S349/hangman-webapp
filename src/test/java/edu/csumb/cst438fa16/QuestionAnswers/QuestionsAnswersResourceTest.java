package edu.csumb.cst438fa16.QuestionAnswers;
//package edu.csumb.cst438fa16.QuestionsAnswers.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.*;

import edu.csumb.cst438fa16.QuestionAnswers.rest.QuestionsAnswersResource;
import edu.csumb.cst438fa16.QuestionsAnswers.QuestionsAnswers;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * See:
 * https://jersey.java.net/documentation/latest/test-framework.html
 * https://jersey.java.net/apidocs/latest/jersey/index.html
 */
public class QuestionsAnswersResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(QuestionsAnswersResource.class);
      }

    
      // create the object here to be used across the Junit test
      QuestionsAnswers object = new QuestionsAnswers();


    @Test
    public void testingRandomQuestion(){
		String question1 = "What color is the sun?";
		String question2 = "What company is named after a fruit?";
		String question3 = "What color are flamingo's feathers?";
		
      WebTarget webTarget = target("randomquestion");
      
      String question = webTarget.request().get(String.class).toString();      
      // Testing to see what question we get
      assertThat(question, anyOf(is(question1), is(question2), is(question3)));
    }
    
    @Test
    public void testingTestAnswerWithoutParams(){
    	WebTarget webTarget = target("testanswer"); 
    	Response response = webTarget.request().get();
    	assertThat(response.getStatus(),
                equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }
    
    @Test
    public void testingTestAnswerWithWrongAnswerParam(){
		String question1 = "What color is the sun?";

    	WebTarget webTarget = target("testanswer").queryParam("question", question1)
    											  .queryParam("answer", "green"); 
    	Response response = webTarget.request().get(); 
    	assertThat(response.getStatus(),
                equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }
    
    @Test
    public void testingTestAnswerWithWrongQuestionParam(){
    	WebTarget webTarget = target("testanswer").queryParam("question", "What year we in")
    											  .queryParam("answer", "2016"); 
    	Response response = webTarget.request().get(); 
    	assertThat(response.getStatus(),
                equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }
    
    @Test
    public void testingTestAnswerWithNoAnswerParam(){
    	WebTarget webTarget = target("testanswer").queryParam("question", "What color is the sun?")
    											  .queryParam("answer", ""); 
    	Response response = webTarget.request().get(); 
    	assertThat(response.getStatus(),
                equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }
    
    @Test 
    public void testingTestAnswerWithCorrectParams(){
    	WebTarget webTarget = target("testanswer").queryParam("question", "What color is the sun?")
    											  .queryParam("answer",  "yellow"); 
    	String testingAnswer = webTarget.request().get(String.class); 
    	assertThat(testingAnswer, equalTo("This is a valid question and answer")); 
    }
}
