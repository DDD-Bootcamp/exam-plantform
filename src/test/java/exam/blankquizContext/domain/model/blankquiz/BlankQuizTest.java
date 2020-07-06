package exam.blankquizContext.domain.model.blankquiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class BlankQuizTest {

  @Test
  public void should_create_blankquiz() {
    final BlankQuizId blankQuizId = new BlankQuizId("blankquiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
    final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";

    BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, "content", "referenceAnswer", 5);


    assertThat(blankQuiz, is(notNullValue()));

    assertThat(blankQuiz.getBlankQuizId(), is(new BlankQuizId("blankquiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
  }

  @Test
  public void should_update_blankquiz() {
    final BlankQuizId blankQuizId = new BlankQuizId("blankquiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
    final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";

    BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, "content", "referenceAnswer", 5);

    blankQuiz.revise(blankQuizId, teacherId, "content", "referenceAnswer", 10);
    assertThat(blankQuiz.getScore(), is(10));
  }

  @Test
  public void should_throw_exception_when_score_less_than_0() {
    Assertions.assertThrows(IllegalBlankQuizScoreException.class, () -> {
      final BlankQuizId blankQuizId = new BlankQuizId("blankquiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
      final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";

      BlankQuiz.create(blankQuizId, teacherId, "content", "referenceAnswer", -1);
    });
  }

}