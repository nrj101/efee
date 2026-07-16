# E-Fee Product & Engineering Specification

# Business Object Graph

```yaml
---
document_id: GRAPH-001
title: Business Object Graph
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-14
next_review: Before Specification v1.2.0

related_documents:
  - DomainGlossary.md
  - BusinessRules.md
  - BusinessWorkflow.md
  - SoftwareDomainModel.md
  - rfc/RFC-001-Financial-Truth-Model.md
  - rfc/RFC-007-Discount-Model-Simplification.md
---
```

---

# Purpose

The Business Object Graph defines the conceptual structure of the E-Fee business domain by identifying its first-class business objects and the enduring conceptual relationships between them.

It provides the authoritative conceptual model of the student fee receivables domain and serves as the foundation for the Software Domain Model, Aggregate Design and subsequent technical specifications.

---

# Scope

## In Scope

This document defines:

- First-class business objects.
- Enduring conceptual relationships.
- High-level organization of the student fee receivables domain.

---

## Out of Scope

This document intentionally excludes:

- Business workflows
- Business processes
- Operational sequences
- Lifecycle state transitions
- Reporting
- User interface concepts
- Software architecture
- Database design
- Implementation technology

Operational concepts such as Payment Allocation, Applied Discount, Financial Corrections and Approval workflows are defined elsewhere because they represent business activities or supporting concepts rather than first-class business objects.

---

# Conceptual Business Graph

![E-Fee Business Object Graph (Conceptual Model)](/spec/BusinessObjectGraph.png)

The conceptual graph organizes the domain into four logical regions:

- Educational Context
- Financial Policy
- Financial Responsibility
- Financial Activity

Fee Obligation remains the conceptual centre of the business domain by connecting Students, Academic Years, institutional charging policies and financial activities.

---

# Reading the Graph

The graph represents enduring business relationships.

It is **not** a workflow, lifecycle model or implementation design.

Business behaviour is described in **BusinessWorkflow.md**.

Business constraints are defined in **BusinessRules.md**.

Software realization is defined in **SoftwareDomainModel.md**.

---

# Business Objects

## Student

Represents the institution's long-term financial relationship with an individual.

A Student may participate in multiple Academic Years and incur Fee Obligations throughout that relationship.

---

## Academic Year

Represents the operational period during which the institution conducts academic and financial activities.

An Academic Year provides the business context for Fee Structures and Fee Obligations.

---

## Fee Structure

Represents the institution's standard charging policy for a category of Students within an Academic Year.

A Fee Structure consists of one or more Fee Components.

---

## Fee Component

Represents a financial category recognised by the institution, such as Tuition Fee, Library Fee or Laboratory Fee.

Fee Components belong to a Fee Structure and define the standard categories from which individual Fee Obligations are constructed.

---

## Fee Obligation

Represents a Student's financial responsibility for an Academic Year.

A Fee Obligation is established from the applicable Fee Structure, itemized by Fee Components, reduced through approved concessions and settled through Payments.

---

## Discount Policy

Represents the institution's reusable policy governing financial concessions.

A Discount Policy defines eligibility and calculation rules but does not itself reduce a Student's financial responsibility.

---

## Discount Grant

Represents an approved authorization granting a Student entitlement to a financial concession under a Discount Policy.

A Discount Grant establishes eligibility but does not directly modify a Fee Obligation.

---

## Payment

Represents a payer's intention to settle one or more Fee Obligations.

A Payment progresses through its operational lifecycle before contributing to financial settlement.

---

## Receipt

Represents the institution's official acknowledgement of an accepted Payment.

A Receipt preserves permanent evidence that a Payment has been accepted.

---

# Conceptual Relationships

## Student ↔ Academic Year

A Student participates in one or more Academic Years.

---

## Student ↔ Fee Obligation

A Student incurs Fee Obligations through participation in an Academic Year.

---

## Academic Year ↔ Fee Structure

Each Academic Year operates under one or more approved Fee Structures.

---

## Fee Structure ↔ Fee Component

A Fee Structure consists of one or more Fee Components.

Fee Components belong exclusively to their owning Fee Structure.

---

## Fee Structure ↔ Fee Obligation

Fee Structures establish the standard charging policy from which Fee Obligations are created.

---

## Fee Component ↔ Fee Obligation

Fee Obligations are itemized using Fee Components defined by the governing Fee Structure.

---

## Discount Policy ↔ Discount Grant

A Discount Policy governs one or more Discount Grants.

---

## Discount Grant ↔ Student

A Discount Grant is approved for a specific Student.

---

## Discount Grant ↔ Fee Obligation

Approved Discount Grants may contribute to reducing the financial responsibility represented by a Fee Obligation.

---

## Payment ↔ Fee Obligation

Payments contribute to settling Fee Obligations.

The detailed allocation of Payments across obligations is defined outside this conceptual model.

---

## Receipt ↔ Payment

Receipts acknowledge accepted Payments.

---

# Key Modelling Decisions

- The Business Object Graph contains only first-class business objects.
- Business operations are intentionally excluded.
- Supporting operational concepts are modeled separately.
- Fee Structures define institutional charging policy.
- Fee Components belong exclusively to Fee Structures.
- Fee Obligations represent Student financial responsibility.
- Discount Policies define institutional concession rules.
- Discount Grants authorize Student-specific concessions.
- Receipts represent enduring financial evidence.
- The Business Object Graph remains independent of implementation technology.

---

# Related Documents

- DomainGlossary.md
- BusinessRules.md
- BusinessWorkflow.md
- SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|---------|------------|-------------|
| 1.0.0 | 2026-06-29 | Initial approved version. |
| 1.1.0 | 2026-07-03 | Polished terminology, aligned with Gate 2 consolidation and standardized document structure. |
| 1.2.0 | 2026-07-14 | Aligned the conceptual model with the reconciled business specification by introducing Discount Policy and Discount Grant, refining conceptual relationships and clarifying the distinction between enduring business objects and operational concepts. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14