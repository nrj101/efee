# E-Fee Product & Engineering Specification

# Software Domain Model

```yaml
---
document_id: SDM-001
title: Software Domain Model
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - BusinessObjectGraph.md
  - DomainGlossary.md
  - BusinessRules.md
  - BusinessWorkflow.md
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

* Software representations of conceptual business objects.
* Software-only concepts required to preserve business state.
* Ownership of business truths.
* Responsibilities of software concepts.
* Collaboration between software concepts.
* High-level consistency principles.

---

## Out of Scope

This document intentionally excludes:

* User interface design.
* Database schema.
* REST APIs.
* Messaging and integration.
* Framework-specific implementation.
* Deployment architecture.
* Infrastructure concerns.

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

The long-term financial identity of an individual student.

### Software Preserves

* Stable identity.
* Student information required by the financial domain.
* References to financial relationships.

### Does Not Preserve

* Fee calculations.
* Outstanding balances.
* Payments.
* Receipts.

---

## Academic Year

### Represents

The operational boundary within which financial activity occurs.

### Software Preserves

* Identity.
* Operational period.
* Applicable Fee Structure.
* Academic Year lifecycle.

---

## Fee Structure

### Represents

The institution's charging policy.

### Software Preserves

* Versioned charging policy.
* Collection of Fee Components.
* Policy metadata.
* Applicability rules.

---

## Fee Component

### Represents

A financial category recognised by the institution.

### Software Preserves

* Identity.
* Name.
* Ordering.
* Policy metadata.

Fee Components intentionally do not preserve student-specific financial state.

---

## Fee Obligation

### Represents

A Student's financial responsibility.

### Software Preserves

* Applicable Student.
* Applicable Academic Year.
* Governing Fee Structure.
* Collection of Obligation Lines.
* Overall financial state.
* Overall lifecycle.

Fee Obligation owns responsibility for preserving the Student's financial position.

---

## Obligation Line *(Software Concept)*

### Purpose

Represents the operational state of a single Fee Component within a Fee Obligation.

### Software Preserves

* Referenced Fee Component.
* Original amount.
* Outstanding amount.
* Operational status.
* Applied Discounts.
* Applied settlements.

This concept exists because operational state cannot naturally be preserved by Fee Component itself.

---

## Payment

### Represents

Money received by the institution towards settlement of one or more Fee Obligations.

### Software Preserves

* Payment identity.
* Amount received.
* Payment method.
* Payer information.
* Operational status.
* Financial references.

Payment intentionally does not preserve settlement information.

---

## Payment Allocation *(Software Concept)*

### Purpose

Represents the operational relationship between a Payment and one or more Obligation Lines.

### Software Preserves

* Payment reference.
* Obligation Line reference.
* Allocated amount.
* Allocation timestamp.
* Allocation policy (where applicable).

This concept exists because allocation information belongs to the relationship rather than either participating concept.

---

## Receipt

### Represents

The institution's official acknowledgement of an accepted Payment.

### Software Preserves

* Receipt identity.
* Receipt lifecycle.
* Acknowledgement history.
* Correction history.

Receipt owns acknowledgement—not settlement.

---

## Discount

### Represents

An authorised reduction granted to a Student.

### Software Preserves

* Discount identity.
* Eligibility.
* Reduction rules.
* Applicable Fee Components.
* Granted lifecycle.

Discount owns entitlement—not financial responsibility.

---

# Collaboration Principles

Software Domain Concepts collaborate to implement business operations while preserving clear ownership boundaries.

The following principles govern that collaboration:

* Ownership of business truth never changes.
* Concepts collaborate through well-defined operations rather than direct state manipulation.
* Responsibilities remain local to the concept that owns the corresponding business truth.
* Business processes emerge from collaboration rather than centralised ownership.

Examples include:

* Payment Allocations request Fee Obligations to apply settlements.
* Discounts request Fee Obligations to apply authorised reductions.
* Receipts acknowledge accepted Payments.
* Fee Obligations derive their overall financial state from their Obligation Lines.

---

# Initial Consistency Rules

The Software Domain Model preserves the following business truths.

## Fee Obligation

* Outstanding amount shall never become negative.
* Overall outstanding amount shall equal the combined outstanding amount of all Obligation Lines.
* Overall status shall be derived from the state of its Obligation Lines.

---

## Obligation Line

* Outstanding amount shall never exceed the original obligation.
* Settlement shall never exceed the remaining outstanding amount.

---

## Payment

* Total Payment Allocations shall never exceed the received Payment amount.
* Settlement shall occur only after the Payment has been successfully received by the institution.

---

## Receipt

* A Receipt acknowledges exactly one accepted Payment.
* Receipt corrections shall preserve audit history.

---

## Discount

* A Discount shall reduce only authorised Fee Components.
* Applied reductions shall never exceed the amount eligible for reduction.

---

# Future Evolution

Subsequent sections of the Software Domain Model will define:

* Aggregate boundaries.
* Aggregate Roots.
* Domain operations.
* Lifecycle models.
* Domain services.
* Domain events.

Those decisions will build upon the Software Domain Concepts established in this document without altering the underlying conceptual business model.

---

# Key Decisions

* Software preserves the business model rather than redefining it.
* Every first-class Business Object normally has a corresponding Software Domain Concept.
* Software-only concepts are introduced only where operational state requires explicit representation.
* Each Software Domain Concept owns exactly one primary business truth.
* Business processes emerge through collaboration rather than shared ownership.
* Consistency requirements determine software structure.

---

# Related Documents

* BusinessObjectGraph.md
* DomainGlossary.md
* BusinessRules.md
* BusinessWorkflow.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                                                  |
| ------- | ---------- | ---------------------------------------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                                                     |
| 1.1.0   | 2026-07-03 | Standardised structure, strengthened translation principles and aligned terminology with the completed Gate 2 specification. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
