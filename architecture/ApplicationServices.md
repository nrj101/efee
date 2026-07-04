# Application Services

```yaml id="5khqhp"
---
document_id: APP-001
title: Application Services
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-04

related_documents:
  - AggregateDesign.md
  - SoftwareArchitecture.md
  - ../spec/docs/BusinessWorkflow.md
---
```

---

# Purpose

This document defines the application services responsible for coordinating business workflows.

Application Services orchestrate collaboration between Aggregates while preserving Aggregate autonomy.

Business rules remain within the Domain Layer.

---

# Responsibilities

Application Services are responsible for:

* Coordinating Aggregate collaboration.
* Managing transaction boundaries.
* Enforcing workflow sequencing.
* Invoking domain behaviour.
* Coordinating approval workflows.
* Returning application results.

Application Services SHALL NOT contain business rules.

---

## Request Flow

![Image- Request Flow](/architecture/diagrams/D5-RequestFlow.png)

## Approval Flow

![Image- Approval Flow](/architecture/diagrams/D6-ApprovalFlow.png)

# Application Service Catalogue

The following services constitute the Beta MVP application layer.

| Service              | Primary Responsibility           |
| -------------------- | -------------------------------- |
| StudentService       | Student lifecycle management     |
| AcademicYearService  | Academic Year lifecycle          |
| FeeStructureService  | Charging policy management       |
| FeeObligationService | Student receivables              |
| PaymentService       | Payment recording and allocation |
| ReceiptService       | Receipt issuance and correction  |
| DiscountService      | Discount policy and grants       |

---

# Service Interaction Principles

Application Services coordinate business operations but do not own business state.

Each service invokes one or more Aggregate operations while preserving Aggregate boundaries.

Cross-Aggregate workflows SHALL be coordinated by the Application Layer rather than by direct Aggregate interaction.

---

# Service Design Rules

Each Application Service SHALL:

* Represent one business capability.
* Be stateless.
* Own no business data.
* Coordinate Aggregate collaboration.
* Preserve transaction boundaries.
* Return business results.

Business invariants SHALL remain inside Aggregates.

---

# Future Evolution

Future services may be introduced through new business capabilities.

Existing services SHALL evolve without violating Aggregate boundaries or introducing business rules into the Application Layer.
