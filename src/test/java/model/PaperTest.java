package model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PaperTest {
    @Test
    public void should_return_paper_by_blank_quiz() throws Exception {
        List<BlankQuiz> blankQuizs = List.of(
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(4).question("quistion4").referenceAnswer("reference answer4").score(35).build(),
                BlankQuiz.builder().id(5).question("quistion5").referenceAnswer("reference answer5").score(35).build());
        Paper paper = Paper.create(blankQuizs);
        Assert.assertTrue(paper instanceof Paper);
        Assert.assertEquals(paper.getId(), String.valueOf(blankQuizs.hashCode()));
        Assert.assertEquals(paper.getBlankQuizs().size(), 5);
    }

    @Test(expected = Exception.class)
    public void should_create_faild_when_blank_quiz_number_is_less_5() throws Exception {
        List<BlankQuiz> blankQuizs = List.of(
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(5).question("quistion5").referenceAnswer("reference answer5").score(5).build());
        Paper paper = Paper.create(blankQuizs);
    }

    @Test(expected = Exception.class)
    public void should_create_faild_when_blank_quiz_number_is_than_20() throws Exception {
        List<BlankQuiz> blankQuizs = List.of(
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(5).question("quistion5").referenceAnswer("reference answer5").score(5).build());
        Paper paper = Paper.create(blankQuizs);
    }

    @Test(expected = Exception.class)
    public void should_create_faild_when_paper_scores_is_not_100() throws Exception {
        List<BlankQuiz> blankQuizs = List.of(
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(4).question("quistion4").referenceAnswer("reference answer4").score(5).build(),
                BlankQuiz.builder().id(5).question("quistion5").referenceAnswer("reference answer5").score(5).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build());

        Paper paper = Paper.create(blankQuizs);
    }

    @Test
    public void should_update_paper_delete_id_1_and_insert_new_question() throws Exception {
        List<BlankQuiz> blankQuizs = List.of(
                BlankQuiz.builder().id(1).question("quistion1").referenceAnswer("reference answer1").score(10).build(),
                BlankQuiz.builder().id(2).question("quistion2").referenceAnswer("reference answer2").score(10).build(),
                BlankQuiz.builder().id(3).question("quistion3").referenceAnswer("reference answer3").score(10).build(),
                BlankQuiz.builder().id(4).question("quistion4").referenceAnswer("reference answer4").score(35).build(),
                BlankQuiz.builder().id(5).question("quistion5").referenceAnswer("reference answer5").score(35).build());

        Paper paper = Paper.create(blankQuizs);

        List<BlankQuiz> addBlankQuizs = List.of(
                BlankQuiz.builder().id(7).question("quistion7").referenceAnswer("reference answer7").score(35).build(),
                BlankQuiz.builder().id(6).question("quistion6").referenceAnswer("reference answer6").score(10).build());
        List<Integer> deleteBlankQuizIds = List.of(1, 4);
        paper.updatePaper(addBlankQuizs, deleteBlankQuizIds);
        Assert.assertEquals("quistion6", paper.getBlankQuizs().get(4).getQuestion());
        Assert.assertTrue(paper.getBlankQuizs().stream().map(BlankQuiz::getId).filter(id->id==1).findFirst().isEmpty());
        Assert.assertTrue(paper.getBlankQuizs().stream().map(BlankQuiz::getId).filter(id->id==4).findFirst().isEmpty());
    }
}
