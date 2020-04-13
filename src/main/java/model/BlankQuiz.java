package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BlankQuiz {
    private Integer id;

    private String question;

    private String referenceAnswer;

    private Integer score;
}
