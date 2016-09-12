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

		String question = "Name all the planets in the solar system";
		questions.put(question, "Mercury");
		questions.put(question, "Venus");
		questions.put(question, "Earth");
		questions.put(question, "Mars");
		questions.put(question, "Jupiter");
		questions.put(question, "Saturn");
		questions.put(question, "Uranus");
		questions.put(question, "Neptune");


		assertEquals(false, questions.testAnswer(question, "Pluto"));
		assertEquals(true, questions.testAnswer(question, "Mercury"));
		assertEquals(false, questions.testAnswer(question, ""));
	}

}
