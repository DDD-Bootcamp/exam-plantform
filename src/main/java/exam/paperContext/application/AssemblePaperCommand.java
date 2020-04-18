package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<Quiz> quizzes;

    @Value
    public static class Quiz {
        private String quizId;
        private int score;
    }
}