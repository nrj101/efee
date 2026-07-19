// tests/ReceiptTest.java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.UUID;

class ReceiptTest {

    private Receipt newIssuedReceipt() {
        return new Receipt(
                UUID.randomUUID(),
                UUID.randomUUID(),
                "R-2026-0001",
                Instant.parse("2026-07-16T09:00:00Z"));
    }

    @Test
    void shouldCreateReceiptInIssuedState() {
        Receipt receipt = newIssuedReceipt();

        assertNotNull(receipt.getReceiptIdentifier());
        assertNotNull(receipt.getPaymentIdentifier());
        assertEquals("R-2026-0001", receipt.getReceiptNumber());
        assertEquals(Instant.parse("2026-07-16T09:00:00Z"), receipt.getAcknowledgementTimestamp());
        assertEquals(ReceiptLifecycle.ISSUED, receipt.getLifecycleState());
        assertEquals(0, receipt.getCorrectionHistory().size());
    }

    @Test
    void shouldRejectNullConstructorArguments() {
        UUID id = UUID.randomUUID();
        UUID pid = UUID.randomUUID();
        Instant ts = Instant.now();

        assertThrows(NullPointerException.class,
                () -> new Receipt(null, pid, "R-1", ts));
        assertThrows(NullPointerException.class,
                () -> new Receipt(id, null, "R-1", ts));
        assertThrows(NullPointerException.class,
                () -> new Receipt(id, pid, null, ts));
        assertThrows(NullPointerException.class,
                () -> new Receipt(id, pid, "R-1", null));
    }

    @Test
    void shouldRecordCorrectionAndTransitionToCorrected() {
        Receipt receipt = newIssuedReceipt();

        receipt.correct("Amount adjusted");

        assertEquals(ReceiptLifecycle.CORRECTED, receipt.getLifecycleState());
        assertEquals(1, receipt.getCorrectionHistory().size());
        assertEquals("Amount adjusted", receipt.getCorrectionHistory().getCorrections().get(0));
    }

    @Test
    void shouldPreserveHistoricalCorrectionsWhenCorrectingAgain() {
        Receipt receipt = newIssuedReceipt();

        receipt.correct("First correction");
        receipt.correct("Second correction");

        assertEquals(ReceiptLifecycle.CORRECTED, receipt.getLifecycleState());
        assertEquals(List.of("First correction", "Second correction"),
                receipt.getCorrectionHistory().getCorrections());
    }

    @Test
    void shouldRejectNullCorrectionDescription() {
        Receipt receipt = newIssuedReceipt();

        assertThrows(NullPointerException.class,
                () -> receipt.correct(null));
    }

    @Test
    void shouldRetireIssuedReceipt() {
        Receipt receipt = newIssuedReceipt();

        receipt.retire();

        assertEquals(ReceiptLifecycle.RETIRED, receipt.getLifecycleState());
    }

    @Test
    void shouldRetireCorrectedReceipt() {
        Receipt receipt = newIssuedReceipt();
        receipt.correct("Amount adjusted");

        receipt.retire();

        assertEquals(ReceiptLifecycle.RETIRED, receipt.getLifecycleState());
        assertEquals(1, receipt.getCorrectionHistory().size());
    }

    @Test
    void shouldRejectCorrectionOnRetiredReceipt() {
        Receipt receipt = newIssuedReceipt();
        receipt.retire();

        assertThrows(IllegalStateException.class,
                () -> receipt.correct("Post-retirement correction"));
    }

    @Test
    void shouldRejectRetiringAlreadyRetiredReceipt() {
        Receipt receipt = newIssuedReceipt();
        receipt.retire();

        assertThrows(IllegalStateException.class,
                () -> receipt.retire());
    }
}