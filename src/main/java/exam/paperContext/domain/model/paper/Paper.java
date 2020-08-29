package exam.paperContext.domain.model.paper;

import exam.paperContext.shared.Entity;
import exam.paperContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(of = {"paperId"})
public class Paper implements Entity<Paper> {
    private PaperId paperId;
    private List<BlankQuiz> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    private Paper(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.paperId = paperId;
        this.blankQuizzes = blankQuizzes;
        this.teacherId = teacherId;
        createTime = LocalDateTime.now();
    }

    public static Paper assemble(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        validateQuizzes(blankQuizzes);
        return new Paper(paperId, teacherId, blankQuizzes);
    }

    private static void validateQuizzes(List<BlankQuiz> blankQuizzes) {
        if (blankQuizzes.size() > 20 || blankQuizzes.size() < 5) {
            throw new IllegalQuizzesCountException(blankQuizzes.size());
        }

        int totalScore = blankQuizzes.stream().mapToInt(BlankQuiz::getScore).sum();
        if (totalScore != 100) {
            throw new IllegalScoreException(totalScore);
        }
    }

    public Collection<Object> getQuizzes() {
        return Collections.unmodifiableList(blankQuizzes);
    }

    public PaperId getPaperId() {
        return paperId;
    }

    public String teacherId() {
        return teacherId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    @Override
    public boolean sameIdentityAs(Paper other) {
        return paperId.sameValueAs(other.getPaperId());
    }

    public void reassemble(String teacherId, List<BlankQuiz> blankQuizzes) {
        validateQuizzes(blankQuizzes);
        this.teacherId = teacherId;
        this.blankQuizzes = blankQuizzes;
    }

    @Getter
    @AllArgsConstructor
    public static class BlankQuiz implements ValueObject<BlankQuiz> {
        private String quizId;
        private int score;

        @Override
        public boolean sameValueAs(BlankQuiz other) {
            return false;
        }
    }
}
