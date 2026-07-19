# Payment Aggregate Persistence Model

```yaml
---
document_id: TD-PAYMENT-001
title: Payment Aggregate Persistence Model
version: 2.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-17

related_documents:
  - ../../architecture/aggregates/Payment.md
  - ../../technical-specification/aggregates/Payment.md
  - ../../technical-design/persistence/README.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the authoritative persistent representation of the Payment Aggregate.

It refines the approved Aggregate Technical Specification by defining the complete persistent business state required to preserve the business truth owned by the Payment Aggregate while remaining independent of programming language, persistence framework, database technology and infrastructure.

The Payment Aggregate Persistence Model defines:

- persistent business state;
- derived business state;
- transient business state;
- ownership boundaries;
- persistence constraints; and
- traceability to approved engineering specifications.

It specifies **what** business information shall be persisted without prescribing **how** persistence is implemented.

---

# Aggregate

**Payment**

---

# Persistence Responsibilities

The Payment Aggregate Persistence Model preserves the business truth owned by the Payment Aggregate.

It is responsible for persisting:

- Payment identity;
- Amount received;
- Payment Method;
- Payer information;
- Payment reference; and
- Payment lifecycle.

The persisted state represents only the institutional record of the received Payment.

Settlement information is intentionally excluded.

The Payment Aggregate Persistence Model intentionally does **not** persist:

- Payment Allocations;
- Fee Obligation settlement information;
- Receipt information; or
- Outstanding Amounts.

These business truths remain owned by collaborating Aggregates.

---

# Persistent Business State

The Payment Aggregate owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| paymentIdentifier | Payment Identifier | Yes | No | Immutable Payment identifier |
| payerIdentifier | Payer Identifier | Yes | No | Reference to the payer |
| paymentAmount | Monetary Amount | Yes | No | Amount received |
| paymentMethod | Payment Method | Yes | No | Approved method of payment |
| paymentReference | Payment Reference | No | No | External payment reference |
| lifecycleState | Payment Lifecycle | Yes | Yes | Current Payment lifecycle |

No additional Persistent Business State is approved.

---

# Derived Business State

The Payment Aggregate owns no Derived Business State.

All persisted business information represents authoritative business truth owned by the Payment Aggregate.

No additional Derived Business State is approved.

---

# Transient Business State

The Payment Aggregate owns no Transient Business State.

No implementation-specific state forms part of the approved persistent representation.

No additional Transient Business State is approved.

---

# Ownership Boundaries

The Payment Aggregate owns only the Persistent Business State defined by this specification.

The Payment Aggregate SHALL NOT persist business information owned by collaborating Aggregates.

Business information owned by collaborating Aggregates includes:

- Payment Allocations;
- Fee Obligation settlement information;
- Receipt information; and
- Outstanding Amounts.

The Payment Aggregate MAY persist references to collaborating Aggregates where ownership is preserved.

Approved Aggregate references:

| Aggregate | Business Reference |
|-----------|--------------------|
| Payer | Payer Identifier |

References to collaborating Aggregates SHALL preserve ownership without transferring business truth.

---

# Persistence Constraints

Implementation SHALL preserve:

- Payment identity;
- Payment amount integrity;
- Payment Method integrity;
- Payer reference integrity;
- Payment reference integrity;
- Payment lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

Implementation SHALL NOT:

- introduce undocumented Persistent Business State;
- remove approved Persistent Business State;
- rename approved Persistent Business State;
- change approved business types;
- violate approved mutability;
- persist business information owned by collaborating Aggregates; or
- violate Aggregate ownership boundaries.

If implementation requires additional Persistent Business State, implementation SHALL stop and clarification SHALL be requested through the appropriate engineering governance process.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- Payment Identifier remains immutable after creation.
- Payer Identifier remains immutable after creation.
- Monetary Amount accurately represents the received Payment.
- Payment Method remains immutable after creation.
- Payment Reference remains immutable after creation.
- Payment Lifecycle accurately represents the approved lifecycle state.

The persisted representation SHALL preserve only the institutional record of the received Payment.

It SHALL NOT represent:

- Payment Allocation;
- Fee Obligation settlement;
- Receipt generation; or
- Outstanding balances.

Persistent representation SHALL remain consistent with the approved Aggregate Technical Specification.

---

# Traceability

The following Persistent Business State is traceable to the approved Aggregate Technical Specification.

| Persistent Business State | Source |
|---------------------------|--------|
| Payment Identifier | Payment Aggregate Technical Specification |
| Payer Identifier | Payment Aggregate Technical Specification |
| Monetary Amount | Payment Aggregate Technical Specification |
| Payment Method | Payment Aggregate Technical Specification |
| Payment Reference | Payment Aggregate Technical Specification |
| Payment Lifecycle | Payment Aggregate Technical Specification |

All Persistent Business State SHALL remain traceable to approved engineering specifications.

---

# Consistency Requirements

Implementation SHALL preserve:

- Payment identity integrity;
- Payment amount integrity;
- Payment Method integrity;
- Payer reference integrity;
- Payment reference integrity;
- Payment lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

The persistent representation SHALL remain fully consistent with the approved Aggregate Technical Specification throughout the Aggregate lifecycle.

---

# Implementation Constraints

Implementation SHALL:

- preserve Aggregate ownership;
- preserve approved Persistent Business State;
- preserve lifecycle integrity;
- preserve traceability to approved engineering specifications;
- reject modifications that violate approved mutability; and
- remain implementation-neutral.

Implementation SHALL NOT:

- introduce implementation-specific business state;
- persist undocumented business information;
- duplicate business truth owned by collaborating Aggregates;
- modify approved ownership boundaries; or
- introduce implementation behaviour into this persistence model.

Physical persistence technology remains outside the scope of this specification.

---

# Related Documents

- SoftwareDomainModel.md
- SoftwareArchitecture.md
- Payment Aggregate Design
- Payment Aggregate Technical Specification
- Aggregate Persistence Model Standard

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Aligned with Payment ATS v1.1.0. Standardized field names, introduced lifecycleState, clarified ownership boundaries, added Persistent Representation Rules and explicitly excluded Payment Allocation from the Payment Aggregate persistence model. |
| 2.0.0 | 2026-07-17 | Aligned with TD-PERSISTENCE-STD-001 v1.0.0. Adopted the standardized Aggregate Persistence Model structure, introduced Persistent Business State, Derived Business State, Transient Business State, Ownership Boundaries, Consistency Requirements and standardized traceability without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-17