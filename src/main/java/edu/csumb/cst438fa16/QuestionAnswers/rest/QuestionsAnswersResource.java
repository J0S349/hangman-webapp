package edu.csumb.cst438fa16.QuestionAnswers.rest;

import edu.csumb.cst438fa16.QuestionsAnswers.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *  QuestionAnswers REST service
 *
 */

@Path("")
public class QuestionsAnswersResource{

    // Create QuestionsAnswers object
    QuestionsAnswers object = new QuestionsAnswers();
    
    // This will allow us to set the values in for the string
    public QuestionsAnswersResource(){
    

    // Add 3 questions and answers
    String question1 = "What color is the sun?";
    String question2 = "What company is named after a fruit?";
    String question3 = "What color are flamingo's feathers?";
    String answer1 = "yellow";
    String answer2 = "apple";
    String answer3 = "pink";
    object.put(question1, answer1);
    object.put(question2, answer2);
    object.put(question3, answer3);
    
  }
    
    @GET
    @Path("/randomquestion")
    public String randomQuestion(){
        return object.getRandomQuestion();
    }

    @GET
    @Path("/testanswer")
    public Response testAnswer(
        @QueryParam("question") String question,
        @QueryParam("answer") String answer
    ) {
        // checking to make sure we have information
        if(question == null || answer == null){
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("requires query parameters " +
                        "question, answer").build();
        }

        if(object.testAnswer(question, answer) == true)
        {
            return Response.ok("This is a valid question and answer").build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity("Question and answer doesn't match").build();
    }

}
