package exam.blankquizContext.userInterface;


import exam.blankquizContext.application.BlankQuizApplicationService;
import exam.blankquizContext.application.CreateBlankQuizCommand;
import exam.blankquizContext.application.DeleteBlankQuizCommand;
import exam.blankquizContext.application.ReviseBlankQuizCommand;
import exam.paperContext.domain.model.paper.IllegalScoreException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/blankquizzes")
public class BlankQuizController {

  private BlankQuizApplicationService blankQuizApplicationService;

  public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
    this.blankQuizApplicationService = blankQuizApplicationService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody final CreateBlankQuizCommand command) throws IllegalScoreException {
    blankQuizApplicationService.createQuiz(command);
  }

  @PutMapping("/{blankquizId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable final String quizId,
                     @RequestBody final ReviseBlankQuizCommand command) {
    blankQuizApplicationService.reviseQuiz(quizId, command);
  }

  @DeleteMapping("/{blankquizId}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable final String quizId) {
    blankQuizApplicationService.deleteQuiz(new DeleteBlankQuizCommand(quizId));
  }
}
