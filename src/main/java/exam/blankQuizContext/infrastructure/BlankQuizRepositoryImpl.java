package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BlankQuizRepositoryImpl implements BlankQuizRepository {
    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return null;
    }

    @Override
    public void save(BlankQuiz blankQuiz) {

    }

    @Override
    public void delete(BlankQuizId blankQuizId) {

    }
}
