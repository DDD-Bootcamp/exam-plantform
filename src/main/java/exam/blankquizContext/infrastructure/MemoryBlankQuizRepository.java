package exam.blankquizContext.infrastructure;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream().filter(blankQuiz-> blankQuiz.getBlankQuizId()
            .equals(blankQuizId))
            .findFirst()
            .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.add(blankQuiz);
    }

    @Override
    public void delete(BlankQuizId blankQuizId) {

        blankQuizzes.removeIf(e -> e.getBlankQuizId().equals(blankQuizId));
    }


}
