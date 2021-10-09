package questions;

import java.util.List;

public class MultipleSelectQuestion extends AbstractAnsweredQuestion {
  public MultipleSelectQuestion(String questionText, List<String> options,
                                String answer) {
    super(questionText, options, answer);
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof MultipleSelectQuestion) {
      return questionText.compareTo(((MultipleSelectQuestion) o).questionText);
    } else if (o instanceof LikertQuestion) {
      return -1;
    } else {
      return 1;
    }
  }

}
