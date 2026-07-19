# Story-007 Implementation Guide

```yaml
---
story_id: Story-007
aggregate: Receipt
version: 1.0.0
status: Approved
---
```

---

# Purpose

This document defines the implementation obligations for Story-007.

It supplements the Story Package by describing the expected implementation behaviour.

It SHALL NOT introduce new business behaviour.

---

# Implementation Sequence

Implementation SHALL follow the approved engineering workflow defined by Sprint-002.

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
- Supporting Value Object;
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

# Aggregate Implementation Requirements

The implementation SHALL realize only the approved Aggregate model.

The Aggregate SHALL preserve:

- Receipt identity;
- Payment identifier;
- Receipt number;
- acknowledgement timestamp;
- Receipt lifecycle;
- correction history.

The Supporting Value Object SHALL model only the approved lifecycle defined by the Aggregate Technical Specification.

No additional lifecycle states are approved.

The implementation SHALL preserve Aggregate ownership and SHALL NOT assume ownership of collaborating Aggregates.

The implementation SHALL acknowledge accepted Payments without modifying business truths owned by the Payment Aggregate.

Historical Receipt information SHALL remain permanently preserved.

Corrections SHALL preserve historical acknowledgement information and SHALL NOT silently replace or destroy prior business evidence.

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
- acknowledgement integrity;
- historical auditability;
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