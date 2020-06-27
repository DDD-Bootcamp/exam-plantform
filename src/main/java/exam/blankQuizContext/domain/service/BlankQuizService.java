package exam.blankQuizContext.domain.service;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Service;

@Service
public class BlankQuizService {

    private final BlankQuizRepository blankQuizRepository;

    public BlankQuizService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuiz create(BlankQuiz blankQuiz) {
        return null;
    }

    public void delete(BlankQuizId blankQuizId) {

    }
}
