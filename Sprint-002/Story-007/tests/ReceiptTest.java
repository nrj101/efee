// /Sprint-002/Story-007/tests/ReceiptTest.java

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    private Receipt newIssuedReceipt() {
        return new Receipt(
                "REC-001",
                "PAY-001",
                "R-2026-0001",
                Instant.parse("2026-07-16T09:00:00Z"));
    }

    @Test
    void shouldCreateReceiptInIssuedState() {
        Receipt receipt = newIssuedReceipt();

        assertAll(
                () -> assertEquals("REC-001", receipt.getReceiptIdentifier()),
                () -> assertEquals("PAY-001", receipt.getPaymentIdentifier()),
                () -> assertEquals("R-2026-0001", receipt.getReceiptNumber()),
                () -> assertEquals(
                        Instant.parse("2026-07-16T09:00:00Z"),
                        receipt.getAcknowledgementTimestamp()),
                () -> assertEquals(
                        ReceiptLifecycle.ISSUED,
                        receipt.getLifecycleState()),
                () -> assertTrue(receipt.getCorrectionHistory().isEmpty())
        );
    }

    @Test
    void shouldRejectNullConstructorArguments() {

        String receiptIdentifier = "REC-001";
        String paymentIdentifier = "PAY-001";
        Instant acknowledgementTimestamp = Instant.now();

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Receipt(
                                null,
                                paymentIdentifier,
                                "R-1",
                                acknowledgementTimestamp)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Receipt(
                                receiptIdentifier,
                                null,
                                "R-1",
                                acknowledgementTimestamp)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Receipt(
                                receiptIdentifier,
                                paymentIdentifier,
                                null,
                                acknowledgementTimestamp)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Receipt(
                                receiptIdentifier,
                                paymentIdentifier,
                                "R-1",
                                null))
        );
    }

    @Test
    void shouldRecordCorrectionAndTransitionToCorrected() {

        Receipt receipt = newIssuedReceipt();

        receipt.correct("Amount adjusted");

        assertAll(
                () -> assertEquals(
                        ReceiptLifecycle.CORRECTED,
                        receipt.getLifecycleState()),

                () -> assertEquals(
                        1,
                        receipt.getCorrectionHistory().size()),

                () -> assertEquals(
                        "Amount adjusted",
                        receipt.getCorrectionHistory().get(0))
        );
    }

    @Test
    void shouldPreserveHistoricalCorrectionsWhenCorrectingAgain() {

        Receipt receipt = newIssuedReceipt();

        receipt.correct("First correction");
        receipt.correct("Second correction");

        assertAll(
                () -> assertEquals(
                        ReceiptLifecycle.CORRECTED,
                        receipt.getLifecycleState()),

                () -> assertEquals(
                        List.of(
                                "First correction",
                                "Second correction"),
                        receipt.getCorrectionHistory())
        );
    }

    @Test
    void shouldRejectNullCorrectionDescription() {

        Receipt receipt = newIssuedReceipt();

        assertThrows(
                NullPointerException.class,
                () -> receipt.correct(null));
    }

    @Test
    void shouldRetireIssuedReceipt() {

        Receipt receipt = newIssuedReceipt();

        receipt.retire();

        assertEquals(
                ReceiptLifecycle.RETIRED,
                receipt.getLifecycleState());
    }

    @Test
    void shouldRetireCorrectedReceipt() {

        Receipt receipt = newIssuedReceipt();

        receipt.correct("Amount adjusted");

        receipt.retire();

        assertAll(
                () -> assertEquals(
                        ReceiptLifecycle.RETIRED,
                        receipt.getLifecycleState()),

                () -> assertEquals(
                        List.of("Amount adjusted"),
                        receipt.getCorrectionHistory())
        );
    }

    @Test
    void shouldRejectCorrectionOnRetiredReceipt() {

        Receipt receipt = newIssuedReceipt();

        receipt.retire();

        assertThrows(
                IllegalStateException.class,
                () -> receipt.correct("Post-retirement correction"));
    }

    @Test
    void shouldRejectRetiringAlreadyRetiredReceipt() {

        Receipt receipt = newIssuedReceipt();

        receipt.retire();

        assertThrows(
                IllegalStateException.class,
                receipt::retire);
    }

    @Test
    void shouldProtectCorrectionHistoryFromExternalModification() {

        Receipt receipt = newIssuedReceipt();

        receipt.correct("Original correction");

        List<String> history = receipt.getCorrectionHistory();

        assertThrows(
                UnsupportedOperationException.class,
                () -> history.add("Injected correction"));

        assertEquals(
                List.of("Original correction"),
                receipt.getCorrectionHistory());
    }
}