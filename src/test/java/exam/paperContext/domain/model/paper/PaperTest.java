package exam.paperContext.domain.model.paper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaperTest {


    @Test
    public void should_create_paper_with_new() {
        final PaperId paperId = new PaperId("paper-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final String firstQuizId = "quiz-f500ee0d-3c9f-494a-bc13-993250053194";
        final String secondQuizId = "quiz-29bbb66c-80af-45b3-b593-fc4a358e900e";

        List<BlankQuiz> blankQuizzes = Arrays.asList(
                new BlankQuiz(firstQuizId, 10),
                new BlankQuiz(secondQuizId, 15)
        );

        Paper paper = Paper.assemble(paperId, teacherId, blankQuizzes);

        assertThat(paper, is(notNullValue()));

        assertThat(paper.getPaperId(), is(new PaperId("paper-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
        assertThat(paper.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(paper.getQuizzes().size(), is(2));
    }

    @Test
    public void should_quizzes_quantity_less_than_20() {
        Assertions.assertThrows(IllegalQuizzesCountException.class, ()-> {
            final PaperId paperId = new PaperId("paper-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
            final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";

            List<BlankQuiz> blankQuizzes = new ArrayList<>();
            for(int i=0; i<21; i++) {
                blankQuizzes.add(new BlankQuiz("quiz-" + i, 2));
            }

            Paper paper = Paper.assemble(paperId, teacherId, blankQuizzes);
        });
    }
}
