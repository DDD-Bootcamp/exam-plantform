package exam.blankquizContext.domain.model.blankquiz;

import exam.shared.ValueObject;
import java.util.UUID;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BlankQuizId implements ValueObject<BlankQuizId> {
  private String id;

  public BlankQuizId(String id) {
    this.id = id;
  }

  public static BlankQuizId nextBlankQuizId() {
    return new BlankQuizId(UUID.randomUUID().toString());
  }

  @Override
  public boolean sameValueAs(BlankQuizId other) {
    return other.id.equals(this.id);
  }
}
