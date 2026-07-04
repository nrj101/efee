# Module Design

```yaml id="jlwm5q"
---
document_id: MOD-001
title: Module Design
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-04

related_documents:
  - AggregateDesign.md
  - SoftwareArchitecture.md
  - ApplicationServices.md
---
```

---

# Purpose

This document defines the logical software modules of the Student Fee Receivables Platform.

Modules partition the codebase into cohesive business capabilities while preserving the architectural boundaries established by the Aggregate Design.

Modules are the primary unit of software organization within the Beta Modular Monolith.

---

# Design Principles

Modules are organized around business capabilities rather than technical layers.

Each module:

* owns one business capability;
* encapsulates its internal implementation;
* exposes well-defined interfaces to collaborating modules; and
* minimizes coupling with other modules.

![Image- Module Dependencies](/architecture/diagrams/D2-ModuleDependencies.png)
---

# Module Catalogue

## Shared

Provides common abstractions reused across the application.

Examples include:

* Value Objects
* Common Exceptions
* Base Domain Types
* Shared Utilities

The Shared module SHALL NOT contain business behaviour.

---

## Student

Owns student lifecycle and identity.

Primary Aggregate:

* Student

Collaborating Modules:

* Academic Year
* Receivables
* Discount

---

## Academic Year

Owns academic session lifecycle.

Primary Aggregate:

* Academic Year

Collaborating Modules:

* Fee Structure
* Receivables
* Receipt

---

## Fee Structure

Owns institutional charging policy.

Primary Aggregate:

* Fee Structure

Collaborating Modules:

* Academic Year
* Discount
* Receivables

---

## Discount

Owns institutional discount policies and grants.

Primary Aggregate:

* Discount Policy

Collaborating Modules:

* Student
* Fee Structure
* Receivables

---

## Receivables

Owns student financial receivables.

Primary Aggregate:

* Fee Obligation

Collaborating Modules:

* Student
* Payment
* Discount

---

## Payment

Owns money received by the institution.

Primary Aggregate:

* Payment

Collaborating Modules:

* Receivables
* Receipt

---

## Receipt

Owns official payment acknowledgement.

Primary Aggregate:

* Receipt

Collaborating Modules:

* Payment
* Academic Year

---

# Module Dependencies

The following dependency rules apply.

| Module        | May Depend On                                           |
| ------------- | ------------------------------------------------------- |
| Student       | Shared                                                  |
| Academic Year | Shared                                                  |
| Fee Structure | Shared, Academic Year                                   |
| Discount      | Shared, Student, Fee Structure                          |
| Receivables   | Shared, Student, Academic Year, Fee Structure, Discount |
| Payment       | Shared, Receivables                                     |
| Receipt       | Shared, Payment, Academic Year                          |

Dependencies SHALL remain acyclic.

---

# Visibility Rules

Modules expose only public business interfaces.

Internal implementation details SHALL remain encapsulated within the owning module.

Cross-module access SHALL occur through Application Services or explicitly exposed interfaces.

---

# Future Evolution

The Modular Monolith establishes clear business boundaries that may later evolve into independently deployable services if justified by business requirements.

Such evolution SHALL preserve the ownership boundaries established by Aggregate Design.
