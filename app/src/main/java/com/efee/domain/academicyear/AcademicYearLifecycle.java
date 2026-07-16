/*
 * Reference Implementation:
 * Sprint-001 / Story-002
 */


/**
 * Represents the approved lifecycle of an Academic Year.
 *
 * Lifecycle transitions:
 *
 * PLANNED
 *     ↓
 * ACTIVE
 *     ↓
 * CLOSED
 */

package com.efee.domain.academicyear;

public enum AcademicYearLifecycle {

    PLANNED,

    ACTIVE,

    CLOSED

}