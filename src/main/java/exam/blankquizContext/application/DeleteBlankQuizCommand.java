package exam.blankquizContext.application;

import lombok.Getter;

@Getter
public class DeleteBlankQuizCommand {
  private String blankQuizId;

  public DeleteBlankQuizCommand(String blankQuizId) {
    this.blankQuizId = blankQuizId;
  }
}
