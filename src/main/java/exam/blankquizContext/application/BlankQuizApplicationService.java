package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import exam.paperContext.domain.model.paper.IllegalScoreException;

public class BlankQuizApplicationService {

  private BlankQuizRepository blankQuizRepository;

  public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
    this.blankQuizRepository = blankQuizRepository;
  }

  public BlankQuizId createQuiz(final CreateBlankQuizCommand command) throws IllegalScoreException {
    BlankQuizId blankQuizId = BlankQuizId.nextBlankQuizId();
    BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, command.getTeacherId(), command.getQuestion(),
                                           command.getReferenceAnswer(), command.getScore());
    blankQuizRepository.save(blankQuiz);
    return blankQuizId;
  }

  public BlankQuizId reviseQuiz(final String quizId, final ReviseBlankQuizCommand command) {
    BlankQuizId blankQuizId = new BlankQuizId(quizId);
    BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
    BlankQuiz newBlankQuiz = blankQuiz.revise(blankQuizId, command.getTeacherId(),
                                              command.getContent(), command.getReferenceAnswer(), command.getScore());
    blankQuizRepository.save(newBlankQuiz);
    return blankQuizId;
  }

  public void deleteQuiz(final DeleteBlankQuizCommand command) {
    blankQuizRepository.delete(new BlankQuizId(command.getBlankQuizId()));
  }

}
