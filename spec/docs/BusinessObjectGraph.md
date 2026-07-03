# E-Fee Product & Engineering Specification

# Business Object Graph

```yaml
---
document_id: GRAPH-001
title: Business Object Graph
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - DomainGlossary.md
  - BusinessRules.md
  - BusinessWorkflow.md
  - SoftwareDomainModel.md
---
```

---

# Purpose

The Business Object Graph defines the conceptual structure of the E-Fee business domain by identifying its first-class business objects and the enduring conceptual relationships between them.

It serves as the authoritative conceptual model produced during **Gate 2** and provides the conceptual foundation for all subsequent software design activities.

---

# Scope

## In Scope

This document defines:

* First-class business objects within the E-Fee domain.
* Enduring conceptual relationships between those objects.
* The conceptual organization of the student fee receivables domain.

---

## Out of Scope

This document intentionally excludes:

* Business workflows
* Business processes
* Lifecycle state transitions
* Reports and analytics
* User interface concepts
* Software architecture
* Database design
* Technology-specific implementation

> **Note**
>
> The absence of a concept from this document does not imply that it is unimportant.
>
> Concepts such as Payment Allocation, Financial Corrections, Approval, Reporting and operational workflows are intentionally documented elsewhere because they represent business operations, business rules or software concerns rather than enduring business objects.

---

# Conceptual Business Graph

![E-Fee Business Object Graph (Conceptual ModeL)](/spec/BusinessObjectGraph.png)

The conceptual graph organizes the domain into four logical regions:

* Educational Context
* Financial Policy
* Financial Responsibility
* Financial Activity

Fee Obligation forms the conceptual centre of the model by connecting the educational context, institutional financial policy and financial activity.

---

## Reading the Graph

The diagram should be interpreted as a **conceptual model**, not an operational workflow.

Each relationship expresses an enduring business truth rather than a sequence of activities.

Operational behaviour is described in **BusinessWorkflow.md**, while detailed business constraints are defined in **BusinessRules.md**.

---

# Business Objects

## Student

Represents the institution's long-term financial relationship with an individual.

A Student may participate in multiple Academic Years and incur Fee Obligations throughout that relationship.

---

## Academic Year

Represents the operational period during which the institution conducts its academic and financial activities.

An Academic Year provides the operational context in which Fee Obligations are established and managed.

---

## Fee Structure

Represents the institution's standard charging policy for a category of Students within an Academic Year.

A Fee Structure consists of one or more Fee Components.

---

## Fee Component

Represents a financial category recognised by the institution, such as Tuition Fee, Library Fee or Sports Fee.

Fee Components provide the common financial vocabulary shared between Fee Structures and Fee Obligations.

---

## Fee Obligation

Represents a Student's financial responsibility for an Academic Year.

A Fee Obligation is governed by a Fee Structure, itemized by Fee Components, reduced through Discounts and settled through Payments.

---

## Payment

Represents money received by the institution towards settlement of one or more Fee Obligations.

A Payment preserves the financial evidence of money received and participates in the settlement of outstanding financial responsibilities.

---

## Receipt

Represents the institution's official acknowledgement of an accepted Payment.

A Receipt provides financial evidence and preserves an auditable record of acknowledgement.

---

## Discount

Represents an authorised reduction to a Student's standard financial responsibility.

A Discount reduces one or more Fee Components within a Fee Obligation according to institutional policy.

---

# Conceptual Relationships

## Student ↔ Academic Year

A Student enrols in one or more Academic Years.

---

## Student ↔ Fee Obligation

A Student incurs Fee Obligations through participation in an Academic Year.

---

## Student ↔ Payment

A Student may make, benefit from or be associated with one or more Payments.

A single Payment may relate to multiple Students where institutional policy permits.

---

## Student ↔ Receipt

A Student receives Receipts acknowledging Payments made on their behalf.

---

## Student ↔ Discount

A Student may receive Discounts according to institutional policy.

---

## Academic Year ↔ Fee Structure

An Academic Year applies a Fee Structure.

---

## Academic Year ↔ Fee Obligation

Fee Obligations belong to an Academic Year.

---

## Fee Structure ↔ Fee Component

A Fee Structure consists of one or more Fee Components.

---

## Fee Structure ↔ Fee Obligation

A Fee Structure governs the standard Fee Obligations applicable to Students.

---

## Fee Component ↔ Fee Obligation

Fee Obligations are itemized by Fee Components.

Fee Components therefore provide the shared financial vocabulary connecting institutional charging policy with individual financial responsibility.

---

## Payment ↔ Fee Obligation

Payments settle Fee Obligations.

The manner in which a Payment is allocated across one or more Fee Obligations is governed by business policy and intentionally lies outside the scope of this conceptual model.

---

## Receipt ↔ Payment

Receipts acknowledge accepted Payments.

---

## Discount ↔ Fee Obligation

Discounts reduce Fee Obligations.

Institutional policy may apply Discounts to specific Fee Components within an obligation.

---

# Key Modelling Decisions

* The conceptual model contains only first-class business objects.
* Business operations are intentionally excluded.
* Business lifecycles do not automatically imply first-class business objects.
* Reports and analytics consume the conceptual model rather than shaping it.
* Fee Structure represents institutional charging policy.
* Fee Component represents the institution's shared financial vocabulary.
* Fee Obligation represents a Student's financial responsibility.
* Payment Allocation is treated as a business operation rather than a business object.
* Receipt is retained as a first-class business object because it represents enduring financial evidence.

---

# Related Documents

* DomainGlossary.md
* BusinessRules.md
* BusinessWorkflow.md
* SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                  |
| ------- | ---------- | -------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                     |
| 1.1.0   | 2026-07-03 | Polished terminology, aligned with Gate 2 consolidation and standardized document structure. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
