package questions;

import java.util.List;

public class MultipleChoiceQuestion extends AbstractAnsweredQuestion {
  public MultipleChoiceQuestion(String questionText, List<String> options,
                                String answer) throws IllegalArgumentException {
    super(questionText, options, answer);

    if (options.size() < 4) {
      throw new IllegalArgumentException("At least 3 options required for multiple choice questions");
    }
    if (answer.split(" ").length > 1) {
      throw new IllegalArgumentException("Only one answer allowed for multiple choice questions");
    }
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof MultipleChoiceQuestion) {
      return questionText.compareTo(((MultipleChoiceQuestion) o).questionText);
    } else if (o instanceof TrueFalseQuestion) {
      return 1;
    } else {
      return -1;
    }
  }
}
