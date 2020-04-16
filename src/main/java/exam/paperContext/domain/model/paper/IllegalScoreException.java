package exam.paperContext.domain.model.paper;

public class IllegalScoreException extends IllegalArgumentException {
    public IllegalScoreException(int score) {
        super("IllegalScoreException: exception score less than 100, actual:" + score);
    }
}
