package exam.blankQuizContext.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
