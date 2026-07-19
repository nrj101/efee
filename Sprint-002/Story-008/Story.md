# Story-008 — Payment Service

```yaml
---
story_id: Story-008
title: Payment Service
version: 3.0.0
status: Approved

sprint: Sprint-002
priority: High

owner: Product Owner

application_service: PaymentService

created: 2026-07-16
last_updated: 2026-07-18

related_documents:
  - ../Sprint-002.md
  - ../../architecture/ApplicationServices.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../technical-specification/aggregates/Payment.md
  - ../../spec/docs/workflows/PaymentManagement.md
  - ../../spec/docs/BusinessRules.md
---
```

---

# Business Objective

Implement the **PaymentService** defined by the approved Software Architecture.

The Payment Service coordinates the approved Payment Management workflow while preserving Aggregate ownership and architectural boundaries.

Business behaviour SHALL remain implemented by the Payment Aggregate.

---

# Service Contract

The Payment Service SHALL expose only the public operations approved by this Story.

No additional public operations are approved.

---

## Operation — Record Payment

### Purpose

Coordinate the approved **Record Payment** business workflow.

### Parameters

The operation SHALL accept only the information required to construct a valid Payment Aggregate.

Parameter types SHALL remain consistent with the approved Payment Aggregate constructor.

### Returns

Returns the newly created **Payment Aggregate**.

No alternative return type is approved.

### Approved Workflow

The operation SHALL coordinate the following sequence.

1. Receive Record Payment request.
2. Coordinates the approved Record Payment workflow.
3. Return the created Payment Aggregate.

### Approved Aggregate Contracts

The operation SHALL invoke only:

- Payment Aggregate constructor

No additional Aggregate operations are approved.

---

## Operation — Realize Payment

### Purpose

Coordinate the approved **Realize Payment** business workflow.

### Parameters

Accepts an existing Payment Aggregate.

### Returns

Returns the updated Payment Aggregate.

No alternative return type is approved.

### Approved Workflow

The operation SHALL coordinate the following sequence.

1. Receive Realize Payment request.
2. Invoke the approved Payment Aggregate realization operation.
3. Return the updated Payment Aggregate.

### Approved Aggregate Contracts

The operation SHALL invoke only:

- Payment.realize()

No additional Aggregate operations are approved.

---

# Participating Aggregates

The approved workflows coordinate the following Aggregate.

| Aggregate | Responsibility |
|-----------|----------------|
| Payment | Owns all Payment business behaviour, state, lifecycle and invariants. |

No additional Aggregates participate in this Story.

---

# Required Aggregate Contracts

Implementation SHALL use only the public contracts defined by:

- Payment Aggregate Technical Specification

Every Aggregate interaction SHALL be traceable to an approved Aggregate contract.

The Application Service SHALL NOT:

- invent Aggregate operations;
- reinterpret Aggregate contracts;
- bypass Aggregate behaviour;
- modify Aggregate state directly.

If implementation cannot be completed using the approved Aggregate contracts, implementation SHALL stop and clarification SHALL be requested.

---

# Implementation Scope

This Story authorizes implementation of only:

- PaymentService
- PaymentService unit tests
- Story README

No additional implementation artifacts are approved.

---

# Engineering Contract

The Developer SHALL implement only the functionality explicitly authorized by this Story.

Implementation SHALL remain limited to the approved Service Contract.

Implementation SHALL NOT introduce additional:

- public operations;
- workflow steps;
- return types;
- helper domain objects;
- business behaviour.

If implementation requires behaviour outside this Story, STOP and request clarification.

---

# Write Scope

The Developer MAY create or modify ONLY the following artifacts.

### Source

```text
/Sprint-002/Story-008/source/PaymentService.java
```

### Tests

```text
/Sprint-002/Story-008/tests/PaymentServiceTest.java
```

### Documentation

```text
/Sprint-002/Story-008/README.md
```

Artifacts not explicitly listed SHALL NOT be created or modified.

---

# Output Locations

| Artifact | Output Location |
|----------|-----------------|
| PaymentService.java | /Sprint-002/Story-008/source/PaymentService.java |
| PaymentServiceTest.java | /Sprint-002/Story-008/tests/PaymentServiceTest.java |
| README.md | /Sprint-002/Story-008/README.md |

---

# Authoritative Engineering Artifacts

Implementation SHALL follow the following engineering artifacts.

1. Engineering Constitution
2. Application Service Developer Prompt
3. Story-008
4. PaymentManagement.md
5. Payment Aggregate Technical Specification
6. SoftwareArchitecture.md
7. ApplicationServices.md
8. BusinessRules.md
9. Approved Reference Implementations (if attached)

Higher-precedence artifacts SHALL take priority whenever conflicts exist.

---

# Acceptance Criteria

The implementation SHALL:

- expose exactly the approved public operations;
- coordinate only the approved workflows;
- invoke only approved Aggregate contracts;
- preserve Aggregate ownership;
- preserve approved workflow sequencing;
- generate only approved implementation artifacts;
- generate automated unit tests.

The implementation SHALL NOT:

- invent public APIs;
- invent return types;
- invent helper domain objects;
- invent Aggregate contracts;
- duplicate Aggregate behaviour;
- introduce business rules;
- introduce undocumented workflow behaviour.

---

# Out of Scope

This Story intentionally excludes:

- Receipt coordination;
- Payment Allocation coordination;
- Fee Obligation coordination;
- persistence;
- repositories;
- messaging;
- REST APIs;
- framework configuration;
- infrastructure concerns.

Future workflow extensions SHALL be implemented through new approved Story Packages.

---

# Completion Checklist

Before marking this Story complete, verify:

- approved public operations implemented;
- approved workflows coordinated;
- only approved Aggregate contracts invoked;
- Aggregate ownership preserved;
- only approved artifacts modified;
- only approved Output Locations used;
- no undocumented assumptions introduced;
- no additional public APIs introduced;
- automated unit tests completed.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-16 | Initial approved Story. |
| 2.0.0 | 2026-07-18 | Refactored to align with the Application Service Story Template. |
| 3.0.0 | 2026-07-18 | Introduced an explicit Service Contract defining approved public operations, workflows, parameters, return values and Aggregate contracts to eliminate implementation ambiguity and prevent speculative APIs. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-18