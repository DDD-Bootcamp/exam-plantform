package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryPaperReadRepository {
    public List<Paper> getAllByReversedOrder() {
        return null;
    }
}
