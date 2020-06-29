package exam.paperContext.application;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<BlankQuiz> quizzes;

    @Value
    public static class BlankQuiz {
        private String quizId;
        private int score;
    }
}