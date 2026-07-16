# Application Services

```yaml id="5khqhp"
---
document_id: APP-001
title: Application Services
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-16

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

Application Services SHALL also NOT own business state.

They coordinate business workflows by invoking Aggregate operations while preserving Aggregate ownership boundaries.

Application Services SHALL NOT calculate business state, modify another Aggregate's internal state, or bypass Aggregate invariants.

---

## Request Flow

![Image- Request Flow](/architecture/diagrams/D5-RequestFlow.png)

## Approval Flow

![Image- Approval Flow](/architecture/diagrams/D6-ApprovalFlow.png)

# Application Service Catalogue

The following Application Services define the approved Application Layer architecture. Individual services may be implemented incrementally across future Sprints.

| Service | Primary Responsibility |
|----------|------------------------|
| StudentService | Student lifecycle management |
| AcademicYearService | Academic Year lifecycle |
| FeeStructureService | Charging policy management |
| FeeObligationService | Student receivables |
| PaymentService | Payment lifecycle management |
| ReceiptService | Receipt issuance and correction |
| DiscountService | Student discount management |
| ApprovalService | Coordination of approval-governed workflows |
| FinancialCorrectionService | Financial correction workflow coordination |
| ReportingService | Reporting and query orchestration |

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

Future services may be introduced as new business capabilities emerge.

Typical future additions may include:

- NotificationService
- ImportExportService
- ReconciliationService
- DashboardService

New services SHALL coordinate business workflows without introducing business rules or violating Aggregate ownership boundaries.

Additional Application Services may be introduced without modifying Aggregate ownership or business responsibilities.