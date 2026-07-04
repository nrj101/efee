# ADR-001 — Domain Architecture Strategy

```yaml
---
document_id: ADR-001
title: Domain Architecture Strategy
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-04
next_review: Before first implementation sprint

supersedes: None
superseded_by: None

related_documents:
  - SoftwareDomainModel.md
  - BusinessObjectGraph.md
  - BusinessRules.md
  - BusinessWorkflow.md
  - ProjectRoadmap.md
---
```

---

# Status

**Approved**

---

# Context

The business specification (Specification v1.0.0) defines the business domain independently of any software implementation.

The implementation phase requires a consistent architectural strategy that translates the approved business model into software without redefining business concepts or introducing unintended behaviour.

This ADR establishes the architectural principles governing all subsequent software design decisions.

It serves as the architectural foundation for aggregate design, application services, repositories, implementation and future architectural evolution.

---

# Decision

The Student Fee Receivables Platform SHALL adopt the following architectural strategy.

---

## 1. Business Correctness First

Business correctness takes precedence over implementation convenience, optimisation and framework capabilities.

Software exists to preserve the approved business model.

---

## 2. Domain First

The domain model is the centre of the application.

Infrastructure, frameworks, persistence and user interfaces exist to support the domain rather than define it.

---

## 3. Single Ownership of Business Truth

Each business truth SHALL have exactly one owning Software Domain Concept.

Ownership SHALL NOT be shared.

Business processes emerge through collaboration between concepts rather than shared mutable state.

---

## 4. Stable Policies and Operational State SHALL Be Separated

Institution policies evolve independently from operational financial activity.

Whenever appropriate, software SHALL distinguish between:

* Stable business policy
* Operational financial state

Examples include:

Fee Component → Obligation Line

Discount Policy → Discount Grant → Applied Discount

This separation improves maintainability while preserving business correctness.

---

## 5. Financial History Is Append-Only

Historical financial facts SHALL NOT be silently rewritten.

Mistakes SHALL be represented through explicit correction business operations rather than destructive modification.

Examples include:

* Receipt Corrections
* Allocation Corrections

This preserves complete financial auditability.

---

## 6. Lifecycle Determines Allowed Operations

Business operations SHALL be constrained by lifecycle state.

Software SHALL reject operations that violate the lifecycle rules of the owning business concept.

Examples include:

* Closed Academic Years reject new financial activity.
* Settled Fee Obligations reject retrospective policy changes.
* Historical Payments remain immutable after successful receipt.

---

## 7. Derived Business State Is Preferred

Business state SHALL be derived from authoritative business facts wherever practical.

Persisted derived values may be introduced only when justified by measurable operational requirements.

Derived state SHALL never become the primary source of business truth.

---

## 8. Aggregate Consistency

Aggregate boundaries SHALL be determined by business consistency requirements rather than database relationships.

Each Aggregate SHALL protect the business invariants it owns.

---

## 9. Modular Monolith

The Beta implementation SHALL adopt a Modular Monolith architecture.

Modules SHALL communicate through explicit interfaces.

Distributed architecture, microservices and asynchronous messaging are intentionally deferred until justified by demonstrated business requirements.

---

## 10. Framework Independence

Business logic SHALL remain independent of infrastructure frameworks.

Framework technologies are implementation concerns and SHALL NOT influence the business model.

---

## 11. Evolution Through Governance

Business evolution SHALL occur through RFCs.

Architectural evolution SHALL occur through ADRs.

Implementation SHALL faithfully realise approved specifications and architecture without introducing unauthorised changes.

---

# Consequences

The architectural strategy results in the following characteristics:

* Clear ownership of business responsibilities.
* Stable aggregate boundaries.
* Strong financial auditability.
* Predictable architectural evolution.
* Framework-independent business model.
* Simplified future migration towards enterprise SaaS capabilities.
* Reduced AI implementation drift through explicit architectural governance.

---

# Alternatives Considered

## CRUD-Oriented Architecture

Rejected.

Reason:

Business ownership and financial consistency become difficult to preserve.

---

## Microservices

Rejected for Beta.

Reason:

The additional operational complexity provides no measurable business value for a single-school deployment.

The Modular Monolith preserves future migration paths while minimising implementation complexity.

---

## Event Sourcing

Deferred.

Reason:

Append-only financial history can be achieved through explicit correction business operations without introducing event sourcing complexity during the Beta phase.

Future architectural evolution may revisit this decision through a separate ADR.

---

# Future Considerations

This ADR intentionally leaves the following decisions to subsequent architecture documents:

* Aggregate boundaries
* Aggregate Roots
* Domain Events
* Application Services
* Module Dependencies
* Concurrency strategy
* Infrastructure implementation

---

# Related Decisions

Subsequent ADRs SHALL build upon the principles established by this document unless explicitly superseded.

---

# Approval

**Status:** Approved

**Approved By**

* Product Owner
* CTO

**Approval Date**

2026-07-04
