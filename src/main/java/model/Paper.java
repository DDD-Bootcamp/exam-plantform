package model;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Paper {
    private String id;

    private List<BlankQuiz> blankQuizs;

    private static void verifyPaper(List<BlankQuiz> blankQuizs) throws Exception {
        if (blankQuizs.size() < 5) {
            throw new Exception("blank quiz number is less 5");
        }
        if (blankQuizs.size() > 20) {
            throw new Exception("blank quiz number is than 20");
        }
        if (blankQuizs.stream().mapToInt(BlankQuiz::getScore).sum() != 100) {
            throw new Exception("paper total scores is not 100");
        }
    }

    public static Paper create(List<BlankQuiz> blankQuizs) throws Exception {
        verifyPaper(blankQuizs);
        return Paper.builder().id(String.valueOf(blankQuizs.hashCode())).blankQuizs(blankQuizs).build();
    }

    public void updatePaper(List<BlankQuiz> addBlankQuizs, List<Integer> deleteBlankQuizIds) throws Exception {
        List<BlankQuiz> tmpBlanQuizs = Lists.newArrayList(blankQuizs);
        tmpBlanQuizs.removeIf(blankQuiz -> deleteBlankQuizIds.stream().anyMatch(id->blankQuiz.getId().equals(id)));
        tmpBlanQuizs.addAll(addBlankQuizs);
        verifyPaper(tmpBlanQuizs);
        blankQuizs = tmpBlanQuizs;
    }
}
