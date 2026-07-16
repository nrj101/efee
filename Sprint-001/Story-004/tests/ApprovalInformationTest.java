// /Sprint-001/Story-004/tests/ApprovalInformationTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApprovalInformationTest {

    @Test
    void shouldCreateApprovalInformation() {

        ApprovalInformation approvalInformation =
                new ApprovalInformation(
                        "Principal",
                        "APR-001");

        assertEquals(
                "Principal",
                approvalInformation.getApprovedBy());

        assertEquals(
                "APR-001",
                approvalInformation.getApprovalReference());
    }

    @Test
    void shouldRejectNullApprovedBy() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ApprovalInformation(
                        null,
                        "APR-001"));
    }

    @Test
    void shouldRejectBlankApprovedBy() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ApprovalInformation(
                        " ",
                        "APR-001"));
    }

    @Test
    void shouldRejectNullApprovalReference() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ApprovalInformation(
                        "Principal",
                        null));
    }

    @Test
    void shouldRejectBlankApprovalReference() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ApprovalInformation(
                        "Principal",
                        ""));
    }

    @Test
    void shouldImplementValueEquality() {

        ApprovalInformation first =
                new ApprovalInformation(
                        "Principal",
                        "APR-001");

        ApprovalInformation second =
                new ApprovalInformation(
                        "Principal",
                        "APR-001");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenValuesDiffer() {

        ApprovalInformation first =
                new ApprovalInformation(
                        "Principal",
                        "APR-001");

        ApprovalInformation second =
                new ApprovalInformation(
                        "Manager",
                        "APR-002");

        assertNotEquals(first, second);
    }

    @Test
    void shouldGenerateReadableToString() {

        ApprovalInformation approvalInformation =
                new ApprovalInformation(
                        "Principal",
                        "APR-001");

        assertTrue(
                approvalInformation.toString()
                        .contains("Principal"));

        assertTrue(
                approvalInformation.toString()
                        .contains("APR-001"));
    }
}