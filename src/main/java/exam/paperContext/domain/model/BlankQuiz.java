package exam.paperContext.domain.model;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
class BlankQuiz implements ValueObject<BlankQuiz> {
    private QuizId quizId;
    private int score;

    @Override
    public boolean sameValueAs(BlankQuiz other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlankQuiz blankQuiz = (BlankQuiz) o;
        return score == blankQuiz.score &&
                Objects.equals(quizId, blankQuiz.quizId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, score);
    }
}
