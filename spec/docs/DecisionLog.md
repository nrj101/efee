# E-Fee Product & Engineering Specification

## Decision Log

```yaml
---
document_id: DECISION-001
title: Decision Log
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: As Required

related_documents:
  - SPECIFICATION_STANDARDS.md
  - ProjectRoadmap.md
---
```

---

## Purpose

This document records significant product, engineering and specification decisions made during the evolution of E-Fee.

Its purpose is to preserve the reasoning behind important decisions so that future contributors do not repeatedly revisit previously resolved discussions.

This document complements Architecture Decision Records (ADRs) by recording decisions that influence the product, specification and engineering approach before implementation begins.

---

## Scope

This document records decisions related to:

* Product direction
* Engineering process
* Documentation standards
* Repository conventions
* Business modelling
* Domain modelling

Routine editorial changes should not be recorded here.

---

## Decisions

### DL-001 — Business Before Technology

**Status:** Accepted

**Decision**

The product specification shall remain independent of any programming language, framework or database technology.

**Reason**

Business knowledge should outlive implementation technology.

---

### DL-002 — Repository as the Source of Truth

**Status:** Accepted

**Decision**

The Git repository is the permanent memory of the project.

Chat discussions are temporary and become authoritative only after being incorporated into the specification.

**Reason**

Ensures traceability and prevents knowledge loss.

---

### DL-003 — One Document, One Responsibility

**Status:** Accepted

**Decision**

Each specification document owns a single area of knowledge and should avoid duplicating information maintained elsewhere.

**Reason**

Improves maintainability and reduces inconsistencies.

---

### DL-004 — Independent Document Versioning

**Status:** Accepted

**Decision**

Each specification document shall maintain its own Semantic Version.

Product releases do not automatically require version changes to every document.

**Reason**

Allows stable documents to remain unchanged while others evolve.

---

### DL-005 — Repository Structure

**Status:** Accepted

**Decision**

The specification repository shall remain intentionally shallow.

Core documents reside under `docs/`, while ADRs and RFCs are organized into dedicated subdirectories.

**Reason**

Simplifies navigation and supports long-term growth.

---

### DL-006 — Business-Driven Development

**Status:** Accepted

**Decision**

Implementation shall begin only after the corresponding business specification has been approved.

**Reason**

Prevents architecture and code from drifting away from business requirements.

---

### DL-007 — Immutable Financial History

**Status:** Accepted

**Decision**

Financial history shall be preserved.

Corrections should be additive wherever practical rather than overwriting historical information.

**Reason**

Supports auditability, transparency and financial confidence.

---

### DL-008 — Fee Obligations Represent Receivables

**Status:** Accepted

**Decision**

A Fee Obligation represents an account receivable that exists independently of payment.

**Reason**

The obligation is created when the institution expects payment, not when money is received.

---

### DL-009 — Final Settlement Obligation

**Status:** Accepted

**Decision**

Outstanding receivables at Academic Year closure or student exit shall be consolidated into a Final Settlement Obligation instead of carrying forward opening balances.

**Reason**

Provides a complete, auditable summary while supporting students who leave the institution before the next academic year.

---

### DL-010 — AI as an Engineering Assistant

**Status:** Accepted

**Decision**

AI assists with documentation, design, implementation and review.

Business ownership and architectural decisions remain human responsibilities.

**Reason**

Maintains accountability while leveraging AI effectively.

---

## Related Documents

* SPECIFICATION_STANDARDS.md
* ProjectRoadmap.md
* AIConstitution.md

---

## Open Questions

None.

---

## Version History

| Version | Date       | Description              |
| ------- | ---------- | ------------------------ |
| 1.0.0   | 2026-06-29 | Initial approved version |

---

## Approval

**Status:** Approved

**Approved By**

* Product Owner
* CTO

**Approval Date**

2026-06-29
