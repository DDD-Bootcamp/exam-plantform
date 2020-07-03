package exam.blankquizContext.infrastructure;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizs = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizs.stream().filter(blankQuiz-> blankQuiz.getBlankQuizId()
            .equals(blankQuizId))
            .findFirst()
            .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.add(blankQuiz);
    }



}
