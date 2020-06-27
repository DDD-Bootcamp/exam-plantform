package exam.blankQuizContext.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
