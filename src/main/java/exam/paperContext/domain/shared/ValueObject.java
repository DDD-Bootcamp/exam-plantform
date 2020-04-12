package exam.paperContext.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
