package exam.paperContext.userInterface;

import exam.paperContext.domain.model.paper.PaperId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaperDTO {
    private String uri;

    public static PaperDTO from(PaperId paperId) {
        return new PaperDTO("papers/" + paperId);
    };
}
