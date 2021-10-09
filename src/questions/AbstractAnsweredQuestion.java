package questions;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractAnsweredQuestion extends AbstractQuestion {
  private String answerString;
  private Set answerSet;
  private List<String> options;

  public AbstractAnsweredQuestion(String questionText, List<String> options, String answer) {
    super(questionText);
    this.options = options;
    this.answerString = answer;

    Set<String> answerSet = new HashSet<String>();
    String[] splitAnswer = answer.split(" ");

    for (String a : splitAnswer) {
      if(!a.isBlank()) {
        answerSet.add(a.trim().toLowerCase());
      }
    }
  }

  public String answer(String answer) {
    String result = INCORRECT;
    // trying to do as little work as possible
    if (!answer.isBlank()) {
      // or will short-circuit if strings are equal and not create the set
      if (answer == answerString || setifyAnswerString(answer) == answerSet) {
        result = CORRECT;
      }
    }
    return result;
  }


  protected Set setifyAnswerString(String answer) {
    Set<String> providedAnswersSet = new HashSet<String>();
    String[] splitAnswer = answer.split(" ");

    if (!answer.isBlank()) {
      for (String a : splitAnswer) {
        if (!a.isBlank()) {
          providedAnswersSet.add(a.trim().toLowerCase());
        }
      }
    }

    return providedAnswersSet;
  }
}
