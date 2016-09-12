/**
*	A	half-secretive map of	questions to answers	(at	most	one	answer	per	question).
*	Gives	out	random questions	(keys) from	the	map, and
*	can	be queried	to test	if	a	given	question maps	to a	given	answer.
*/

package edu.csumb.cst438fa16.QuestionsAnswers;
import java.util.*;
public class QuestionsAnswers {
	// make a dictionary that has the question as the key and the answer(s) as the values.
	// The first parameter is a string, the second parameter is a hashset of strings
	HashMap<String, HashSet<String>> questions_answers = new HashMap<String, HashSet<String>>();


	/**
	*	Maps question to answer.
	*/
	public void put(String	question, String answer)	{

		if(question.equals("") || answer.equals(""))
		{
			return;
		}
		// !) if the map is empty, then we can add the first thing
		HashSet<String> answers;
		if(questions_answers.isEmpty()){
			answers = new HashSet<String>();
			answers.add(answer);
			questions_answers.put(question, answers);
			return;
		}
		// 2) check if the questions is already a key in the dictionary

		Set<String> keys = questions_answers.keySet();
		if(keys.contains(question)){
			answers = questions_answers.get(question);

			//check to see whether the answer already exist within the HashSet
			if(!answers.contains(answers)){
				// if it doesn't exist, then we add it
				answers.add(answer);
				questions_answers.put(question, answers);
			}
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

		// Now since we know its a valid answer, we now check to see whether it contains the answer or not

		Set<String> answers = questions_answers.get(question);
		if(answers.contains(answer)){
			return true;
		}
		return false;
	}
	/**
	*	Gives	out	a	random	question	from	the	key	set.
	*/
	public String getRandomQuestion()
	{
		Random rn = new Random();
		Set<String> questions = questions_answers.keySet();
		int num_questions = questions.size();

		if( num_questions != 0){
			int index = rn.nextInt(num_questions);
				String[] inputs = questions.toArray(new String[0]);
				return inputs[index];
		}
		else{
			return "NULL";
		}
	}


}
