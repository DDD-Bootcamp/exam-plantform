package exam.blankquizContext.domain.model.blankquiz;

public class IllegalBlankQuizScoreException extends IllegalArgumentException {
    public IllegalBlankQuizScoreException(int score) {
        super("IllegalScoreException: exception score"  + score +" is greater than 100 or less than 0");
    }
}
