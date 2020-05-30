package exam.paperContext.userInterface;

import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.application.PaperService;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.infrastructure.MemoryPaperReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    private PaperService paperService;
    private MemoryPaperReadRepository paperReadRepository;

    @Autowired
    public PaperController(PaperService paperService, MemoryPaperReadRepository paperReadRepository) {
        this.paperService = paperService;
        this.paperReadRepository = paperReadRepository;
    }

    @PostMapping("/papers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    PaperDTO assemble(@RequestBody AssemblePaperCommand command) {
        final PaperId paperId = paperService.assemblePaper(command);
        return PaperDTO.from(paperId);
    }

    @GetMapping("/papers") //读请求,获取倒序排列的Paper
    List<Paper> getAll() {
        return paperReadRepository.getAllByReversedOrder();
    }

    @PutMapping("/papers/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void reassemble(@PathVariable String paperId, @RequestBody AssemblePaperCommand command) {
        paperService.reassemblePaper(paperId, command);
    }
}
