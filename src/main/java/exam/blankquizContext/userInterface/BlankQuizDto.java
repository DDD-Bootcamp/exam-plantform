package exam.blankquizContext.userInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String blankQuizId;

    public static BlankQuizDto from(final String blankQuizId) {
        return new BlankQuizDto(blankQuizId);
    }
}
