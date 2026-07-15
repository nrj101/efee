# Story-005 Implementation Guide

```yaml
---
story_id: Story-005
aggregate: Fee Obligation
version: 1.1.0
status: Draft
---
```

---

# Purpose

This document defines the implementation obligations for Story-005.

It supplements the Story Package by describing the expected implementation behaviour.

It SHALL NOT introduce new business behaviour.

---

# Implementation Sequence

Implementation SHALL follow the approved engineering workflow defined by Sprint-001.

## Step 1

Review the approved engineering artifacts referenced by **Story.md**.

If contradictions exist, STOP and request clarification.

---

## Step 2

Identify the approved:

- Aggregate state;
- business operations;
- lifecycle;
- business invariants;
- Supporting Value Objects;
- output files.

---

## Step 3

Implement only the approved Aggregate Root and Supporting Value Object.

Implementation SHALL remain within the approved Write Scope.

---

## Step 4

Implement unit tests.

Tests SHALL verify:

- Aggregate construction;
- constructor validation;
- approved business operations;
- lifecycle behaviour;
- business invariant preservation;
- invalid operations;
- Supporting Value Object behaviour.

---

## Step 5

Generate the Story README describing the implemented Aggregate.

---

# Implementation Rules

Implementation SHALL:

- preserve Aggregate ownership;
- preserve approved Aggregate state;
- preserve approved lifecycle;
- preserve approved business invariants;
- preserve approved collaboration boundaries.

Implementation SHALL NOT:

- introduce undocumented state;
- introduce undocumented operations;
- introduce undocumented collaborators;
- introduce additional Supporting Value Objects;
- introduce Supporting Entities;
- introduce repositories;
- introduce services;
- introduce persistence;
- introduce framework-specific behaviour.

If implementation requires undocumented information, STOP and request clarification.

---

# Output Validation

Before implementation is complete, verify:

- only approved files have been generated;
- Aggregate invariants are preserved;
- mutable state is encapsulated;
- defensive copying has been applied where required;
- immutable collections are exposed where appropriate;
- unit tests have been implemented;
- Story README has been generated.

---

# Review Checklist

Reviewer shall verify:

- Story compliance;
- Aggregate ownership;
- lifecycle correctness;
- invariant preservation;
- encapsulation;
- constructor validation;
- Supporting Value Object implementation;
- unit test completeness;
- implementation consistency with the approved architecture.

---

# Completion Criteria

Implementation is complete only when:

- every approved output file has been generated;
- all Story acceptance criteria have been satisfied;
- no additional implementation artifacts exist; and
- implementation faithfully realizes the approved Aggregate Design, Technical Specification and Persistence Model.