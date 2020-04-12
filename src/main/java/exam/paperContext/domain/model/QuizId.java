package exam.paperContext.domain.model;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
class QuizId implements ValueObject<QuizId> {
    private String id;

    @Override
    public boolean sameValueAs(QuizId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizId quizId = (QuizId) o;
        return Objects.equals(id, quizId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
