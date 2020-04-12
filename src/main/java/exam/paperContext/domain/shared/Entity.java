package exam.paperContext.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
