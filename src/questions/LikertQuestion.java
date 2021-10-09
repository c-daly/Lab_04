package questions;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Represents a question that solicits an answer in
 * the form of a 5-point scale.
 */
public class LikertQuestion extends AbstractQuestion {
  private final String questionText;
  private final int numOptions = 5;

  /**
   * Constructs the likert question according to the params.
   *
   * @param questionText the text of the question
   */
  public LikertQuestion(String questionText) {
    super(questionText);
  }

  @Override
  public String answer(String answer) {
    int ans = Integer.valueOf(answer);

    // Define this in config
    if (ans > 0 && ans <= numOptions) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  @Override
  public String getText() {
    return questionText;
  }


  @Override
  public int compareTo(Question o) {
    if (o instanceof LikertQuestion) {
      return questionText.compareTo(((LikertQuestion) o).questionText);
    } else {
      return 1;
    }
  }
}
