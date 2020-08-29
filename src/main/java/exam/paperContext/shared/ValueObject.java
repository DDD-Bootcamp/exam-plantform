package exam.paperContext.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
