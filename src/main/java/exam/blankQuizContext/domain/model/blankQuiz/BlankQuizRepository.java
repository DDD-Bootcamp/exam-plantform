package exam.blankQuizContext.domain.model.blankQuiz;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    void delete(BlankQuizId blankQuizId);
}
