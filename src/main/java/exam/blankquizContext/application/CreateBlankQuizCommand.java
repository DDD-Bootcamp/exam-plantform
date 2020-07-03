package exam.blankquizContext.application;

import lombok.Getter;

@Getter
public class CreateBlankQuizCommand {

  private String teacherId;
  private String question;
  private Integer score;
  private String referenceAnswer;

}
