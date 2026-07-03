# E-Fee Product & Engineering Specification

# Modelling Decision Log

```yaml id="n4pkx8"
---
document_id: MODEL-DECISION-001
title: Modelling Decision Log
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: As Required

related_documents:
  - BusinessObjectGraph.md
  - SoftwareDomainModel.md
  - BusinessRules.md
  - BusinessWorkflow.md
---
```

---

# Purpose

This document records the significant modelling decisions that shaped the E-Fee business and software models.

Its purpose is to preserve the reasoning behind important conceptual decisions so that future contributors understand **why the model was designed the way it is**, rather than repeatedly revisiting previously resolved discussions.

Architecture Decision Records (ADRs) describe architectural decisions.

This document records the modelling decisions that establish the foundation upon which those architectural decisions are made.

---

# Scope

This document records decisions related to:

* Business modelling.
* Software domain modelling.
* Conceptual boundaries.
* Responsibility ownership.
* Long-term modelling principles.

Routine editorial changes and implementation details should not be recorded here.

---

# Modelling Decisions

## MD-001 — Fee Obligation Represents Financial Responsibility

**Status:** Accepted

### Decision

A Fee Obligation represents a Student's financial responsibility rather than an individual payment or transaction.

### Reason

Financial responsibility exists independently of payment.

Payments settle obligations; they do not create them.

### Primary References

* BusinessObjectGraph.md
* SoftwareDomainModel.md
* BusinessRules.md

---

## MD-002 — Fee Structure Governs Fee Obligations

**Status:** Accepted

### Decision

A Fee Structure governs the standard Fee Obligations applicable to a Student.

Fee Structures define charging policy rather than creating financial transactions.

### Reason

Charging policy should remain independent of operational financial activity.

### Primary References

* BusinessObjectGraph.md
* SoftwareDomainModel.md

---

## MD-003 — Fee Component Is Shared Across Policy and Responsibility

**Status:** Accepted

### Decision

Fee Components represent the institution's common financial vocabulary.

The same Fee Components are shared between Fee Structures and Fee Obligations.

### Reason

The institution should describe financial categories consistently, regardless of whether they are defining policy or recording an individual Student's financial responsibility.

### Primary References

* BusinessObjectGraph.md
* DomainGlossary.md

---

## MD-004 — Obligation Line Is a Software Domain Concept

**Status:** Accepted

### Decision

Obligation Line exists only within the Software Domain Model.

It is not a first-class Business Object.

### Reason

Operational state for individual Fee Components must be preserved by software, but does not represent an independent business concept.

### Primary References

* SoftwareDomainModel.md

---

## MD-005 — Payment Allocation Represents Relationship State

**Status:** Accepted

### Decision

Payment Allocation is introduced as a Software Domain Concept representing the relationship between a Payment and one or more Obligation Lines.

### Reason

Allocation information belongs to the relationship itself rather than to either participating concept.

### Primary References

* SoftwareDomainModel.md
* BusinessRules.md

---

## MD-006 — Receipt Is a First-Class Business Object

**Status:** Accepted

### Decision

Receipt remains a first-class Business Object.

### Reason

A Receipt possesses its own identity, preserves financial evidence and maintains an independent lifecycle that extends beyond simple payment acknowledgement.

### Primary References

* BusinessObjectGraph.md
* SoftwareDomainModel.md

---

## MD-007 — Business Workflow Is Organised Around Business Operations

**Status:** Accepted

### Decision

The Business Workflow describes the institution's business operations rather than software processes or lifecycle states.

### Reason

Business operations remain stable even as software implementation evolves.

### Primary References

* BusinessWorkflow.md

---

## MD-008 — Business Object Graph Contains Only Enduring Business Objects

**Status:** Accepted

### Decision

The Business Object Graph contains only first-class Business Objects and their enduring conceptual relationships.

Business operations, reports, lifecycle states and implementation concepts are intentionally excluded.

### Reason

The conceptual model should describe **what exists**, not **what happens**.

### Primary References

* BusinessObjectGraph.md

---

## MD-009 — Software Preserves the Business Model

**Status:** Accepted

### Decision

The Software Domain Model preserves business concepts rather than redefining them.

Software-specific concepts may be introduced only where necessary to preserve operational state or consistency.

### Reason

Business knowledge should remain independent of implementation technology.

Software should faithfully represent the business rather than reshape it.

### Primary References

* SoftwareDomainModel.md

---

## MD-010 — Layered Modelling Progression

**Status:** Accepted

### Decision

The specification follows a layered modelling approach:

1. Business Rules
2. Business Workflow
3. Business Object Graph
4. Software Domain Model

Each layer builds upon the previous one without duplicating its responsibilities.

### Reason

Separating business constraints, business operations, conceptual structure and software representation produces a clearer, more maintainable specification.

### Primary References

* BusinessRules.md
* BusinessWorkflow.md
* BusinessObjectGraph.md
* SoftwareDomainModel.md

---

# Guiding Principle

Every modelling decision should answer one question:

> **Why is the model designed this way?**

Implementation details belong in architecture and code.

Modelling decisions preserve the reasoning behind the conceptual structure of the product.

---

# Related Documents

* BusinessRules.md
* BusinessWorkflow.md
* BusinessObjectGraph.md
* SoftwareDomainModel.md
* adr/

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                   |
| ------- | ---------- | --------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial decision log                                                                          |
| 1.1.0   | 2026-07-03 | Replaced repository conventions with long-term modelling decisions established during Gate 2. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
