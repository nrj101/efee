// /Sprint-001/Story-005/tests/FeeObligationTest.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FeeObligationTest {
    @Test
    public void testSuccessfulCreation() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);

        // Act
        FeeObligation feeObligation = new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        );

        // Assert
        assertEquals(feeObligationIdentifier, feeObligation.getFeeObligationIdentifier());
        assertEquals(studentIdentifier, feeObligation.getStudentIdentifier());
        assertEquals(academicYearIdentifier, feeObligation.getAcademicYearIdentifier());
        assertEquals(feeStructureIdentifier, feeObligation.getFeeStructureIdentifier());
        assertEquals(obligationLines, feeObligation.getObligationLines());
        assertEquals(outstandingAmount, feeObligation.getOutstandingAmount());
        assertTrue(feeObligation.isActive());
    }

    @Test
    public void testConstructorValidation() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(-100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        ));
    }

    @Test
    public void testUpdateValidation() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);
        FeeObligation feeObligation = new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        );

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> feeObligation.update(null, new MonetaryAmount(500.0)));
        assertThrows(IllegalArgumentException.class, () -> feeObligation.update(new ArrayList<>(), new MonetaryAmount(500.0)));
        assertThrows(IllegalArgumentException.class, () -> feeObligation.update(new ArrayList<>(Arrays.asList(null)), new MonetaryAmount(500.0)));
        assertThrows(IllegalArgumentException.class, () -> feeObligation.update(new ArrayList<>(Arrays.asList(new ObligationLine("OL1", "Description 1", 100.0), new ObligationLine("OL1", "Description 2", 200.0))), new MonetaryAmount(500.0)));
    }

    @Test
    public void testRetirement() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);
        FeeObligation feeObligation = new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        );

        // Act
        feeObligation.retire();

        // Assert
        assertFalse(feeObligation.isActive());
    }

    @Test
    public void testRetirementAfterRetirement() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<Obligation
    }

    @Test
    public void testImmutableCollectionBehavior() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);
        FeeObligation feeObligation = new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        );

        // Act
        List<ObligationLine> lines = feeObligation.getObligationLines();

        // Assert
        assertThrows(UnsupportedOperationException.class, () -> lines.add(new ObligationLine("OL2", "Description 2", 200.0)));
    }

    @Test
    public void testDefensiveCopy() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);
        FeeObligation feeObligation = new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        );

        // Act
        obligationLines.add(new ObligationLine("OL2", "Description 2", 200.0));

        // Assert
        assertEquals(1, feeObligation.getObligationLines().size());
    }

    @Test
    public void testNullObligationLine() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        obligationLines.add(null);
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        ));
    }

    @Test
    public void testDuplicateObligationLines() {
        // Arrange
        String feeObligationIdentifier = "FO123";
        String studentIdentifier = "S123";
        String academicYearIdentifier = "AY2025";
        String feeStructureIdentifier = "FS456";
        List<ObligationLine> obligationLines = new ArrayList<>();
        obligationLines.add(new ObligationLine("OL1", "Description 1", 100.0));
        obligationLines.add(new ObligationLine("OL1", "Description 2", 200.0));
        MonetaryAmount outstandingAmount = new MonetaryAmount(500.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new FeeObligation(
            feeObligationIdentifier,
            studentIdentifier,
            academicYearIdentifier,
            feeStructureIdentifier,
            obligationLines,
            outstandingAmount
        ));
    }
}