# E-Fee Product & Engineering Specification

# Software Domain Model

```yaml
---
document_id: SDM-001
title: Software Domain Model
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-14
next_review: Before Specification v2.0.0

related_documents:
  - BusinessObjectGraph.md
  - DomainGlossary.md
  - BusinessRules.md
  - BusinessWorkflow.md
  - rfc/RFC-001-Financial-Truth-Model.md
---
```

---

# Purpose

The Software Domain Model defines how the conceptual business model is represented within software while preserving the business concepts and relationships established by the Business Object Graph.

Its purpose is not to redefine the business, but to describe how software faithfully preserves business truths, enforces business rules and maintains consistency throughout the lifetime of the system.

This document serves as the bridge between the conceptual business model and the software architecture.

---

# Scope

## In Scope

This document defines:

- Software representations of conceptual business objects.
- Software-only concepts required to preserve business state.
- Ownership of business truths.
- Responsibilities of software concepts.
- Collaboration between software concepts.
- High-level consistency principles.

---

## Out of Scope

This document intentionally excludes:

- User interface design.
- Database schema.
- REST APIs.
- Messaging and integration.
- Framework-specific implementation.
- Deployment architecture.
- Infrastructure concerns.

> **Note**
>
> Software concepts introduced in this document exist solely to preserve the conceptual business model. They neither redefine nor extend the business domain.

---

# Translation Principles

The Software Domain Model is derived directly from the Business Object Graph and follows the principles below.

---

## Preserve the Business

Every Software Domain Concept must preserve an existing business concept or business truth.

Software exists to implement the business model—not redefine it.

---

## One Business Concept, One Software Representation

Every first-class Business Object normally has a corresponding Software Domain Concept.

Additional Software Domain Concepts may be introduced only when software must explicitly preserve operational state or relationships that are implicit within the conceptual business model.

---

## Introduce Software Concepts Only When Necessary

Software-only concepts exist only when existing business objects cannot naturally preserve the operational state required by the system.

Such concepts support the implementation of the business model but are not promoted to first-class business objects.

---

## Single Ownership of Business Truth

Each Software Domain Concept owns exactly one primary business truth.

Other concepts collaborate with it but do not directly modify that truth.

---

## Collaboration Over Ownership

Business processes emerge through collaboration between Software Domain Concepts.

No concept should assume responsibility for another concept's business truth.

---

## Protect Consistency

Software responsibilities exist to preserve business consistency.

Consistency requirements should determine software structure rather than implementation convenience.

---

# Software Domain Concepts

## Student

### Represents

The long-term financial identity of an individual Student.

### Software Preserves

- Stable identity.
- Student information required by the financial domain.
- References to financial relationships.

### Does Not Preserve

- Fee calculations.
- Outstanding balances.
- Payments.
- Receipts.

---

## Academic Year

### Represents

The operational boundary within which financial activity occurs.

### Software Preserves

- Identity.
- Operational period.
- Applicable Fee Structure.
- Academic Year lifecycle.

---

## Fee Structure

### Represents

The institution's charging policy.

### Software Preserves

- Versioned charging policy.
- Collection of Fee Components.
- Policy metadata.
- Applicability rules.

---

## Fee Component

### Represents

A financial category recognised by the institution.

### Software Preserves

- Identity.
- Name.
- Ordering.
- Policy metadata.

Fee Components intentionally do not preserve Student-specific financial state.

---

## Fee Obligation

### Represents

A Student's financial responsibility.

### Software Preserves

- Applicable Student.
- Applicable Academic Year.
- Governing Fee Structure.
- Collection of Obligation Lines.
- Derived financial position.
- Aggregate lifecycle.

Fee Obligation owns the Student's financial responsibility.

Its current financial position is derived from the financial facts preserved within the Aggregate.

---

## Obligation Line *(Software Concept)*

### Purpose

Represents the operational state of a single Fee Component within a Fee Obligation.

### Software Preserves

- Referenced Fee Component.
- Original amount.
- Applied Discount references.
- Applied Settlement references.
- Operational lifecycle.

This concept exists because operational state cannot naturally be preserved by Fee Component itself.

---

## Payment

### Represents

Money received by the institution towards settlement of one or more Fee Obligations.

### Software Preserves

- Payment identity.
- Amount received.
- Payment method.
- Payer information.
- Payment lifecycle.
- Financial references.

Payment intentionally does not preserve settlement information.

---

## Payment Allocation *(Software Concept)*

### Purpose

Represents the financial application of a realised Payment to one or more Obligation Lines owned by a Fee Obligation.

Payment Allocation is an immutable financial fact owned by the Fee Obligation Aggregate.

It references a realised Payment while preserving the Fee Obligation's financial history.

### Software Preserves

- Payment reference
- Obligation Line reference
- Allocated amount
- Allocation timestamp
- Allocation reason (where applicable)

Payment Allocation exists because the financial settlement of a Fee Obligation belongs to the Fee Obligation Aggregate rather than to the Payment itself.

