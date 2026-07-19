# Payment Aggregate Technical Specification

```yaml
---
document_id: ATS-PAYMENT-001
title: Payment Aggregate Technical Specification
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/PaymentManagement.md
  - ../../architecture/aggregates/Payment.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Payment Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Payment Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Payment Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Payment Aggregate owns the institutional record of money received from a payer.

It is responsible for:

- preserving Payment identity;
- preserving the amount received;
- preserving the payment method;
- maintaining payer information;
- preserving external payment references; and
- managing the Payment lifecycle.

The Payment Aggregate intentionally does **not** own:

- Student financial responsibility;
- Payment Allocations;
- Fee Obligation settlement;
- Outstanding Amounts; or
- Receipt acknowledgement.

The Payment Aggregate owns the receipt of money only.

The financial effect of a Payment is realised exclusively through Payment Allocations owned by the Fee Obligation Aggregate.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Payment Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| paymentIdentifier | Payment Identifier | Yes | No | Immutable Payment identifier |
| payerIdentifier | Payer Identifier | Yes | No | Payer providing the payment |
| paymentAmount | Monetary Amount | Yes | No | Amount received |
| paymentMethod | Payment Method | Yes | No | Approved payment method |
| paymentReference | Payment Reference | No | No | External payment reference |
| lifecycleState | Payment Lifecycle | Yes | Yes | Current Payment lifecycle |

No additional owned business state is approved.

---

# Referenced State

The Payment Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Student | Identify the payer where applicable |
| Fee Obligation | Enable payment allocation |
| Receipt | Support receipt generation and acknowledgement |

Referenced business information SHALL remain externally owned.

The Payment Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Payment Aggregate does not own any derived business state.

Financial settlement is intentionally realised through Payment Allocations owned by the Fee Obligation Aggregate.

Outstanding Amounts remain derived and owned by the Fee Obligation Aggregate.

No additional derived business state is approved.

---

# Lifecycle

The Payment Aggregate supports the following lifecycle.

```text
Recorded
    │
    ├────────────► Cancelled
    │
    ▼
Realised
```

Lifecycle transitions are irreversible.

Historical Payments remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Payment Identifier is immutable.
- Payer Identifier is immutable.
- Payment Amount is immutable.
- Payment Method is immutable.
- Payment Amount shall never be negative.
- Only realised Payments may be allocated.
- Payment history shall remain permanently preserved.
- Only the Payment Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Payment Identifier
- Payer Identifier
- Payment Method
- Payment Reference
- Payment Lifecycle

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Payment Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
Payment(
    paymentIdentifier,
    payerIdentifier,
    paymentAmount,
    paymentMethod,
    paymentReference
)
```

Creates a valid Payment.

The constructor SHALL:

- establish a valid Payment identity;
- associate the payer;
- preserve the received amount;
- preserve the payment method;
- preserve the payment reference where provided;
- establish the Recorded lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### realise()

Marks the Payment as successfully realised.

Preconditions:

- Payment is currently Recorded.

Postconditions:

- Lifecycle becomes Realised.
- Payment becomes eligible for allocation.
- Business Invariants remain preserved.

---

### cancel()

Transitions the Payment to the Cancelled lifecycle state.

Preconditions:

- Payment is currently Recorded.
- Cancellation is permitted by business policy.

Postconditions:

- Lifecycle becomes Cancelled.
- Historical payment information is preserved.
- Business Invariants remain preserved.

---

## Accessors

```text
getPaymentIdentifier()

getPayerIdentifier()

getPaymentAmount()

getPaymentMethod()

getPaymentReference()

getLifecycleState()
```

Accessors expose approved Payment information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Payment Identifier

Defines the immutable business identity of a Payment.

Responsibilities:

- uniquely identify a Payment;
- remain immutable throughout the Payment lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Payment.

---

## Payer Identifier

Defines the business identity of the payer responsible for a Payment.

Responsibilities:

- identify the source of the Payment;
- remain associated with exactly one Payment.

Business Invariants:

- Payer Identifier shall never change.
- Every Payment references exactly one Payer Identifier.

---

## Payment Method

Defines the approved method by which money was received.

Responsibilities:

- identify the method of payment;
- preserve the payment channel used to receive funds.

Business Invariants:

- Payment Method shall always exist.
- Payment Method shall remain immutable.

---

## Payment Reference

Defines an external reference associated with a Payment where applicable.

Responsibilities:

- preserve the external payment reference;
- support reconciliation with external financial systems.

Business Invariants:

- Payment Reference may be absent.
- Where present, Payment Reference shall remain immutable.

---

## Payment Lifecycle

Defines the approved lifecycle states of a Payment.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Cancelled and Realised Payments are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Payment Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Payment | Aggregate Root |
| Payment Identifier | Owned State |
| Payer Identifier | Owned State |
| Payment Amount | Owned State |
| Payment Method | Owned State |
| Payment Reference | Owned State |
| Payment Lifecycle | Owned State |

The Payment Aggregate does not persist:

- Students;
- Fee Obligations;
- Payment Allocations;
- Outstanding Amounts;
- Receipts; or
- Discounts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Payment identity integrity;
- payer information integrity;
- payment amount integrity;
- financial evidence integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

Settlement information SHALL remain externally reproducible through Payment Allocations.

---

# Collaboration Contract

The Payment Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Student | Identify the payer where applicable |
| Fee Obligation | Enable payment allocation and financial settlement |
| Receipt | Provide payment information for receipt generation |

Collaborations SHALL occur exclusively through approved Aggregate references.

The Payment Aggregate owns only the institutional record of money received.

The Fee Obligation Aggregate determines and records the financial effect of a Payment through Payment Allocations.

The Receipt Aggregate acknowledges receipt of the Payment.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve historical financial evidence;
- reject invalid lifecycle transitions; and
- preserve all documented Business Invariants.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify Outstanding Amounts;
- perform Payment Allocations;
- issue Receipts;
- introduce undocumented Aggregate state; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-002 / Story-006

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- PaymentManagement.md
- Payment Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Added complete Aggregate contract, approved state, lifecycle, public API, business invariants, ownership boundaries and implementation constraints. Clarified that financial settlement is realised through Payment Allocations rather than owned by the Payment Aggregate. |
| 1.2.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17
```