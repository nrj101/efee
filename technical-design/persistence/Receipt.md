# Receipt Aggregate Persistence Model

```yaml
---
document_id: TD-RECEIPT-001
title: Receipt Aggregate Persistence Model
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-14

related_documents:
  - ../../architecture/aggregates/Receipt.md
  - ../../technical-specification/aggregates/Receipt.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Receipt Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Receipt Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Receipt**

---

# Aggregate Responsibility

Persist the business truth owned by the Receipt Aggregate while preserving:

- Receipt identity
- Payment acknowledgement
- Receipt number
- Receipt lifecycle
- Correction history

Business truths owned by collaborating Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| receiptIdentifier | String | Yes | No | Unique Receipt identifier | Receipt ATS |
| paymentIdentifier | String | Yes | No | Accepted Payment being acknowledged | Receipt ATS |
| receiptNumber | String | Yes | No | Institution-issued business receipt number | Receipt ATS |
| acknowledgementTimestamp | Instant | Yes | No | Official acknowledgement timestamp | Receipt ATS |
| lifecycleState | Receipt Lifecycle | Yes | Yes | Current Receipt lifecycle | Receipt ATS |
| correctionHistory | Correction History | Yes | Yes | Historical Receipt corrections | Receipt ATS |

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

The Receipt Aggregate persists references to collaborating Aggregates only where required.

| Aggregate | Persistent Reference |
|-----------|----------------------|
| Payment | paymentIdentifier |

The Receipt Aggregate SHALL NOT persist:

- Payment Amount
- Payment Method
- Payment Allocation
- Fee Obligation information
- Student information

These business truths remain owned by collaborating Aggregates.

---

# Persistence Constraints

Implementation SHALL preserve:

- Receipt identity
- Payment acknowledgement
- Receipt number
- Receipt lifecycle
- Correction history
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist Payment information owned by the Payment Aggregate;
- persist Fee Obligation information;
- persist undocumented Aggregate state.

Receipt identifiers SHALL remain unique.

Historical Receipt information SHALL remain permanently auditable.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `receiptIdentifier` remains immutable after creation.
- `paymentIdentifier` remains immutable after creation.
- `receiptNumber` remains immutable after creation.
- `acknowledgementTimestamp` preserves the original acknowledgement time.
- `lifecycleState` accurately represents the approved Aggregate lifecycle.
- `correctionHistory` preserves every approved correction without destroying historical information.

The persisted state represents only the institution's official acknowledgement of an accepted Payment.

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
| receiptIdentifier | Receipt ATS |
| paymentIdentifier | Receipt ATS |
| receiptNumber | Receipt ATS |
| acknowledgementTimestamp | Receipt ATS |
| lifecycleState | Receipt ATS |
| correctionHistory | Receipt ATS |

---

# Notes

This document represents the complete approved persistent representation of the Receipt Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- altering approved ownership boundaries;
- persisting business truths owned by collaborating Aggregates;
- introducing alternative persistent representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Aligned with Receipt ATS v1.1.0. Standardized field names, introduced receipt number and acknowledgement timestamp, clarified ownership boundaries, added Persistent Representation Rules and strengthened traceability. |

---

# Approval

**Status:** Approved