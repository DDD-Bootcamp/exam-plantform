package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.Paper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryPaperReadRepository {
    public List<Paper> getAllByReversedOrder() {
        return null;
    }
}
