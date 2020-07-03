package exam.blankquizContext.domain.model.blankquiz;

import exam.shared.ValueObject;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BlankQuizId implements ValueObject<BlankQuizId> {
  private String id;

  @Override
  public boolean sameValueAs(BlankQuizId other) {
    return other.id.equals(this.id);
  }
}
