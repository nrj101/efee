# Supporting Type Technical Specification

```yaml
---
document_id: TECH-SUPPORT-001
title: Supporting Type Technical Specification
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-17
last_updated: 2026-07-17
---
```

---

# Purpose

This document defines the approved public contracts for Supporting Types used by Aggregate Technical Specifications.

Supporting Types encapsulate reusable business behaviour that is owned by an Aggregate but does not justify becoming an Aggregate or a standalone domain object.

This specification defines:

- responsibilities;
- owned state;
- public operations;
- invariants; and
- ownership constraints.

Supporting Types SHALL NOT own independent business identity.

Supporting Types SHALL exist only as part of their owning Aggregate.

---

# Supporting Types

---

## CorrectionHistory

### Purpose

Preserves the complete historical record of approved Receipt corrections.

### Owner

Receipt Aggregate

### Responsibilities

- preserve every approved correction;
- preserve historical ordering;
- prohibit removal of historical corrections.

### Owned State

| State | Type | Mutable |
|---------|------|----------|
| corrections | Collection of Correction Entries | Yes |

### Public Operations

| Operation | Purpose |
|------------|---------|
| addCorrection(description) | Records a new approved correction |
| getCorrections() | Returns historical corrections |

### Invariants

- Corrections are append-only.
- Historical corrections shall never be removed.
- Ordering shall be preserved.

---

## ObligationLine

### Purpose

Represents a single financial obligation owned by a Fee Obligation.

### Owner

Fee Obligation Aggregate

### Responsibilities

- preserve fee component reference;
- preserve obligation amount.

### Owned State

| State | Type | Mutable |
|---------|------|----------|
| obligationLineIdentifier | Obligation Line Identifier | No |
| feeComponentIdentifier | Fee Component Identifier | No |
| obligationAmount | Monetary Amount | Yes |

### Public Operations

No public behaviour beyond construction and approved accessors.

### Invariants

- Identifier is immutable.
- Fee Component reference is immutable.
- Obligation Amount shall never be negative.

---

## AppliedDiscount

### Purpose

Represents an approved Discount applied to a Fee Obligation.

### Owner

Fee Obligation Aggregate

### Responsibilities

- preserve applied Discount reference;
- preserve applied financial value.

### Owned State

| State | Type | Mutable |
|---------|------|----------|
| discountIdentifier | Discount Identifier | No |
| discountAmount | Monetary Amount | Yes |

### Public Operations

No public behaviour beyond construction and approved accessors.

### Invariants

- Discount Identifier is immutable.
- Discount Amount shall never be negative.

---

## PaymentAllocation

### Purpose

Represents the allocation of a Payment to a Fee Obligation.

### Owner

Fee Obligation Aggregate

### Responsibilities

- preserve Payment reference;
- preserve allocated amount.

### Owned State

| State | Type | Mutable |
|---------|------|----------|
| paymentIdentifier | Payment Identifier | No |
| allocatedAmount | Monetary Amount | Yes |

### Public Operations

No public behaviour beyond construction and approved accessors.

### Invariants

- Payment Identifier is immutable.
- Allocated Amount shall never be negative.

---

# Traceability

All Supporting Types SHALL remain traceable to their owning Aggregate Technical Specification.

---

# Related Documents

- TECH-STD-001
- Aggregate Technical Specifications

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-17 | Initial Supporting Type Technical Specification. |

---

# Approval

**Status:** Draft