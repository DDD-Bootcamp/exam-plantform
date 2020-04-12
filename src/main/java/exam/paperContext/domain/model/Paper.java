package exam.paperContext.domain.model;

import exam.paperContext.domain.shared.Entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Paper implements Entity<Paper> {
    private PaperId paperId;
    private List<BlankQuiz> blankQuizzes;
    private TeacherId teacherId;
    private LocalDateTime createTime;

    public Paper(PaperId paperId, TeacherId teacherId, List<BlankQuiz> blankQuizzes) {
        if(blankQuizzes.size() > 20) {
            throw new TooManyQuizzesException(blankQuizzes.size());
        }
        this.paperId = paperId;
        this.blankQuizzes = blankQuizzes;
        this.teacherId = teacherId;
        createTime = LocalDateTime.now();
    }

    public PaperId getPaperId() {
        return paperId;
    }

    public TeacherId teacherId() {
        return teacherId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public Collection<Object> getQuizzes() {
        return Collections.unmodifiableList(blankQuizzes);
    }

    @Override
    public boolean sameIdentityAs(Paper other) {
        return paperId.sameValueAs(other.getPaperId());
    }
}
