# Payment Aggregate Persistence Model

```yaml
---
document_id: TD-PAYMENT-001
title: Payment Aggregate Persistence Model
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-14

related_documents:
  - ../../architecture/aggregates/Payment.md
  - ../../technical-specification/aggregates/Payment.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Payment Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Payment Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Payment**

---

# Aggregate Responsibility

Persist the business truth owned by the Payment Aggregate while preserving:

- Payment identity
- Amount received
- Payment method
- Payer information
- Payment lifecycle
- Financial references

Business truths owned by collaborating Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| paymentIdentifier | String | Yes | No | Unique Payment identifier | Payment ATS |
| payerIdentifier | String | Yes | No | Payer reference | Payment ATS |
| paymentAmount | Monetary Amount | Yes | No | Amount received | Payment ATS |
| paymentMethod | Payment Method | Yes | No | Method of payment | Payment ATS |
| paymentReference | String | No | No | External payment reference | Payment ATS |
| lifecycleState | Payment Lifecycle | Yes | Yes | Current Payment lifecycle | Payment ATS |

No additional persistent state is approved.

---

# Derived State

None.

No persistent values are derived from other persisted state.

---

# Transient State

None.

---

# Relationships

The Payment Aggregate persists references to collaborating business concepts only where required.

| Aggregate | Relationship |
|-----------|--------------|
| Payer | payerIdentifier |

The Payment Aggregate does **not** persist:

- Payment Allocations
- Fee Obligation references
- Receipt references
- Outstanding Amount

These relationships belong to collaborating Aggregates.

---

# Persistence Constraints

Implementation SHALL preserve:

- Payment identity
- Payment amount
- Payment method
- Payer information
- Payment lifecycle
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist Payment Allocation information;
- persist Fee Obligation settlement information;
- persist Outstanding Amount;
- persist undocumented Aggregate state.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `paymentIdentifier` remains immutable after creation.
- `payerIdentifier` remains immutable after creation.
- `paymentAmount` remains immutable after creation.
- `paymentMethod` remains immutable after creation.
- `paymentReference` remains immutable after creation.
- `lifecycleState` accurately represents the approved Aggregate lifecycle.

The persisted state represents only the institutional record of the received Payment.

Settlement information is intentionally excluded.

---

# Technology Independence

This specification intentionally excludes:

- database schema
- SQL data types
- ORM mappings
- framework annotations
- repository implementation
- indexes
- vendor-specific persistence features

These concerns belong to later Technical Design documents.

---

# Traceability

| Persistent Field | Aggregate Technical Specification |
|------------------|-----------------------------------|
| paymentIdentifier | Payment ATS |
| payerIdentifier | Payment ATS |
| paymentAmount | Payment ATS |
| paymentMethod | Payment ATS |
| paymentReference | Payment ATS |
| lifecycleState | Payment ATS |

---

# Notes

This document represents the complete approved persistent representation of the Payment Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- persisting Payment Allocation information;
- altering approved ownership boundaries;
- introducing alternative persistent representations.

Payment Allocation remains intentionally outside the Payment Aggregate because settlement belongs to the relationship between Payments and Fee Obligations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Aligned with Payment ATS v1.1.0. Standardized field names, introduced lifecycleState, clarified ownership boundaries, added Persistent Representation Rules and explicitly excluded Payment Allocation from the Payment Aggregate persistence model. |

---

# Approval

**Status:** Draft