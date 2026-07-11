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
        this.id = validateNonEmpty(id, "ID");
        this.name = validateNonEmpty(name, "Name");
        this.startDate = validateDate(startDate, "Start Date");
        this.endDate = validateDate(endDate, "End Date");
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

    public void update(String newName, LocalDate newStartDate, LocalDate newEndDate) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (newStartDate == null || newEndDate == null) {
            throw new IllegalArgumentException("Start and end dates must be provided");
        }
        if (newStartDate.isAfter(newEndDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        
        this.name = newName;
        this.startDate = newStartDate;
        this.endDate = newEndDate;
    }

    private String validateNonEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
        return value;
    }

    private LocalDate validateDate(LocalDate date, String fieldName) {
        if (date == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        return date;
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