Corrections preserve historical auditability by introducing new financial facts rather than modifying existing Payment Allocations.

---

## Applied Discount *(Software Concept)*

### Purpose

Represents the financial application of an approved Discount to one or more Obligation Lines owned by a Fee Obligation.

Applied Discount is an immutable financial fact owned by the Fee Obligation Aggregate.

### Software Preserves

- Discount reference
- Obligation Line reference
- Applied discount amount
- Application timestamp
- Application reason (where applicable)

Applied Discount exists because the financial effect of a Discount belongs to the Fee Obligation's financial history rather than to the Discount Aggregate.

The Discount Aggregate preserves only the approved entitlement.

The Fee Obligation Aggregate preserves the financial effect of that entitlement.

---

## Receipt

### Represents

The institution's official acknowledgement of an accepted Payment.

### Software Preserves

- Receipt identity.
- Receipt lifecycle.
- Acknowledgement history.
- Correction history.

Receipt owns acknowledgement—not settlement.

---

## Discount

### Represents

An approved financial concession granted to a Student.

### Software Preserves

- Discount identity
- Student reference
- Approved concession value
- Approval information
- Business justification
- Discount lifecycle

The Discount Aggregate owns the approved entitlement to a financial concession.

It intentionally does not own:

- Fee Obligations
- Applied Discounts
- Outstanding Amount
- Payment Allocations

The financial effect of a Discount is realised only through Applied Discounts owned by the Fee Obligation Aggregate.

---

# Collaboration Principles

Software Domain Concepts collaborate to implement business operations while preserving clear ownership boundaries.

The following principles govern that collaboration.

- Ownership of business truth never changes.
- Concepts collaborate through well-defined operations rather than direct state manipulation.
- Responsibilities remain local to the concept that owns the corresponding business truth.
- Business processes emerge from collaboration rather than centralised ownership.

Examples include:

- Fee Obligations record Payment Allocations derived from realised Payments.
- Approved Discounts are applied through Applied Discounts owned by the Fee Obligation Aggregate.
- Receipts acknowledge accepted Payments.
- Collaborating concepts exchange identifiers or immutable financial facts. They SHALL NOT directly modify another Aggregate's owned state.

---

# Initial Consistency Rules

The Software Domain Model preserves the following business truths.

## Fee Obligation

- Financial position shall be derived from:
  - Original Obligation Lines.
  - Applied Discounts.
  - Payment Allocations.
- Outstanding Amount shall never become negative.
- Aggregate financial position shall remain reproducible from preserved financial facts.
- Aggregate lifecycle shall remain internally consistent.

---

## Final Settlement Obligation

A Final Settlement Obligation is a specialized Fee Obligation created when an Academic Year closes with outstanding receivables.

It preserves the remaining financial responsibility that survives Academic Year closure.

It does not introduce a new Software Domain Concept.

Instead, it represents a specialized lifecycle outcome of the Fee Obligation concept.

---

## Obligation Line

- Original Amount is immutable.
- Applied Discounts shall never exceed the Original Amount.
- Payment Allocations shall never exceed the remaining payable amount after authorised Discounts.
- Current outstanding position shall always be derivable from preserved financial facts.

---

## Payment

- Total Payment Allocations shall never exceed the received Payment amount.
- Settlement shall occur only after the Payment has been successfully realised.

---

## Receipt

- A Receipt acknowledges exactly one accepted Payment.
- Receipt corrections shall preserve audit history.

---

## Discount

- Every Discount shall preserve its approval information and business justification.
- A Discount may be applied only through the Fee Obligation Aggregate.
- Applying a Discount shall never transfer ownership of financial responsibility.

---

# Future Evolution

Subsequent sections of the Software Domain Model will define:

- Aggregate boundaries.
- Aggregate Roots.
- Domain operations.
- Lifecycle models.
- Domain services.
- Domain events.

These decisions will build upon the Software Domain Concepts established in this document without altering the underlying conceptual business model.

---

# Key Decisions

- Software preserves the business model rather than redefining it.
- Every first-class Business Object normally has a corresponding Software Domain Concept.
- Software-only concepts are introduced only where operational state requires explicit representation.
- Each Software Domain Concept owns exactly one primary business truth.
- Business processes emerge through collaboration rather than shared ownership.
- Financial position is derived from preserved financial facts rather than maintained as an independent business fact.
- Consistency requirements determine software structure.

---

# Related Documents

- BusinessObjectGraph.md
- DomainGlossary.md
- BusinessRules.md
- BusinessWorkflow.md
- RFC-001-Financial-Truth-Model.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|---------|------|-------------|
| 1.0.0 | 2026-06-29 | Initial approved version. |
| 1.1.0 | 2026-07-03 | Standardised structure, strengthened translation principles and aligned terminology with the completed Gate 2 specification. |
| 1.2.0 | 2026-07-14 | Aligned with RFC-001 Financial Truth Model and RFC-007 Discount Model Simplification. Clarified Aggregate ownership of Applied Discounts and Payment Allocations, strengthened collaboration principles, and standardised financial terminology. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14