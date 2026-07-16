/*
 * Reference Implementation:
 * Sprint-001 / Story-005
 */

package com.efee.domain.feeobligation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeObligationLifecycleTest {

    @Test
    void shouldContainActiveLifecycleState() {

        assertEquals(
                FeeObligationLifecycle.ACTIVE,
                FeeObligationLifecycle.valueOf("ACTIVE"));
    }

    @Test
    void shouldContainRetiredLifecycleState() {

        assertEquals(
                FeeObligationLifecycle.RETIRED,
                FeeObligationLifecycle.valueOf("RETIRED"));
    }

    @Test
    void shouldContainExactlyTwoLifecycleStates() {

        FeeObligationLifecycle[] values =
                FeeObligationLifecycle.values();

        assertEquals(2, values.length);

        assertEquals(
                FeeObligationLifecycle.ACTIVE,
                values[0]);

        assertEquals(
                FeeObligationLifecycle.RETIRED,
                values[1]);
    }

}