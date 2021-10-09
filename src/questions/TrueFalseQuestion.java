package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TrueFalseQuestion extends AbstractAnsweredQuestion {
  String questionText;
  String answer;
  List<String> options = Arrays.asList(new String[] { "true", "false"});

  public TrueFalseQuestion(String questionText, String answer) {
    super(questionText, TrueFalseQuestion.getTFOptions(), answer);
  }

  @Override
  public String answer(String answer) {
    return this.answer == answer ? CORRECT : INCORRECT;
  }

  @Override
  public String getText() {
    return this.questionText;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof TrueFalseQuestion) {
      return questionText.compareTo(((TrueFalseQuestion) o).questionText);
    } else {
      return -1;
    }
  }

  // Is the answer one of the options? Is the question text valid?
  private boolean validateQuestionInput() {
    // Can't really perform nlp analysis to verify it's a well-formed
    // question, so we'll just make sure the string is not null or empty
    // and the answer is one of the options
    return !questionText.isBlank()
        && answer.trim().toLowerCase() == "true"
        || answer.trim().toLowerCase() == "false";
  }

  private static List<String> getTFOptions() {
    return Arrays.asList(new String[] { "true", "false"});
  }
}
