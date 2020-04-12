package exam.paperContext.domain.model;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
class TeacherId implements ValueObject<TeacherId> {
    private String id;

    @Override
    public boolean sameValueAs(TeacherId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherId teacherId = (TeacherId) o;
        return Objects.equals(id, teacherId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
