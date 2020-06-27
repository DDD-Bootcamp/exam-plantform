package exam.blankQuizContext.domain.model.blankQuiz;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
