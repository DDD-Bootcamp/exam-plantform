package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.domain.service.BlankQuizService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlankQuizController {
    private final BlankQuizService blankQuizService;

    public BlankQuizController(BlankQuizService blankQuizService) {
        this.blankQuizService = blankQuizService;
    }

}
