# Payment Aggregate Technical Specification

```yaml
---
document_id: ATS-PAYMENT-001
title: Payment Aggregate Technical Specification
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/PaymentManagement.md
  - ../../architecture/aggregates/Payment.md
---
```

---

# Purpose

This document defines the implementation-neutral technical specification for the Payment Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the technical obligations required to preserve money received by the institution while maintaining clear Aggregate ownership boundaries.

This specification defines the complete Aggregate contract while remaining independent of programming language, persistence technology and implementation framework.

---

# Aggregate Responsibility

The Payment Aggregate owns the institutional record of money received from a payer.

It preserves:

- Payment identity
- Amount received
- Payment method
- Payer information
- Payment lifecycle
- Financial references

The Payment Aggregate owns the receipt of money only.

It intentionally does **not** own:

- Student financial responsibility
- Payment Allocation
- Fee Obligation settlement
- Receipt acknowledgement

The financial effect of a Payment is realised only through Payment Allocations owned by the Fee Obligation Aggregate.

---

# Owned State

The Aggregate owns the following state.

| Field | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| paymentIdentifier | String | Yes | No | Unique Payment identifier |
| payerIdentifier | String | Yes | No | Payer reference |
| paymentAmount | Monetary Amount | Yes | No | Amount received |
| paymentMethod | Payment Method | Yes | No | Method of payment |
| paymentReference | String | No | No | External payment reference |
| lifecycleState | Payment Lifecycle | Yes | Yes | Current lifecycle state |

---

# Aggregate Does Not Own

The Aggregate SHALL NOT own:

- Fee Obligations
- Payment Allocations
- Outstanding Amount
- Receipts
- Discounts
- Student financial responsibility

These business truths remain owned by collaborating Aggregates.

---

# Ownership Boundaries

The Payment Aggregate owns only the accepted Payment.

Application of a Payment to Fee Obligations shall occur only through Payment Allocations.

The Payment Aggregate SHALL NOT directly modify Fee Obligations or Outstanding Amounts.

---

# Public API

## Constructor

```
Payment(
    paymentIdentifier,
    payerIdentifier,
    paymentAmount,
    paymentMethod,
    paymentReference
)
```

Creates a new Payment in the Recorded lifecycle state.

---

## Business Operations

```
realise()
```

Marks the Payment as successfully realised.

Only realised Payments may be allocated.

---

```
cancel()
```

Transitions the Payment into the Cancelled lifecycle state where permitted by business policy.

---

## Accessors

```
getPaymentIdentifier()

getPayerIdentifier()

getPaymentAmount()

getPaymentMethod()

getPaymentReference()

getLifecycleState()
```

No additional public operations are approved by this specification.

---

# Business Invariants

Implementation SHALL preserve the following invariants.

- Payment Identifier is immutable.
- Payment Amount is immutable.
- Payment Method is immutable.
- Payment Amount shall never be negative.
- Only realised Payments may be allocated.
- Payment history shall remain preserved.
- Aggregate ownership shall always be preserved.

---

# Lifecycle

The Aggregate supports the following lifecycle.

```
Recorded
    │
    ▼
Realised
```

or

```
Recorded
    │
    ▼
Cancelled
```

Lifecycle transitions are irreversible.

Historical Payments remain permanently preserved.

---

# Consistency Requirements

Implementation SHALL preserve:

- Payment identity integrity
- Payment amount integrity
- Financial evidence integrity
- Lifecycle integrity
- Aggregate ownership

Settlement information shall remain externally reproducible through Payment Allocations.

---

# Implementation Obligations

| Obligation | Type | Source |
|------------|------|--------|
| Preserve Payment identity | State | Software Domain Model |
| Preserve Payment amount | State | Software Domain Model |
| Preserve Payment method | State | Software Domain Model |
| Preserve payer information | State | Software Domain Model |
| Preserve lifecycle integrity | Lifecycle | Aggregate Design |
| Preserve Aggregate ownership | Architecture | Aggregate Design |
| Preserve financial evidence | Business Rule | Business Rules |

---

# Collaboration Contract

The Payment Aggregate collaborates with:

- Student
- Fee Obligation
- Receipt

Collaborations occur only through Aggregate references.

The Payment Aggregate exposes Payment information required by collaborating Aggregates.

Settlement responsibilities remain outside this Aggregate and are realised through Payment Allocations.

Ownership of financial responsibility SHALL NOT transfer between Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- reject invalid lifecycle transitions;
- preserve historical financial evidence.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify Outstanding Amount;
- perform Payment Allocation;
- issue Receipts;
- introduce undocumented Aggregate state.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-002 / Payment Aggregate

Future Stories may extend implementation while preserving this specification.

---

# Related Documents

- SoftwareDomainModel.md
- PaymentManagement.md
- BusinessRules.md
- Payment Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Added complete Aggregate contract, approved state, lifecycle, public API, business invariants, ownership boundaries and implementation constraints. Clarified that financial settlement is realised through Payment Allocations rather than owned by the Payment Aggregate. |

---

# Approval

**Status:** Draft