# E-Fee Product & Engineering Specification

# RFC-004 — Audit, Correction and Approval Model

```yaml
---
document_id: RFC-004
title: Audit, Correction and Approval Model
version: 1.0.0
status: Accepted

owner: Product Owner
reviewer: CTO

created: 2026-07-14
last_updated: 2026-07-14

related_documents:
  - ../BusinessRules.md
  - ../SoftwareDomainModel.md
  - ../../../architecture/CrossCuttingConcerns.md
  - ../../../architecture/ApplicationServices.md
  - ../../../architecture/ArchitecturePatterns.md
---
```

---

# Purpose

This RFC establishes the canonical architectural model for approvals, financial corrections and auditability throughout the E-Fee platform.

It resolves inconsistencies identified during the v1.0.0 design review by defining a single cross-cutting model that applies consistently across all financial business operations.

This RFC introduces no new business capability.

It standardizes how approved business operations are recorded, corrected and audited.

---

# Background

The approved Business Rules require:

- approval of selected financial activities;
- preservation of financial history;
- additive corrections;
- complete auditability.

Although these requirements existed, no architectural model defined:

- where approvals belong;
- how corrections are represented;
- what information must be preserved;
- how audit history is maintained.

As a result, multiple implementation interpretations were possible.

---

# Decision

The platform SHALL adopt an append-only financial history model.

Financial business facts SHALL never be silently modified.

Business corrections SHALL introduce new approved facts while preserving the original historical record.

Approval SHALL authorize business operations but SHALL NOT own business truth.

---

# Architectural Principles

The following principles apply throughout the platform.

## Financial History is Immutable

Historical financial information SHALL remain permanently preserved.

Existing financial facts SHALL NOT be rewritten or deleted.

---

## Corrections are Additive

Corrections SHALL create new business facts.

They SHALL reference the original business activity where applicable.

Historical records remain permanently visible.

---

## Approval Precedes Business Change

Business operations requiring institutional authorization SHALL receive approval before modifying business state.

Approval authorizes the change.

Approval does not become the owner of business truth.

---

## Complete Auditability

Every significant financial activity SHALL remain traceable.

The platform SHALL preserve sufficient information to reconstruct the complete financial history.

---

# Audit Information

Where applicable, financial activities SHALL preserve:

- Business Object
- Business Operation
- Actor
- Timestamp
- Business Reason
- Approval Reference (if applicable)
- Original Business Fact (for corrections)
- Corrective Business Fact (for corrections)

---

# Applicable Business Operations

This model applies to operations including:

- Discount Grant
- Payment Correction
- Receipt Correction
- Fee Obligation Correction
- Financial Adjustments
- Academic Year Closure (where approvals are required)

Future business operations may adopt this model without architectural redesign.

---

# Correction Model

Corrections SHALL follow the following pattern.

```text
Original Business Fact
            │
            ▼
Correction Request
            │
            ▼
Approval
            │
            ▼
Corrective Business Fact
```

The original business fact remains permanently preserved.

---

# Approval Model

Approval is a business process.

Approval SHALL record:

- Approver
- Approval Timestamp
- Business Reason
- Comments (optional)
- Approved Business Activity

Approval SHALL NOT duplicate business information already owned by another Aggregate.

---

# Ownership

Approval information SHALL remain separate from business ownership.

Examples:

| Business Truth | Owner |
|---------------|-------|
| Student | Student Aggregate |
| Fee Obligation | Fee Obligation Aggregate |
| Payment | Payment Aggregate |
| Receipt | Receipt Aggregate |
| Discount Grant | Discount Aggregate |
| Approval | Approval Process |
| Correction | Owning Aggregate |

Ownership SHALL NOT transfer through approval.

---

# Consequences

The adopted model provides:

- complete auditability;
- reproducible financial history;
- additive corrections;
- simplified reporting;
- consistent approval workflows;
- clear separation between authorization and business ownership.

---

# Impacted Documents

This RFC affects:

- Business Rules
- Software Domain Model
- Cross Cutting Concerns
- Architecture Patterns
- Application Services
- Financial Corrections Workflow
- Discount Workflow
- Receipt Workflow
- Payment Workflow
- Aggregate Technical Specifications
- Persistence Models

Future implementation SHALL follow this model.

---

# Alternatives Considered

## In-place modification of financial records

Rejected.

Historical financial information would be lost and auditability could not be guaranteed.

---

## Approval embedded within every Aggregate

Rejected.

Approval is a cross-cutting business process rather than business truth owned by individual Aggregates.

Embedding approval logic inside every Aggregate would duplicate responsibilities and increase coupling.

---

# Status

**Accepted**

This RFC forms part of Specification v1.1.0.