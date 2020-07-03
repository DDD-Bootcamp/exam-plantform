package exam.blankquizContext.domain.model.blankquiz;

import exam.shared.ValueObject;

public class BlankQuizId implements ValueObject<BlankQuizId> {
  private String id;

  @Override
  public boolean sameValueAs(BlankQuizId other) {
    return false;
  }
}
