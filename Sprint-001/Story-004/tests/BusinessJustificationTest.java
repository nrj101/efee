// /Sprint-001/Story-004/tests/BusinessJustificationTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessJustificationTest {

    @Test
    void shouldCreateBusinessJustification() {

        BusinessJustification justification =
                new BusinessJustification(
                        "Merit Scholarship");

        assertEquals(
                "Merit Scholarship",
                justification.getReason());
    }

    @Test
    void shouldRejectNullReason() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new BusinessJustification(null));
    }

    @Test
    void shouldRejectBlankReason() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new BusinessJustification(" "));
    }

    @Test
    void shouldImplementValueEquality() {

        BusinessJustification first =
                new BusinessJustification(
                        "Merit Scholarship");

        BusinessJustification second =
                new BusinessJustification(
                        "Merit Scholarship");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenReasonsDiffer() {

        BusinessJustification first =
                new BusinessJustification(
                        "Merit Scholarship");

        BusinessJustification second =
                new BusinessJustification(
                        "Sports Scholarship");

        assertNotEquals(first, second);
    }

    @Test
    void shouldGenerateReadableToString() {

        BusinessJustification justification =
                new BusinessJustification(
                        "Merit Scholarship");

        assertTrue(
                justification.toString()
                        .contains("Merit Scholarship"));
    }
}