# Sprint-001 — Core Financial Foundation

```yaml
---
sprint_id: Sprint-001
title: Core Financial Foundation
version: 1.0.0
status: Draft

owner: Product Owner

created: 2026-07-06

related_documents:
  - ../architecture/AggregateDesign.md
  - ../architecture/SoftwareArchitecture.md
  - ../spec/docs/SoftwareDomainModel.md
  - ../spec/docs/BusinessRules.md
---
```

---

# Purpose

Sprint-001 establishes the foundational Aggregate implementations required for the Student Fee Receivables Platform.

Rather than implementing complete business workflows, this Sprint incrementally realizes the approved Aggregate Design by introducing the core business ownership boundaries defined by the software architecture.

Each Story within this Sprint represents the implementation of one Aggregate Root together with its approved business behaviour.

---

# Sprint Objective

Implement the foundational Aggregates that establish a student's financial responsibility within an Academic Year.

At the completion of this Sprint, the software should be capable of representing:

* Students;
* Academic Years;
* institutional charging policies;
* student fee obligations.

Financial settlement activities such as Payments and Receipts are intentionally deferred to subsequent Sprints.

---

# Architectural Context

This Sprint realizes the approved Software Architecture through incremental Aggregate implementation.

Aggregate ownership, responsibilities and invariants remain defined exclusively by the Architecture documentation.

Stories within this Sprint SHALL preserve:

* Aggregate boundaries;
* business ownership;
* transactional consistency boundaries;
* architectural dependency rules.

Implementation SHALL NOT redefine the approved architecture.

---

# Aggregate Scope

Sprint-001 introduces the following Aggregate Roots.

| Story     | Aggregate Root  | Primary Business Truth                 |
| --------- | --------------- | -------------------------------------- |
| Story-001 | Student         | Student Identity                       |
| Story-002 | Academic Year   | Academic Year Lifecycle                |
| Story-003 | Fee Structure   | Institutional Charging Policy          |
| Story-004 | Discount Policy | Discount Eligibility & Grant Lifecycle |
| Story-005 | Fee Obligation  | Student Fee Receivable                 |

---

# Story Sequencing

Stories should be implemented in the approved sequence.

The sequence reflects architectural dependencies rather than business importance.

```text
Story-001
Student
        │
        ▼
Story-002
Academic Year
        │
        ▼
Story-003
Fee Structure
        │
        ▼
Story-004
Discount Policy
        │
        ▼
Story-005
Fee Obligation
```

Fee Obligation is intentionally implemented after its collaborating Aggregates have been established.

---

# Deferred Aggregates

The following Aggregate Roots are intentionally excluded from Sprint-001.

| Aggregate | Planned Sprint |
| --------- | -------------- |
| Payment   | Sprint-002     |
| Receipt   | Sprint-002     |

These Aggregates primarily realize financial settlement rather than financial responsibility and therefore belong to the next implementation phase.

---

# Engineering Principles

Implementation SHALL:

* preserve the approved Product Specification;
* preserve Aggregate ownership;
* preserve Aggregate invariants;
* preserve architectural boundaries;
* remain implementation-independent wherever practical.

Stories SHALL introduce only the functionality explicitly approved for the corresponding Aggregate.

---

# Story Independence

Each Story Package shall remain independently reviewable.

Every Story shall contain:

* Story.md;
* ImplementationGuide.md;
* README.md;
* source artifacts;
* test artifacts.

A Story shall not require implementation details from unrelated Stories beyond the approved architectural dependencies.

---

# Acceptance Criteria

Sprint-001 will be considered complete when:

* all approved Stories have been implemented;
* Aggregate ownership remains faithful to the approved architecture;
* business invariants are preserved;
* automated tests have been completed for each Story;
* no implementation contradicts the Product Specification or Software Architecture.

---

# Out of Scope

Sprint-001 intentionally excludes:

* Payment processing;
* Receipt generation;
* reporting;
* REST APIs;
* database persistence;
* authentication;
* authorization;
* frontend implementation;
* deployment concerns;
* infrastructure configuration.

These capabilities belong to future implementation phases.

---

# Risks

The primary engineering risks for this Sprint include:

* incorrect decomposition of Aggregate responsibilities;
* accidental violation of Aggregate boundaries;
* implementation introducing behaviour not defined by the Product Specification;
* implementation coupling that contradicts the approved architecture.

The adopted AI Engineering Framework should be used to minimize these risks through disciplined Story-based implementation.

---

# Exit Criteria

Sprint-001 is complete when:

* every planned Story has been approved and implemented;
* all implementation artifacts conform to their Story Packages;
* the approved Software Architecture remains intact;
* the implementation provides a stable foundation for introducing financial settlement capabilities in Sprint-002.

---

# Expected Deliverables

Sprint-001 shall produce:

* Story-001 — Student Aggregate
* Story-002 — Academic Year Aggregate
* Story-003 — Fee Structure Aggregate
* Story-004 — Discount Policy Aggregate
* Story-005 — Fee Obligation Aggregate

Each completed Story should become a candidate for future Canonical Engineering Examples once implementation quality has been validated.
