package exam.paperContext.domain.model.paper;

public interface PaperRepository {
    Paper find(PaperId paperId);

    void save(Paper paper);

    PaperId nextPaperId();
}
