package exam.blankquizContext.domain.model.blankquiz;

import exam.shared.Entity;
import java.time.LocalDateTime;

public class BlankQuiz implements Entity<BlankQuiz> {

  private BlankQuizId blankQuizId;
  private String teacherId;
  private String content;
  private String referenceAnswer;
  private int score;
  private LocalDateTime createdTime;
  private LocalDateTime updatedTime;

  private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score, LocalDateTime createdTime, LocalDateTime updatedTime) {
    this.blankQuizId = blankQuizId;
    this.teacherId = teacherId;
    this.content = content;
    this.referenceAnswer = referenceAnswer;
    this.score = score;
    this.createdTime = createdTime;
    this.updatedTime = updatedTime;
  }

  public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score, LocalDateTime createdTime,
                                 LocalDateTime updatedTime) {
    if (score < 0 || score > 100) {
      throw new IllegalBlankQuizScoreException(score);
    }
    return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score, createdTime, updatedTime);
  }


  public  BlankQuiz revise(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score, LocalDateTime createdTime,
                                 LocalDateTime updatedTime) {
    if (score < 0 || score > 100) {
      throw new IllegalBlankQuizScoreException(score);
    }
    return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score, createdTime, updatedTime);
  }

  public static BlankQuiz delete(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score, LocalDateTime createdTime,
                                 LocalDateTime updatedTime) {

    return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score, createdTime, updatedTime);
  }

  public BlankQuizId getBlankQuizId() {
    return blankQuizId;
  }

  @Override
  public boolean sameIdentityAs(BlankQuiz other) {
    return other.blankQuizId == this.blankQuizId;
  }
}
