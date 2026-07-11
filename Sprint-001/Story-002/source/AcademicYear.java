// /Sprint-001/Story-002/source/AcademicYear.java

import java.time.LocalDate;
import java.util.Objects;

public class AcademicYear {
    private final String id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private AcademicYearStatus status;

    public AcademicYear(String id, String name, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = AcademicYearStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public AcademicYearStatus getStatus() {
        return status;
    }

    public void activate() {
        if (status != AcademicYearStatus.PENDING) {
            throw new IllegalStateException("Cannot activate an Academic Year that is not pending");
        }
        status = AcademicYearStatus.ACTIVE;
    }

    public void close() {
        if (status != AcademicYearStatus.ACTIVE) {
            throw new IllegalStateException("Cannot close an Academic Year that is not active");
        }
        status = AcademicYearStatus.CLOSED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicYear that = (AcademicYear) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum AcademicYearStatus {
        PENDING, ACTIVE, CLOSED
    }
}