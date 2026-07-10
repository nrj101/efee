# Receipt Aggregate Persistence Model

```yaml
---
document_id: TD-RECEIPT-001
title: Receipt Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

related_documents:
  - ../../architecture/aggregates/Receipt.md
  - ../../architecture/technical-specification/aggregates/Receipt.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Receipt Aggregate**.

It specifies the complete persistent state required to preserve the business truth owned by the Receipt Aggregate.

This document is derived from the approved Software Domain Model, Software Architecture and Aggregate Technical Specification.

It SHALL NOT introduce new business behaviour or architectural responsibilities.

---

# Aggregate

**Receipt**

---

# Aggregate Responsibility

Persist the information owned by the Receipt Aggregate while preserving:

- Receipt identity;
- acknowledgement of an accepted Payment;
- Receipt lifecycle;
- acknowledgement history;
- correction history.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| receiptId | String | Yes | No | Unique Receipt identifier. | Receipt ATS |
| paymentId | String | Yes | No | Identifies the acknowledged Payment. | Receipt ATS |
| status | String | Yes | Yes | Receipt lifecycle state. | Receipt ATS |
| acknowledgementHistory | List<ReceiptAcknowledgement> | Yes | Yes | Historical acknowledgement information. | Receipt ATS |
| correctionHistory | List<ReceiptCorrection> | Yes | Yes | Historical correction information. | Receipt ATS |

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Receipt Aggregate persists a reference to the acknowledged Payment.

| Aggregate | Reference |
|-----------|-----------|
| Payment | paymentId |

This reference preserves Aggregate ownership boundaries.

The Receipt Aggregate SHALL NOT persist business state owned by the Payment Aggregate.

---

# Persistence Constraints

The implementation SHALL preserve:

- Receipt identity;
- Payment reference;
- Receipt lifecycle;
- acknowledgement history;
- correction history;
- Aggregate ownership.

The implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability.

Receipt identifiers SHALL remain unique.

Receipt history SHALL remain permanently auditable.

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
| receiptId | Receipt Aggregate Technical Specification |
| paymentId | Receipt Aggregate Technical Specification |
| status | Receipt Aggregate Technical Specification |
| acknowledgementHistory | Receipt Aggregate Technical Specification |
| correctionHistory | Receipt Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Receipt Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state or alternative representations.