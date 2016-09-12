package edu.csumb.cst438fa16.QuestionsAnswers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionsAnswersTest {
	QuestionsAnswers questions;

	@Before
	public void initizlize(){
	// Testing the put function
	questions = new QuestionsAnswers();
	}

	@Test
	public void testingPut() {

		// Testing if empty values entered
		questions.put("", "");
		assertEquals("NULL", questions.getRandomQuestion());

		questions.put("What is 3 + 5", "8");

		assertEquals("What is 3 + 5", questions.getRandomQuestion());
		assertEquals(true, questions.testAnswer("What is 3 + 5",  "8"));
	}

	@Test
	public void testingAnswer(){

		String question1 = "What color is the sun";
	    String question2 = "What company is named after a fruit";
	    String question3 = "What color are flamingo's feathurs?";
	    String answer1 = "yellow";
	    String answer2 = "apple";
	    String answer3 = "pink";
	    questions.put(question1, answer1);
	    questions.put(question2, answer2);
	    questions.put(question3, answer3);

		assertEquals(false, questions.testAnswer(question1, answer2));
		assertEquals(true, questions.testAnswer(question2, answer2));
		assertEquals(false, questions.testAnswer(question3, ""));
	}

}
