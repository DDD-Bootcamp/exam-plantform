package exam.paperContext.application;

import exam.paperContext.domain.model.paper.BlankQuiz;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaperService {
    private PaperRepository paperRepository;

    @Autowired
    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public PaperId assemblePaper(AssemblePaperCommand command) {
        List<BlankQuiz> blankQuizzes = blankQuizFrom(command);
        final String teacherId = command.getTeacherId();
        final PaperId paperId = paperRepository.nextPaperId();

        final Paper paper = Paper.assemble(paperId, teacherId, blankQuizzes);
        paperRepository.save(paper);

        return paperId;
    }

    public List<Paper> getAll() {
        return paperRepository.getAll();
    }

    public void reassemblePaper(String paperId, AssemblePaperCommand command) {
        final Paper paper = paperRepository.find(new PaperId(paperId));
        List<BlankQuiz> blankQuizzes = blankQuizFrom(command);
        final String teacherId = command.getTeacherId();

        paper.reassemble(teacherId, blankQuizzes);
    }

    private List<BlankQuiz> blankQuizFrom(AssemblePaperCommand command) {
        return command.getQuizzes().stream().map(quiz -> {
            return new BlankQuiz(quiz.getQuizId(), quiz.getScore());
        }).collect(Collectors.toList());
    }
}
