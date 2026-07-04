# Aggregate Design

```yaml
---
document_id: AGG-001
title: Aggregate Design
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-04

related_documents:
  - ADR-001-Domain Architecture Strategy.md
  - ArchitecturePatterns.md
  - SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the Aggregate design of the Student Fee Receivables Platform.

Aggregate boundaries are derived from the approved Product Specification, Software Domain Model and Architecture Principles.

The purpose of this document is to identify ownership boundaries, business invariants and transactional consistency boundaries that govern the software implementation.

This document SHALL NOT introduce new business behaviour.

---

# Scope

This document defines:

* Aggregate Roots
* Supporting Entities
* Value Objects
* Aggregate Responsibilities
* Business Invariants
* Lifecycle Ownership
* Transaction Boundaries
* Aggregate Collaboration

This document does **not** define:

* Database schema
* REST APIs
* Package structure
* Framework implementation
* Repository implementation
* User Interface behaviour

---

# Aggregate Design Principles

Aggregate design follows the architectural principles established in ADR-001 and the recurring patterns documented in ArchitecturePatterns.md.

The following principles govern every Aggregate defined within this document.

## 1. Single Ownership of Business Truth

Each Aggregate owns exactly one primary business truth.

Business truth SHALL NOT be shared across Aggregates.

---

## 2. Aggregates Protect Invariants

Aggregate boundaries are determined by the business invariants that must remain consistent rather than object relationships or database design.

---

## 3. Collaboration Over Shared Ownership

Business processes emerge through collaboration between Aggregates.

Aggregates communicate through identifiers and business operations rather than shared mutable state.

---

## 4. Transaction Boundaries Follow Aggregate Boundaries

Each Aggregate defines its own consistency boundary.

Business operations affecting multiple Aggregates shall be coordinated by the Application Layer rather than by enlarging Aggregate boundaries.

---

## 5. Historical Financial Facts Are Immutable

Financial history SHALL NOT be rewritten.

Corrections introduce new business facts while preserving historical auditability.

---

## 6. Lifecycle Governs Behaviour

Business operations are permitted only when allowed by the current lifecycle state of the owning Aggregate.

Lifecycle transitions SHALL preserve business correctness and financial integrity.

---

![Image- Aggregate Relationships](/architecture/diagrams/D3-AggregateRelationships.png)

# Aggregate Catalogue

The following Aggregate Roots define the primary ownership boundaries of the Student Fee Receivables Platform.

Each Aggregate owns exactly one primary business truth and protects the business invariants associated with that truth.

Aggregates collaborate through business operations while maintaining independent consistency boundaries.

---

# Student

## Responsibility

Owns the identity and academic enrollment of a student.

## Owned Business Truth

* Student identity
* Academic profile
* Student lifecycle

## Supporting Entities

None

## Primary Invariants

* Student identity is unique.
* Student lifecycle remains valid.
* Student identity cannot be duplicated.

## Allowed Operations

* Register Student
* Update Student Information
* Activate Student
* Deactivate Student

## Collaborating Aggregates

* Academic Year
* Fee Obligation
* Discount Policy

## Repository

`StudentRepository`

---

# Academic Year

## Responsibility

Defines the financial and operational boundary of an academic session.

## Owned Business Truth

* Academic Year lifecycle
* Financial opening and closure
* Receipt numbering sequence

## Supporting Entities

None

## Primary Invariants

* Only one Academic Year may be active at any time.
* Closed Academic Years reject new financial activity.
* Receipt numbering remains unique within the Academic Year.

## Allowed Operations

* Open Academic Year
* Close Academic Year
* Generate Final Clearance
* Generate Receipt Number

## Collaborating Aggregates

* Student
* Fee Structure
* Fee Obligation
* Receipt

## Repository

`AcademicYearRepository`

---

# Fee Structure

## Responsibility

Owns the institution's charging policy.

## Owned Business Truth

* Fee Components
* Charging rules
* Fee configuration

## Supporting Entities

* Fee Component

## Primary Invariants

* Fee Components are uniquely identifiable.
* Charging rules remain internally consistent.
* Historical charging policies remain traceable.

## Allowed Operations

* Create Fee Structure
* Modify Fee Structure
* Activate Fee Structure
* Retire Fee Structure

## Collaborating Aggregates

* Academic Year
* Fee Obligation
* Discount Policy

## Repository

`FeeStructureRepository`

---

# Fee Obligation

## Responsibility

Owns the student's financial receivable.

## Owned Business Truth

* Outstanding Amount
* Settlement status
* Applicable financial obligations

## Supporting Entities

* Obligation Line
* Applied Discount

## Primary Invariants

* Outstanding Amount shall never become negative.
* Outstanding Amount is derived from:

  * Obligation Lines
  * Applied Discounts
  * Payment Allocations
* Settled obligations reject retrospective policy changes.
* Closed obligations reject further settlements.

## Allowed Operations

* Generate Fee Obligation
* Apply Discount
* Allocate Payment
* Reverse Allocation
* Close Obligation

## Collaborating Aggregates

* Student
* Academic Year
* Fee Structure
* Payment
* Discount Policy

## Repository

`FeeObligationRepository`

---

# Payment

## Responsibility

Owns the immutable record of money received by the institution.

## Owned Business Truth

* Payment amount
* Payment method
* Payment lifecycle

## Supporting Entities

* Payment Allocation

## Primary Invariants

* Payment amount is immutable after successful acceptance.
* Total allocated amount shall never exceed the received payment amount.
* Allocation corrections preserve financial history.

## Allowed Operations

* Record Payment
* Allocate Payment
* Reverse Allocation

## Collaborating Aggregates

* Fee Obligation
* Receipt

## Repository

`PaymentRepository`

---

# Receipt

## Responsibility

Owns the institution's official acknowledgement of an accepted payment.

## Owned Business Truth

* Receipt acknowledgement
* Receipt numbering
* Receipt lifecycle

## Supporting Entities

None

## Primary Invariants

* A Receipt acknowledges exactly one Payment.
* Receipt numbering is unique within an Academic Year.
* Receipt corrections preserve historical auditability.
* Receipt shall never reference a different Payment.

## Allowed Operations

* Issue Receipt
* Reprint Receipt
* Request Receipt Correction
* Approve Receipt Correction
* Execute Receipt Correction

## Collaborating Aggregates

* Payment
* Academic Year

## Repository

`ReceiptRepository`

---

# Discount Policy

## Responsibility

Owns institutional discount definitions, eligibility rules and grant lifecycle.

## Owned Business Truth

* Discount eligibility
* Discount rules
* Discount lifecycle

## Supporting Entities

* Discount Grant

## Primary Invariants

* Discount eligibility remains internally consistent.
* Revoked policies cannot issue new grants.
* Existing grants remain historically traceable.
* Approval is required before issuing a Discount Grant.

## Allowed Operations

* Create Discount Policy
* Modify Discount Policy
* Retire Discount Policy
* Grant Discount
* Revoke Discount Grant

## Collaborating Aggregates

* Student
* Academic Year
* Fee Structure
* Fee Obligation

## Repository

`DiscountPolicyRepository`

---


# Domain Taxonomy

The Student Fee Receivables Platform models business concepts using three primary domain building blocks:

* Aggregate Roots
* Entities
* Value Objects

Each Software Domain Concept SHALL belong to exactly one of these categories.

This taxonomy establishes the ownership, lifecycle and persistence characteristics of every concept within the domain model.

---

# Aggregate Roots

Aggregate Roots own primary business truths and define transactional consistency boundaries.

All modifications to business state SHALL occur through the owning Aggregate Root.

Only Aggregate Roots are accessed directly through Repositories.

| Aggregate Root  | Primary Business Truth                 |
| --------------- | -------------------------------------- |
| Student         | Student Identity                       |
| Academic Year   | Academic Year Lifecycle                |
| Fee Structure   | Charging Policy                        |
| Fee Obligation  | Student Receivable                     |
| Payment         | Money Received                         |
| Receipt         | Official Financial Acknowledgement     |
| Discount Policy | Discount Eligibility & Grant Lifecycle |

---

# Entities

Entities possess identity but exist only within the consistency boundary of an owning Aggregate Root.

Entities SHALL NOT expose independent repositories.

Entities SHALL be created, modified and removed only through their owning Aggregate.

| Entity             | Owning Aggregate | Responsibility                                                               |
| ------------------ | ---------------- | ---------------------------------------------------------------------------- |
| Fee Component      | Fee Structure    | Defines an individual charge within the charging policy.                     |
| Obligation Line    | Fee Obligation   | Represents an individual receivable generated from the charging policy.      |
| Applied Discount   | Fee Obligation   | Represents the financial application of a granted discount to an obligation. |
| Payment Allocation | Payment          | Represents the settlement of one or more Fee Obligations using a Payment.    |
| Discount Grant     | Discount Policy  | Represents a student-specific entitlement issued under a Discount Policy.    |

---

# Value Objects

Value Objects describe immutable concepts without independent identity.

Two Value Objects containing identical values are considered equal.

Value Objects SHALL be immutable.

Candidate Value Objects include:

| Value Object     | Purpose                                          |
| ---------------- | ------------------------------------------------ |
| Money            | Monetary amount and currency.                    |
| StudentId        | Student identifier.                              |
| AcademicYearId   | Academic Year identifier.                        |
| FeeStructureId   | Fee Structure identifier.                        |
| FeeObligationId  | Fee Obligation identifier.                       |
| PaymentId        | Payment identifier.                              |
| ReceiptNumber    | Official receipt number within an Academic Year. |
| DiscountPolicyId | Discount Policy identifier.                      |
| Percentage       | Percentage-based calculations.                   |
| DateRange        | Effective validity period.                       |
| AuditMetadata    | Creation, modification and audit information.    |

Additional Value Objects may be introduced where they improve domain expressiveness without introducing independent business identity.

---

# Repository Ownership

Repositories exist exclusively for Aggregate Roots.

Repositories provide access to complete Aggregate boundaries rather than individual Entities.

The following repositories are expected within the domain layer:

* StudentRepository
* AcademicYearRepository
* FeeStructureRepository
* FeeObligationRepository
* PaymentRepository
* ReceiptRepository
* DiscountPolicyRepository

Supporting Entities SHALL NOT expose independent repositories.

---

# Aggregate Boundary Rules

The following rules govern all Aggregate boundaries.

## Rule 1

Each Aggregate owns exactly one primary business truth.

---

## Rule 2

Entities belong to exactly one Aggregate.

Entities SHALL NOT be shared between Aggregates.

---

## Rule 3

Cross-Aggregate references SHALL be made using identifiers rather than object references wherever practical.

---

## Rule 4

Cross-Aggregate business processes SHALL be coordinated by the Application Layer.

Aggregates remain responsible only for preserving their own invariants.

---

## Rule 5

Historical financial facts remain immutable.

Corrections preserve historical auditability rather than rewriting business history.

---

# Domain Realization Pattern

The domain consistently separates institutional policy, operational state and financial effect.

| Policy          | Operational State  | Financial Effect   |
| --------------- | ------------------ | ------------------ |
| Fee Component   | Obligation Line    | Outstanding Amount |
| Discount Policy | Discount Grant     | Applied Discount   |

This pattern ensures that institutional policies remain stable while operational decisions and financial outcomes remain independently traceable.

---

# Taxonomy Rules

The classification defined within this document represents the canonical taxonomy of the software domain.

Future Software Domain Concepts SHALL be classified according to this taxonomy before implementation.

Changes to Aggregate boundaries or ownership require an approved Architecture Decision Record (ADR).

---

# Aggregate Interaction Rules

This section defines the interaction rules governing Aggregate collaboration within the Student Fee Receivables Platform.

These rules preserve Aggregate autonomy while ensuring business correctness across the software domain.

---

# Ownership Rules

## Rule 1 — Single Ownership of Business Truth

Each Aggregate owns exactly one primary business truth.

Business truth SHALL NOT be duplicated or shared across multiple Aggregates.

---

## Rule 2 — Aggregate Autonomy

An Aggregate SHALL modify only the business state that it owns.

Business state owned by another Aggregate SHALL NOT be modified directly.

---

## Rule 3 — Entity Ownership

Supporting Entities exist exclusively within the boundary of their owning Aggregate.

Entities SHALL NOT be shared between Aggregates.

---

# Collaboration Rules

Business workflows emerge through collaboration between Aggregates.

No Aggregate owns another Aggregate.

Cross-Aggregate interaction SHALL occur through well-defined business operations.

Examples include:

* Payments settle Fee Obligations.
* Receipts acknowledge accepted Payments.
* Discount Policies issue Discount Grants.
* Fee Obligations apply granted Discounts.

---

# Transaction Boundaries

Each Aggregate defines its own transactional consistency boundary.

A business transaction SHALL preserve the invariants of the Aggregate being modified.

Business operations involving multiple Aggregates SHALL be coordinated by the Application Layer rather than expanding Aggregate boundaries.

---

# Repository Rules

Repositories exist only for Aggregate Roots.

Repositories provide access to complete Aggregate boundaries rather than individual supporting Entities.

Supporting Entities SHALL NOT expose independent repositories.

---

# Cross-Aggregate References

Aggregates SHOULD reference other Aggregates by identifier rather than direct object references wherever practical.

This minimizes coupling while preserving clear ownership boundaries.

---

![Image- Aggregate Lifecycles](/architecture/diagrams/D4-AggregateLifecycles.png)

# Lifecycle Rules

Lifecycle transitions are owned exclusively by the Aggregate responsible for the associated business truth.

Aggregates SHALL reject operations that violate lifecycle constraints.

Examples include:

* Closed Academic Years reject new financial activity.
* Settled Fee Obligations reject retrospective policy changes.
* Revoked Discount Policies reject new Discount Grants.
* Payments remain immutable after successful acceptance.

---

# Approval-Governed Operations

Certain business operations require explicit approval before modifying domain state.

Approval governs the state transition of a business operation but does not own business truth.

Current approval-governed operations include:

* Issuing a Discount Grant
* Correcting a Receipt
* Modifying an active Fee Obligation

Future versions may introduce a generalized approval workflow without altering Aggregate responsibilities.

---

# Historical Integrity

Historical financial facts are immutable.

Business corrections SHALL preserve historical traceability by creating corrective business actions rather than rewriting historical records.

Examples include:

* Receipt Corrections
* Payment Allocation Reversals
* Fee Obligation Adjustments

Historical financial records SHALL remain auditable throughout the lifecycle of an Academic Year.

---

# Concurrency

Multiple users may perform concurrent business operations.

Aggregate consistency SHALL be preserved during concurrent modification.

The mechanism used to detect and resolve concurrent updates is an implementation concern and is intentionally outside the scope of this document.

---

# Aggregate Interaction Summary

The following principles summarize Aggregate collaboration within the system:

* Each Aggregate owns exactly one primary business truth.
* Business workflows emerge through Aggregate collaboration.
* Supporting Entities never cross Aggregate boundaries.
* Repository ownership follows Aggregate ownership.
* Transaction boundaries follow Aggregate boundaries.
* Lifecycle governs permitted operations.
* Historical financial facts remain immutable.
* Approval governs selected state transitions without becoming a business object.

---


# Design Rationale and Future Evolution

This section captures the architectural intent behind the Aggregate Design and documents the principles expected to guide future evolution of the software architecture.

Its purpose is to preserve the reasoning behind major architectural decisions so that future contributors can evolve the system without unintentionally violating its core design principles.

---

## Business-Driven Architecture

Aggregate boundaries are derived from business ownership and consistency requirements rather than database structure, user interface workflows or implementation technology.

The Product Specification remains the authoritative source of business behaviour.

The software architecture exists solely to realize the approved Product Specification.

---

## Single Ownership of Business Truth

Every primary business truth has exactly one owning Aggregate Root.

Examples include:

| Business Truth            | Owning Aggregate |
| ------------------------- | ---------------- |
| Student Identity          | Student          |
| Academic Year Lifecycle   | Academic Year    |
| Charging Policy           | Fee Structure    |
| Student Receivable        | Fee Obligation   |
| Money Received            | Payment          |
| Financial Acknowledgement | Receipt          |
| Discount Eligibility      | Discount Policy  |

This ownership model minimizes ambiguity, prevents duplicated state and establishes clear transactional boundaries.

---

## Stable Policies and Operational State

The architecture separates long-lived institutional policy from operational business state.

Policies define institutional intent.

Operational entities represent business decisions taken under those policies.

Examples include:

| Stable Policy   | Operational State |
| --------------- | ----------------- |
| Fee Component   | Obligation Line   |
| Discount Policy | Discount Grant    |

This separation allows institutional policies to evolve independently while preserving historical business activity.

---

## Entitlement and Financial Effect

Business entitlement and financial effect are intentionally modelled as separate concepts.

A Discount Grant represents a student's entitlement.

An Applied Discount represents the financial realization of that entitlement within a specific Fee Obligation.

This distinction enables:

* historical auditability;
* future policy evolution;
* revocation affecting only future obligations; and
* independent lifecycle management of business entitlement and financial application.

---

## Historical Integrity

Historical business activity is preserved through corrective business operations rather than destructive modification.

Examples include:

* Receipt Corrections
* Payment Allocation Reversals
* Fee Obligation Adjustments

Historical records remain auditable throughout the lifecycle of an Academic Year.

---

## Lifecycle-Driven Behaviour

Business operations are governed by Aggregate lifecycle state rather than application logic.

Each Aggregate is responsible for protecting the lifecycle rules associated with its owned business truth.

Approval-governed operations preserve this principle by controlling state transitions without introducing additional ownership of business truth.

---

## Collaboration over Shared Ownership

Business workflows emerge through collaboration between Aggregates.

No Aggregate owns another Aggregate's business truth.

Cross-Aggregate workflows are coordinated by the Application Layer while each Aggregate remains responsible only for preserving its own invariants.

---

## Architectural Simplicity for Beta

The Beta MVP intentionally prioritizes:

* business correctness;
* maintainability;
* explicit ownership boundaries; and
* implementation simplicity.

Accordingly, the architecture adopts:

* Modular Monolith deployment;
* Single-school operation;
* Single database;
* Synchronous workflows;
* Manual approval processes where required.

These decisions intentionally reduce implementation complexity without constraining future evolution.

---

## Deferred Enterprise Concerns

The following concerns are intentionally deferred beyond the Beta MVP.

### Platform

* Multi-tenancy
* Horizontal scalability
* Distributed deployment
* High availability
* Disaster recovery

### Security

* Enterprise IAM
* Fine-grained authorization
* Single Sign-On
* External Identity Providers

### Workflow

* Configurable Approval Engine
* Workflow orchestration
* Notification framework
* Task management

### Integration

* Parent Portal
* Student Portal
* Payment Gateway integration
* Event-driven integration
* External APIs

### Architecture

* Microservices
* CQRS
* Event Sourcing
* Read-model optimization

Future introduction of these capabilities SHALL preserve the Aggregate ownership model unless superseded through an approved Architecture Decision Record (ADR).

---

## Architecture Evolution Principles

The architecture is expected to evolve incrementally while preserving the approved Product Specification.

Future architectural evolution SHALL:

* preserve single ownership of business truth;
* preserve Aggregate autonomy;
* preserve historical integrity;
* maintain clear module boundaries;
* avoid unnecessary coupling; and
* be governed through approved ADRs.

Business evolution SHALL continue to be governed independently through RFCs.

---

## Implementation Readiness

This Aggregate Design establishes the architectural contract for implementation.

All implementation decisions are expected to preserve the ownership boundaries, Aggregate responsibilities and interaction rules defined within this document.

Subsequent architecture documents provide additional guidance on software organization and application orchestration but SHALL NOT redefine Aggregate ownership or business responsibilities.

---

# Conclusion

Together with the Product Specification, Architecture Decision Records and supporting Architecture documents, this Aggregate Design forms the authoritative domain architecture for the Student Fee Receivables Platform.

Implementation is expected to faithfully realize this architecture while remaining independent of any specific programming language, framework or persistence technology.

Architectural modifications affecting Aggregate ownership, consistency boundaries or architectural principles SHALL be introduced only through an approved Architecture Decision Record.
