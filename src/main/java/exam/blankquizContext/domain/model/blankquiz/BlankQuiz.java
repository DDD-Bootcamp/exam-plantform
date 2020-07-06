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

  private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
    this.blankQuizId = blankQuizId;
    this.teacherId = teacherId;
    this.content = content;
    this.referenceAnswer = referenceAnswer;
    this.score = score;
  }

  public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
    if (score <= 0 || score > 100) {
      throw new IllegalBlankQuizScoreException(score);
    }
    BlankQuiz blankQuiz = new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score);
    blankQuiz.setCreatedTime(LocalDateTime.now());
    return blankQuiz;
  }


  public BlankQuiz revise(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
    if (score <= 0 || score > 100) {
      throw new IllegalBlankQuizScoreException(score);
    }

    this.blankQuizId = blankQuizId;
    this.teacherId = teacherId;
    this.content = content;
    this.referenceAnswer = referenceAnswer;
    this.score = score;

    this.setUpdatedTime(LocalDateTime.now());
    return this;
  }

  public BlankQuizId getBlankQuizId() {
    return blankQuizId;
  }

  public int getScore() {
    return score;
  }

  private void setCreatedTime(LocalDateTime createdTime) {
    this.createdTime = createdTime;
  }

  private void setUpdatedTime(LocalDateTime updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public boolean sameIdentityAs(BlankQuiz other) {
    return other.blankQuizId == this.blankQuizId;
  }
}
