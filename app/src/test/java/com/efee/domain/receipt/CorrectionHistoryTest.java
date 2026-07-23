package com.efee.domain.receipt;
/*
 * Reference Implementation:
 * Sprint-002 / Story-007
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CorrectionHistoryTest {

    @Test
    void shouldStartEmpty() {
        CorrectionHistory history = new CorrectionHistory();

        assertEquals(0, history.size());
        assertTrue(history.getCorrections().isEmpty());
    }

    @Test
    void shouldAppendCorrection() {
        CorrectionHistory history = new CorrectionHistory();

        history.addCorrection("Amount adjusted");
        history.addCorrection("Payer name corrected");

        assertEquals(2, history.size());

        List<String> corrections = history.getCorrections();

        assertEquals("Amount adjusted", corrections.get(0));
        assertEquals("Payer name corrected", corrections.get(1));
    }

    @Test
    void shouldPreserveOrdering() {
        CorrectionHistory history = new CorrectionHistory();

        history.addCorrection("First");
        history.addCorrection("Second");
        history.addCorrection("Third");

        assertEquals(
                List.of("First", "Second", "Third"),
                history.getCorrections());
    }

    @Test
    void shouldRejectNullCorrection() {
        CorrectionHistory history = new CorrectionHistory();

        assertThrows(
                NullPointerException.class,
                () -> history.addCorrection(null));
    }

    @Test
    void shouldReturnImmutableCorrectionsView() {
        CorrectionHistory history = new CorrectionHistory();

        history.addCorrection("Original correction");

        List<String> corrections = history.getCorrections();

        assertThrows(
                UnsupportedOperationException.class,
                () -> corrections.add("Injected correction"));
    }
}