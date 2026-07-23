# Receipt Aggregate Technical Specification

```yaml
---
document_id: ATS-RECEIPT-001
title: Receipt Aggregate Technical Specification
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/ReceiptManagement.md
  - ../../architecture/aggregates/Receipt.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Receipt Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Receipt Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Receipt Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Receipt Aggregate owns the institution's official acknowledgement of an accepted Payment.

It is responsible for:

- preserving Receipt identity;
- maintaining the associated Payment reference;
- preserving the institution-issued Receipt Number;
- preserving acknowledgement information;
- maintaining Correction History; and
- managing the Receipt lifecycle.

The Receipt Aggregate intentionally does **not** own:

- Payment information;
- Payment settlement;
- Student financial responsibility;
- Fee Obligations; or
- Discounts.

The Receipt Aggregate owns acknowledgement only.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Receipt Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| receiptIdentifier | Receipt Identifier | Yes | No | Immutable Receipt identifier |
| paymentIdentifier | Payment Identifier | Yes | No | Accepted Payment being acknowledged |
| receiptNumber | Receipt Number | Yes | No | Institution-issued business receipt number |
| acknowledgementTimestamp | Acknowledgement Timestamp | Yes | No | Official acknowledgement timestamp |
| lifecycleState | Receipt Lifecycle | Yes | Yes | Current Receipt lifecycle |
| correctionHistory | Correction History | Yes | Yes | Historical record of approved Receipt corrections |

No additional owned business state is approved.

---

# Referenced State

The Receipt Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Payment | Acknowledge an accepted Payment |

Referenced business information SHALL remain externally owned.

The Receipt Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Receipt Aggregate does not own any derived business state.

Receipt acknowledgements and correction history are preserved business facts rather than derived information.

No additional derived business state is approved.

---

# Lifecycle

The Receipt Aggregate supports the following lifecycle.

```text
Issued
    │
    ├────────────► Retired
    │
    ▼
Corrected
```

Lifecycle transitions are irreversible.

Historical Receipts remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Receipt Identifier is immutable.
- Payment Identifier is immutable.
- Receipt Number is immutable.
- Every Receipt acknowledges exactly one accepted Payment.
- Acknowledgement Timestamp is immutable.
- Correction History preserves all historical corrections.
- Historical acknowledgement information is never destroyed.
- Only the Receipt Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Receipt Identifier
- Payment Identifier
- Receipt Number
- Acknowledgement Timestamp
- Receipt Lifecycle
- Correction History

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Receipt Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
Receipt(
    receiptIdentifier,
    paymentIdentifier,
    receiptNumber,
    acknowledgementTimestamp
)
```

Creates a valid Receipt.

The constructor SHALL:

- establish a valid Receipt identity;
- associate the acknowledged Payment;
- establish the institution-issued Receipt Number;
- establish the acknowledgement timestamp;
- establish the Issued lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### correct(
    correctionDescription
)

Records an approved Receipt correction.

Preconditions:

- Receipt is Issued or Corrected.
- Correction Description is provided.

Postconditions:

- Correction History is appended.
- Historical acknowledgement information is preserved.
- Lifecycle becomes Corrected.
- Business Invariants remain preserved.

---

### retire()

Transitions the Receipt to the Retired lifecycle state.

Preconditions:

- Receipt is not already Retired.

Postconditions:

- Lifecycle becomes Retired.
- Historical integrity is preserved.
- Business Invariants remain preserved.

---

## Accessors

```text
getReceiptIdentifier()

getPaymentIdentifier()

getReceiptNumber()

getAcknowledgementTimestamp()

getLifecycleState()

getCorrectionHistory()
```

Accessors expose approved Receipt information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Receipt Identifier

Defines the immutable business identity of a Receipt.

Responsibilities:

- uniquely identify a Receipt;
- remain immutable throughout the Receipt lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Receipt.

---

## Receipt Number

Defines the institution-issued business reference for a Receipt.

Responsibilities:

- uniquely identify the official Receipt;
- preserve the institution-issued acknowledgement number.

Business Invariants:

- Receipt Number shall never change.
- Receipt Number shall uniquely identify exactly one Receipt.

---

## Acknowledgement Timestamp

Defines the official time at which a Payment was acknowledged.

Responsibilities:

- preserve the official acknowledgement time;
- provide an auditable acknowledgement record.

Business Invariants:

- Acknowledgement Timestamp shall always exist.
- Acknowledgement Timestamp shall remain immutable.

---

## Correction History

Defines the append-only history of approved Receipt corrections.

Responsibilities:

- preserve approved correction history;
- support historical auditability;
- never destroy historical correction records.

Business Invariants:

- Correction History shall always exist.
- Historical corrections shall never be removed.
- New corrections shall be appended only.

---

## Receipt Lifecycle

Defines the approved lifecycle states of a Receipt.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Retired Receipts are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Receipt Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Receipt | Aggregate Root |
| Receipt Identifier | Owned State |
| Payment Identifier | Owned State |
| Receipt Number | Owned State |
| Acknowledgement Timestamp | Owned State |
| Receipt Lifecycle | Owned State |
| Correction History | Owned State |

The Receipt Aggregate does not persist:

- Payments;
- Students;
- Fee Obligations;
- Payment Allocations;
- Outstanding Amounts; or
- Discounts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Receipt identity integrity;
- Payment acknowledgement integrity;
- acknowledgement information integrity;
- correction history integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

Receipt corrections SHALL preserve complete historical auditability.

---

# Collaboration Contract

The Receipt Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Payment | Acknowledge an accepted Payment |

Collaborations SHALL occur exclusively through approved Aggregate references.

The Receipt Aggregate owns the institution's acknowledgement of an accepted Payment.

The Payment Aggregate owns the institutional record of money received.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve historical acknowledgement information;
- preserve correction history;
- reject invalid lifecycle transitions; and
- preserve all documented Business Invariants.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify Payment information;
- modify Fee Obligations;
- modify Payment Allocations;
- introduce undocumented Aggregate state; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-002 / Story-007

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- ReceiptManagement.md
- Receipt Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Expanded into the standard Aggregate Technical Specification template. Added approved Aggregate state, Public API, Business Invariants, Lifecycle, Collaboration Contract and Implementation Constraints while preserving existing architectural responsibilities. |
| 1.2.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17