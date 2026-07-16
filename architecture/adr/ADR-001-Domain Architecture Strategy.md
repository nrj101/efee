# ADR-001 — Domain Architecture Strategy

```yaml
---
document_id: ADR-001
title: Domain Architecture Strategy
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-14
next_review: Before Architecture v2.0.0

supersedes: None
superseded_by: None

related_documents:
  - ../SoftwareArchitecture.md
  - ../AggregateDesign.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessObjectGraph.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/BusinessWorkflow.md
  - ../../spec/docs/ProjectRoadmap.md
---
```

---

# Status

**Approved**

Validated through Specification v1.1.0 and the successful completion of Sprint-001.

---

# Context

The approved Product Specification defines the business domain independently of software implementation.

The Software Architecture must faithfully realize that business model without redefining business concepts or introducing unintended behaviour.

This ADR establishes the architectural strategy governing every subsequent software design decision.

It provides the foundation for:

- Aggregate Design
- Module Design
- Application Services
- Technical Specifications
- Persistence Models
- Future architectural evolution

All subsequent architecture documents inherit the principles defined by this ADR.

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

Infrastructure, frameworks, persistence and user interfaces exist solely to support the domain rather than define it.

---

## 3. Single Ownership of Business Truth

Every business truth SHALL have exactly one owner.

Ownership SHALL NOT be shared.

Business behaviour emerges through collaboration between Aggregates rather than shared mutable state.

---

## 4. Stable Policies and Operational State SHALL Be Separated

Institutional policy evolves independently from operational financial activity.

Whenever appropriate, software SHALL distinguish between:

- Stable business policy
- Operational financial state

Examples include:

- Fee Component → Obligation Line
- Discount → Applied Discount

This separation improves maintainability while preserving business correctness.

---

## 5. Financial History Is Append-Only

Historical financial facts SHALL NOT be silently rewritten.

Mistakes SHALL be represented through explicit correction business operations rather than destructive modification.

Examples include:

- Receipt Corrections
- Financial Corrections

This preserves complete financial auditability.

---

## 6. Lifecycle Determines Allowed Operations

Business operations SHALL be constrained by lifecycle state.

Software SHALL reject operations that violate the lifecycle rules of the owning business concept.

Examples include:

- Closed Academic Years reject new financial activity.
- Closed Fee Obligations reject further modification.
- Realised Payments remain immutable.
- Historical Receipts remain traceable.

---

## 7. Business Events Produce Business State

Business Events represent immutable facts.

Business State is derived from those facts.

Persisted derived values may exist for operational efficiency provided they remain reproducible from authoritative business history.

Derived state SHALL never become the primary source of business truth.

---

## 8. Aggregate Consistency

Aggregate boundaries SHALL be determined by business consistency requirements rather than database relationships.

Each Aggregate SHALL protect the business invariants it owns.

---

## 9. Modular Monolith

The MVP SHALL adopt a Modular Monolith architecture.

Modules SHALL communicate through explicit business interfaces coordinated by Application Services.

Distributed architecture, asynchronous messaging and independently deployable services are intentionally deferred until justified by demonstrated business requirements.

---

## 10. Framework Independence

Business logic SHALL remain independent of infrastructure frameworks.

Framework technologies are implementation concerns and SHALL NOT influence the business model.

---

## 11. Evolution Through Governance

Business evolution SHALL begin through approved RFCs.

Architectural evolution SHALL occur through approved ADRs.

Implementation SHALL faithfully realize the approved Product Specification and Software Architecture.

Implementation SHALL NOT redefine approved business or architectural decisions.

---

# Consequences

The architectural strategy produces:

- Clear ownership of business responsibilities.
- Stable Aggregate boundaries.
- Strong financial auditability.
- Predictable architectural evolution.
- Framework-independent business logic.
- Simplified future migration toward enterprise SaaS capabilities.
- Reduced AI implementation drift through explicit engineering governance.

The successful completion of Sprint-001 validated these principles through real implementation.

---

# Alternatives Considered

## CRUD-Oriented Architecture

**Rejected**

Reason:

Business ownership and financial consistency become difficult to preserve.

---

## Microservices

**Rejected for MVP**

Reason:

The additional operational complexity provides no measurable business value for the initial deployment.

The Modular Monolith preserves future migration paths while minimizing implementation complexity.

---

## Event Sourcing

**Deferred**

Reason:

Append-only financial history can be achieved through explicit correction business operations without introducing the complexity of Event Sourcing during the MVP.

Future architectural evolution may revisit this decision through a dedicated ADR.

---

# Future Considerations

Future ADRs may define:

- Aggregate evolution
- Domain Events
- Integration architecture
- Reporting architecture
- Concurrency strategy
- Infrastructure architecture
- Deployment architecture

while preserving the principles established by this ADR.

---

# Related Decisions

Subsequent ADRs SHALL build upon the principles established by this document unless explicitly superseded.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-04 | Initial architectural strategy. |
| 1.1.0 | 2026-07-14 | Validated following Specification v1.1.0 reconciliation and Sprint-001. Added Business Events produce Business State principle, strengthened governance model, aligned terminology with the finalized Aggregate Design and Software Architecture, and recorded implementation validation of the architectural strategy. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14