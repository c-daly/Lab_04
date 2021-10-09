package questions;

public abstract class AbstractQuestion implements Question {
  protected String questionText;

  public AbstractQuestion(String questionText) {
    this.questionText = questionText;
  }
}
