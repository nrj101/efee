/*
 * Reference Implementation:
 * Sprint-001 / Story-002
 */

package com.efee.domain.academicyear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademicYearLifecycleTest {

    @Test
    void shouldContainApprovedLifecycleStates() {

        assertEquals(
                3,
                AcademicYearLifecycle.values().length);

        assertEquals(
                AcademicYearLifecycle.PLANNED,
                AcademicYearLifecycle.valueOf("PLANNED"));

        assertEquals(
                AcademicYearLifecycle.ACTIVE,
                AcademicYearLifecycle.valueOf("ACTIVE"));

        assertEquals(
                AcademicYearLifecycle.CLOSED,
                AcademicYearLifecycle.valueOf("CLOSED"));
    }

}