package edu.csumb.cst438fa16.QuestionsAnswers;
import java.util.*;
public class QuestionsAnswers {
	// make a dictionary that has the question as the key and the answer(s) as the values.
	// The first parameter is a string, the second parameter is a HashSet of strings
	HashMap<String, String> questions_answers = new HashMap<String, String>();

	/**
	*	Maps question to answer.
	*/
	public void put(String question, String answer)	{

		if(question.equals("") || answer.equals(""))
		{
			return;
		}
		
		// Check to make sure the same questions isn't already in the HashMap
		if(!questions_answers.containsKey(question))
		{
			questions_answers.put(question, answer); 
		}
	}

	/**
	*	Queries	if	question	maps	to	answer.
	*/
	public boolean testAnswer(String question,	String answer)	{
		// Check to see whether the question exist or not
		if(!questions_answers.containsKey(question)){
			return false;
		}
		else {
			return questions_answers.get(question).equalsIgnoreCase(answer); 
		}
	}
	/**
	*	Gives	out	a	random	question	from	the	key	set.
	*/
	public String getRandomQuestion()
	{
		Random rn = new Random();
		int num_questions = questions_answers.size(); 
		
		Set<String> questions = questions_answers.keySet(); 
		String[] array = questions.toArray(new String[0]); 
		if(num_questions > 0){
			int index = rn.nextInt(num_questions); 
			return array[index];
		}
		else{
			return "NULL";
		}
	}
}
