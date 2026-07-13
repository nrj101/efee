# Story-004 Implementation Guide

```yaml
---
story_id: Story-004
aggregate: Discount
version: 1.0.0
status: Draft
---
```

---

# Purpose

This document defines the implementation obligations for Story-004.

It supplements the Story Package by describing the expected implementation behaviour.

It SHALL NOT introduce new business behaviour.

---

# Implementation Sequence

Implementation SHALL follow this sequence.

## Step 1

Review:

- Story.md
- Sprint-001.md
- Discount Aggregate Design
- Discount ATS
- Discount Persistence Model

If contradictions exist, STOP and request clarification.

---

## Step 2

Identify:

- Aggregate Root
- Supporting Entities
- Approved Aggregate State
- Approved Business Operations
- Approved Lifecycle
- Approved Business Invariants
- Approved Output Files

---

## Step 3

Implement only the approved Aggregate.

Implementation SHALL remain within the approved Write Scope.

---

## Step 4

Implement unit tests.

Tests SHALL verify:

- Aggregate construction
- constructor validation
- approved business operations
- lifecycle behaviour
- business invariant preservation
- invalid operations

---

## Step 5

Generate README.md describing:

- Story purpose
- Aggregate responsibility
- implemented files
- supported operations
- implementation notes

---

# Implementation Rules

Implementation SHALL:

- preserve Aggregate ownership
- preserve approved Aggregate state
- preserve lifecycle
- preserve invariants
- preserve mutability constraints
- preserve collaboration boundaries

Implementation SHALL NOT:

- invent state
- invent lifecycle
- invent public operations
- invent collaborators
- invent repositories
- invent services
- invent package hierarchies
- invent persistence

If implementation requires undocumented information, STOP and request clarification.

---

# Output Validation

Before implementation is complete, verify:

✓ only approved files created

✓ Story directory preserved

✓ Aggregate invariants enforced

✓ mutable state encapsulated

✓ collections protected

✓ unit tests implemented

✓ README generated

---

# Review Checklist

Reviewer should verify:

- Story compliance
- Write Scope compliance
- Aggregate ownership
- lifecycle correctness
- invariant preservation
- encapsulation
- constructor validation
- unit test completeness
- documentation quality

---

# Completion Criteria

Implementation is complete only when:

- every approved output file has been generated
- all acceptance criteria have been satisfied
- no additional implementation artifacts exist
- implementation remains faithful to the approved architecture