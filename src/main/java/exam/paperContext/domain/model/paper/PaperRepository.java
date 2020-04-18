package exam.paperContext.domain.model.paper;

import java.util.List;

public interface PaperRepository {
    Paper find(PaperId paperId);

    void save(Paper paper);

    PaperId nextPaperId();

    List<Paper> getAll();
}
