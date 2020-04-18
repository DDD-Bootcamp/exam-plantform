package exam.paperContext.domain.model.paper;

import exam.paperContext.domain.shared.ValueObject;
import lombok.Getter;

import java.util.Objects;

@Getter
public class BlankQuiz implements ValueObject<BlankQuiz> {
    private String quizId;
    private int score;

    public BlankQuiz(String quizId, int score) {
        if(score > 100) {
            throw new IllegalScoreException(score);
        }
        this.quizId = quizId;
        this.score = score;
    }

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
