# Cross Cutting Concerns

```yaml
---
document_id: ARCH-007
title: Cross Cutting Concerns
version: 1.0.0
status: Approved

owner: Solution Architect
reviewer: Product Owner

created: 2026-07-08
last_updated: 2026-07-08

related_documents:
  - SoftwareArchitecture.md
  - AggregateDesign.md
  - ApplicationServices.md
  - ../spec/docs/BusinessRules.md
  - ../spec/docs/SoftwareDomainModel.md
---
```

# 1. Purpose

This document defines architectural policies and design principles that apply across the entire E-Fee platform.

Unlike aggregate design or business rules, these concerns span multiple modules and ensure that all components behave consistently.

This document intentionally focuses on architectural policies rather than implementation details.

---

# 2. Scope

The policies described in this document apply to every domain module, aggregate, application service and future platform capability unless explicitly stated otherwise.

This document governs topics including:

- Aggregate identity
- Business reference numbering
- Business events
- Audit and traceability
- Monetary representation
- Time handling
- Transaction boundaries
- Versioning philosophy
- Authorization philosophy

---

# 3. Architectural Principles

The platform follows several cross-cutting architectural principles.

## Business First

Business concepts drive the software model.
Database structure and technical implementation must not dictate domain design.

## Single Source of Truth

Every business fact shall have a single authoritative owner.

Derived values may be persisted for performance but shall always be reproducible from authoritative business state.

## Immutable Financial History

Historical financial information shall never be destroyed.

Corrections replace modification.

Cancellation replaces deletion.

Auditability takes precedence over convenience.

## Explicit Business Rules

Business rules shall be implemented explicitly and remain independent of user interface or persistence technology.

---

# 4. Aggregate Identity Strategy

Every aggregate shall possess a system-generated immutable identifier.

The internal identifier:

- uniquely identifies the aggregate
- never changes during its lifetime
- is not intended for human interaction
- is used internally for relationships and persistence

Business-readable identifiers may additionally exist where required.

Examples include:

- Student Admission Number
- Receipt Number
- Academic Year Code

Business identifiers are independent from internal identities.

---

# 5. Number Generation Strategy

The platform distinguishes between two different identifier categories.

## Internal Identity

Internal identities uniquely identify business objects inside the system.

Characteristics:

- immutable
- system generated
- never reused
- never exposed as the primary business reference

## Business Reference Numbers

Business reference numbers are intended for human use.

Examples include:

- Student Admission Numbers
- Receipt Numbers
- Fee Receipt Books
- Academic Year Codes

These identifiers should remain meaningful to school staff and auditors.

## Existing Institution Migration

Many institutions already maintain existing numbering conventions.

The platform shall support migration without requiring institutions to restart numbering sequences.

Examples include:

- continuing existing receipt books
- continuing admission numbers
- continuing student identifiers

The objective is to minimise operational disruption during onboarding.

## Future Evolution

Future versions may introduce configurable Number Series to support:

- prefixes
- suffixes
- yearly reset
- campus-specific numbering
- document-specific numbering
- configurable formats

This capability is intentionally excluded from the MVP.

---

# 6. Business Event Catalogue

Business events describe meaningful business occurrences within the platform.

They form part of the ubiquitous language and are independent of messaging technologies.

Initial event catalogue:

| Event | Description |
|--------|-------------|
| StudentRegistered | A student has been successfully registered. |
| StudentUpdated | Student information has been modified. |
| AcademicYearOpened | Academic year becomes operational. |
| AcademicYearClosed | Academic year has been finalized. |
| FeeStructurePublished | Fee structure becomes active. |
| FeeObligationCreated | A receivable has been established. |
| DiscountGranted | Outstanding amount has been reduced. |
| PaymentRecorded | Payment has been received. |
| PaymentAllocated | Payment has been allocated to obligations. |
| ReceiptIssued | Official receipt has been generated. |

These events currently serve as business documentation.

Future versions may publish selected events through integration mechanisms.

---

# 7. Audit & Traceability

Financial operations shall remain fully traceable.

Where applicable, audit information should capture:

- who performed the action
- when it occurred
- business reason
- affected business object
- previous state (where appropriate)
- resulting state (where appropriate)

Financial history should favour append-only correction over destructive updates.

---

# 8. Time & Date Handling

Business time shall always be stored using a consistent platform standard.

Displayed values may follow institution preferences.

Business operations shall use server-side timestamps rather than client device clocks wherever possible.

---

# 9. Monetary Precision

All monetary values shall use fixed precision decimal representation.

Floating-point arithmetic shall never be used for financial calculations.

Currency handling is intentionally limited to Indian Rupees (INR) for the MVP.

Future versions may introduce multi-currency support without affecting the domain model.

---

# 10. Transaction Boundaries

Business operations should complete atomically within a single application transaction whenever possible.

Aggregate consistency shall be maintained immediately.

Cross-aggregate coordination shall be performed through application services.

---

# 11. Versioning Philosophy

Business objects that influence historical financial records should favour versioning over in-place modification.

Historical financial information must continue to reference the business rules that existed when it was created.

This principle particularly applies to fee structures and similar policy-driven entities.

---

# 12. Authorization Philosophy

Authorization decisions should be based upon business capabilities rather than user interface actions.

Roles determine available capabilities.

Capabilities determine permitted business operations.

Implementation technology remains independent of this policy.

---

# 13. Future Evolution

The following capabilities have been intentionally deferred beyond the MVP:

- Configurable Number Series
- Financial Transaction Identity
- Ledger-based accounting model
- External event publication
- Multi-campus numbering
- Multi-currency support

These capabilities should extend the architecture without requiring changes to existing business concepts.