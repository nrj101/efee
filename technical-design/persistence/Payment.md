# Payment Aggregate Persistence Model

```yaml
---
document_id: TD-PAYMENT-001
title: Payment Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

related_documents:
  - ../../architecture/aggregates/Payment.md
  - ../../architecture/technical-specification/aggregates/Payment.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Payment Aggregate**.

It specifies the complete persistent state required to preserve the business truth owned by the Payment Aggregate.

This document is derived from the approved Software Domain Model, Software Architecture and Aggregate Technical Specification.

It SHALL NOT introduce new business behaviour or architectural responsibilities.

---

# Aggregate

**Payment**

---

# Aggregate Responsibility

Persist the information owned by the Payment Aggregate while preserving:

- Payment identity;
- accepted Payment;
- payment evidence;
- payer information;
- Payment lifecycle.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| paymentId | String | Yes | No | Unique Payment identifier. | Payment ATS |
| amount | BigDecimal | Yes | No | Amount of money accepted by the institution. | Payment ATS |
| paymentMethod | String | Yes | No | Method by which the Payment was received. | Payment ATS |
| payerInformation | String | Yes | No | Information identifying the payer. | Payment ATS |
| status | String | Yes | Yes | Payment lifecycle state. | Payment ATS |
| financialReference | String | No | No | External financial reference, if applicable. | Payment ATS |

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Payment Aggregate maintains no persistent references to collaborating Aggregates.

Collaborations with Student, Fee Obligation and Receipt occur through business processes while preserving Aggregate ownership boundaries.

---

# Persistence Constraints

The implementation SHALL preserve:

- Payment identity;
- accepted Payment;
- payment evidence;
- payer information;
- Payment lifecycle;
- Aggregate ownership.

The implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability.

The Payment Aggregate SHALL NOT persist settlement information.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Technology Independence

This document intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- indexes;
- constraints specific to any persistence technology.

These concerns belong to subsequent Technical Design documents.

---

# Traceability

| Persistent Field | Traceability |
|------------------|--------------|
| paymentId | Payment Aggregate Technical Specification |
| amount | Payment Aggregate Technical Specification |
| paymentMethod | Payment Aggregate Technical Specification |
| payerInformation | Payment Aggregate Technical Specification |
| status | Payment Aggregate Technical Specification |
| financialReference | Payment Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Payment Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state or alternative representations.