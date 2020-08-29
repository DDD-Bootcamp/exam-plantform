package exam.paperContext.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
