# RFC-001 — Financial Truth Model

```yaml
---
document_id: RFC-001
title: Financial Truth Model
version: 1.0.0
status: Accepted

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-14
last_updated: 2026-07-14

supersedes: None

related_documents:
  - ../BusinessRules.md
  - ../SoftwareDomainModel.md
  - ../../../architecture/AggregateDesign.md
  - ../../../technical-specification/aggregates/FeeObligation.md
  - ../../../technical-design/persistence/FeeObligation.md
---
```

---

# Purpose

This RFC resolves inconsistencies identified during Sprint-001 implementation regarding ownership and representation of a Student's financial position.

The objective is to establish a single, authoritative financial model that preserves correctness, auditability, reconciliation and implementation simplicity while remaining suitable for the MVP.

---

# Problem Statement

The current specification contains an inconsistency regarding **Outstanding Amount**.

Business Rules and the Software Domain Model describe Outstanding Amount as the financial position resulting from:

- Fee Obligations;
- Discounts;
- Payments;
- Financial Corrections.

However, the Fee Obligation Aggregate Technical Specification and Persistence Model currently define `outstandingAmount` as an independently mutable Aggregate field without identifying the underlying financial facts from which it is obtained.

This creates ambiguity regarding:

- the authoritative financial truth;
- reconciliation;
- auditability;
- correction handling;
- future reporting.

The design must explicitly define the relationship between financial events and the persisted Outstanding Amount.

---

# Current Design

Current Business Rules imply:

```
Outstanding Amount

=

Obligation Lines

− Discounts

− Payments

± Corrections
```

Current ATS and Persistence Model expose:

```
Outstanding Amount

↓

Mutable Aggregate State
```

These descriptions do not clearly define:

- whether Outstanding Amount is authoritative;
- whether it is calculated;
- whether it can be reconstructed;
- whether historical financial facts remain authoritative.

---

# Design Goals

The approved model shall:

- preserve financial correctness;
- support audit and reconciliation;
- support financial corrections;
- support future reporting;
- remain simple enough for MVP implementation;
- avoid unnecessary architectural complexity.

---

# Alternatives Considered

## Option A — Fully Derived

Outstanding Amount is never stored.

Every query recalculates the financial position from all underlying financial facts.

### Advantages

- No synchronization required.
- Always mathematically correct.

### Disadvantages

- Poor read performance.
- Expensive reporting.
- Large historical traversal.
- Increased implementation complexity.

Rejected.

---

## Option B — Independently Mutable

Outstanding Amount is treated as ordinary mutable Aggregate state.

Business operations directly modify Outstanding Amount.

### Advantages

- Very simple implementation.

### Disadvantages

- Financial position may diverge from historical transactions.
- Difficult reconciliation.
- Audit cannot independently reproduce balances.
- Higher corruption risk.

Rejected.

---

## Option C — Derived and Persisted

Outstanding Amount is calculated whenever financial facts change.

The calculated result is then persisted as the Aggregate's current financial position.

The persisted value may always be reconstructed from the underlying financial facts.

Accepted.

---

# Decision

The project SHALL adopt **Derived and Persisted Financial Position**.

Outstanding Amount SHALL represent the current financial position of the Fee Obligation.

Outstanding Amount SHALL NOT be treated as an independent business fact.

Instead, it SHALL be derived from the financial facts owned by the Fee Obligation Aggregate and persisted after each successful business operation.

The persisted value exists for efficient querying and reporting but remains rebuildable from authoritative financial facts.

---

# Authoritative Financial Facts

The financial position is derived from:

- Obligation Lines;
- Applied Discounts;
- Payment Allocations;
- Financial Corrections.

These represent the authoritative financial facts owned by the Aggregate.

Outstanding Amount represents the current financial position resulting from those facts.

---

# Aggregate Responsibilities

The Fee Obligation Aggregate SHALL:

- preserve all authoritative financial facts;
- calculate Outstanding Amount whenever financial facts change;
- persist the calculated Outstanding Amount before completing the transaction;
- ensure Outstanding Amount never becomes negative.

The Aggregate SHALL NOT allow Outstanding Amount to be modified independently of the underlying financial facts.

---

# Audit Implications

Audit SHALL rely upon the authoritative financial facts.

Outstanding Amount is considered a derived financial position.

Historical financial facts remain permanently preserved.

Financial corrections SHALL create additional financial facts rather than rewriting history.

---

# Consequences

The following documents require updates.

| Document | Required Change |
|-----------|-----------------|
| Business Rules | Clarify Outstanding Amount definition |
| Software Domain Model | Identify financial facts explicitly |
| Aggregate Design | Clarify Aggregate ownership of financial position |
| Fee Obligation ATS | Define Outstanding Amount as derived and persisted |
| Fee Obligation Persistence | Clarify persisted financial position |
| Payment ATS | Reference Payment Allocation as financial fact |
| Discount ATS | Reference Applied Discount as financial fact |
| Reporting workflows | Use persisted Outstanding Amount for read models |

---

# Migration Impact

No Sprint-001 implementation requires modification.

This RFC changes the specification baseline for future implementation.

Sprint-002 and later Stories SHALL follow this model.

---

# Backward Compatibility

This RFC introduces no breaking behavioural changes.

It clarifies the architectural interpretation of existing specifications.

---

# Status

**Accepted**

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-14 | Initial proposal. |