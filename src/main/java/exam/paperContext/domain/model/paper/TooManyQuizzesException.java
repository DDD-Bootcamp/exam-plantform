package exam.paperContext.domain.model.paper;

class TooManyQuizzesException extends IllegalArgumentException {

    public TooManyQuizzesException(int actual) {
        super("TooManyQuizzesException: exception:20, actual:" + actual);
    }
}
