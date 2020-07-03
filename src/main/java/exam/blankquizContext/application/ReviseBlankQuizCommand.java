package exam.blankquizContext.application;

import lombok.Getter;

@Getter
public class ReviseBlankQuizCommand {
  private String teacherId;
  private String content;
  private String referenceAnswer;
  private Integer score;
}
