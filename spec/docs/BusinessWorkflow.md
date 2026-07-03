# E-Fee Product & Engineering Specification

# Business Workflow

```yaml
---
document_id: WORKFLOW-001
title: Business Workflow
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - UserPersonas.md
  - DomainGlossary.md
  - BusinessRules.md
  - BusinessObjectGraph.md
---
```

---

# Purpose

This document describes the business operations through which educational institutions manage student fee receivables using E-Fee.

It focuses on **what the institution does**, **who performs each operation**, and **the business outcome produced**. It intentionally avoids software implementation details and technical design decisions.

The purpose of this document is to establish a shared understanding of the institution's operational processes before defining software concepts or implementation architecture.

---

# Scope

This document describes the complete operational lifecycle of student fee receivables, beginning with Academic Year preparation and ending with Academic Year closure.

It defines:

* Major business operations.
* Operational participants.
* Operational outcomes.
* Relationships between business operations.

It intentionally does **not** define:

* Detailed business rules.
* Business object structure.
* Software implementation.
* User interface behaviour.

Business constraints are defined in **BusinessRules.md**.

Business concepts are defined in **DomainGlossary.md**.

---

# Workflow Overview

Educational institutions manage student fee receivables through a sequence of business operations.

Each operation produces one or more Business Events that collectively establish the complete financial history of an Academic Year.

```text
Academic Year Preparation
        │
        ▼
Student Admission
        │
        ▼
Receive Payment
        │
        ▼
Allocate Payment
        │
        ▼
Issue Receipt
        │
        ▼
Grant Discount
        │
        ▼
Financial Correction
        │
        ▼
Reporting
        │
        ▼
Student Exit
        │
        ▼
Academic Year Closure
```

The following sections describe each business operation in detail.

---

# Business Operation 1 — Academic Year Preparation

## Purpose

Prepare the institution for a new Academic Year before admitting students and collecting fees.

---

## Participants

* Accountant
* Principal
* School Manager

---

## Trigger

The institution begins preparation for a new Academic Year.

---

## Workflow

The institution performs the following activities:

1. Create the Academic Year.
2. Define or review Fee Structures.
3. Define the Fee Components applicable to those Fee Structures.
4. Configure institution-wide charging policies.
5. Prepare for Student admissions.

At this stage:

* No Students have been admitted.
* No Fee Obligations exist.
* No Payments have been received.

---

## Outcome

The institution is prepared to admit Students into the new Academic Year.

The charging policy for the Academic Year has been established.

---

## Related Business Rules

* BR-001
* BR-002
* BR-006
* BR-007

---

# Business Operation 2 — Student Admission

## Purpose

Admit a Student into an Academic Year and establish the Student's financial responsibility.

---

## Participants

* Accountant / Receptionist

---

## Trigger

A Student is admitted to the institution for an Academic Year.

---

## Preconditions

* The Academic Year exists.
* An applicable Fee Structure has been defined.

---

## Workflow

The institution:

1. Registers the Student (if necessary).
2. Associates the Student with the Academic Year.
3. Determines the applicable Fee Structure.
4. Applies any known Student-specific Discounts.
5. Creates the Student's Fee Obligation.

The Fee Obligation establishes the Student's financial responsibility for the Academic Year.

Admission determines **what the Student owes**.

It does **not** imply that any payment has been received.

---

## Outcome

The Student is enrolled for the Academic Year.

The institution has established the Student's Fee Obligation and can determine the Student's outstanding financial responsibility.

---

## Related Business Rules

* BR-004
* BR-005
* BR-006
* BR-007
* BR-008
* BR-009
* BR-010
* BR-022
* BR-023

---

# Business Operation 3 — Receive Payment

## Purpose

Accept a payment from a payer towards one or more outstanding Fee Obligations.

---

## Participants

* Parent or Payer
* Accountant / Receptionist

---

## Trigger

A payer presents a payment to the institution.

---

## Preconditions

* One or more outstanding Fee Obligations exist.

---

## Workflow

The institution accepts payment using one of its supported payment methods, such as:

* Cash
* UPI
* Cheque
* Credit or Debit Card
* Other institution-approved methods

The Accountant records:

* Payment amount.
* Payment method.
* Transaction reference (where applicable).
* Supporting comments (where appropriate).

Depending on the payment method, the institution may receive the funds immediately or at a later time.

Only funds successfully received by the institution may be applied towards outstanding Fee Obligations.

---

## Outcome

The institution has accepted a Payment.

The Payment is available to settle outstanding Fee Obligations once the institution has successfully received the corresponding funds.

---

## Related Business Rules

* BR-013
* BR-014
* BR-015

---

# Business Operation 4 — Allocate Payment

## Purpose

Determine how a received Payment settles one or more outstanding Fee Obligations.

---

## Participants

* Accountant / Receptionist
* Parent or Payer (optional)

---

## Trigger

The institution has successfully received a Payment.

---

## Preconditions

* The Payment has been successfully received by the institution.
* One or more outstanding Fee Obligations exist.

---

## Workflow

The institution determines how the Payment should be applied.

Allocation may follow:

* The payer's requested settlement priority, or
* The institution's default settlement policy.

A single Payment may settle:

* One Fee Obligation.
* Multiple Fee Obligations.
* Multiple Fee Components within those obligations.
* Multiple Students, where institutional policy permits (for example, siblings).

Every allocation contributes towards reducing the outstanding financial responsibility represented by the corresponding Fee Obligation.

The institution should always be able to explain exactly which Fee Obligations were settled by a particular Payment.

---

## Outcome

Outstanding Fee Obligations have been partially or fully settled.

The relationship between the Payment and the settled Fee Obligations has been permanently recorded.

---

## Related Business Rules

* BR-016
* BR-017
* BR-018

---

# Business Operation 5 — Issue Receipt

## Purpose

Provide the payer with official acknowledgement that the institution has accepted the Payment.

---

## Participants

* Accountant / Receptionist

---

## Trigger

A Payment has been accepted by the institution.

---

## Preconditions

* A Payment has been successfully received.

---

## Workflow

The institution issues a Receipt according to its established operational practice.

For the MVP, this continues to be the institution's existing handwritten receipt process.

The corresponding Receipt reference is recorded within E-Fee to maintain traceability between:

* The Receipt.
* The Payment.
* The Fee Obligations settled by that Payment.

If an error is later discovered, the institution follows the Financial Correction process rather than replacing historical information.

---

## Outcome

The payer receives official acknowledgement of the Payment.

The institution preserves an auditable relationship between the Receipt, the Payment and the settled Fee Obligations.

---

## Related Business Rules

* BR-019
* BR-020
* BR-021

---

# Business Operation 6 — Grant Discount

## Purpose

Reduce a Student's financial responsibility through an approved concession while preserving complete financial history.

---

## Participants

* Accountant / Receptionist
* Principal or School Manager (Approving Authority)

---

## Trigger

The institution decides to grant a financial concession to an eligible Student.

---

## Preconditions

* The Student has an applicable Fee Obligation.
* Appropriate approval has been obtained according to institutional policy.

---

## Workflow

The institution:

1. Determines the Discount to be granted.
2. Records the reason for the Discount.
3. Records the approving authority.
4. Records any supporting comments or documentation.
5. Applies the Discount to the Student's outstanding financial responsibility.

The original Fee Obligation remains historically visible.

The Discount records how and why the Student's financial responsibility was reduced.

---

## Outcome

The Student receives an approved financial concession.

The institution preserves a complete and explainable financial history.

---

## Related Business Rules

* BR-022
* BR-023
* BR-027
* BR-028

---

# Business Operation 7 — Financial Correction

## Purpose

Correct previously recorded financial information while preserving complete auditability.

---

## Participants

* Accountant / Receptionist
* Principal or School Manager (Approving Authority)

---

## Trigger

An error or omission is discovered in previously recorded financial information.

---

## Preconditions

* The affected financial information already exists.
* Appropriate approval has been obtained where required.

---

## Workflow

Rather than replacing historical information, the institution records a Correction that explains:

* What was incorrect.
* Why the Correction is required.
* Who requested the Correction.
* Who approved the Correction.
* When the Correction was performed.

The Correction preserves the original business history while establishing the corrected financial position.

Historical financial records remain explainable throughout the lifecycle of the Student's Fee Obligation.

---

## Outcome

The institution has corrected its financial records without losing historical information.

Both the original activity and the Correction remain permanently auditable.

---

## Related Business Rules

* BR-024
* BR-025
* BR-026
* BR-027
* BR-028
* BR-031
* BR-032

---

# Business Operation 8 — Reporting

## Purpose

Provide accurate and explainable information about the institution's current financial position.

---

## Participants

* Accountant / Receptionist
* Principal
* School Manager

---

## Trigger

The institution requires financial information for operational or management purposes.

---

## Workflow

Throughout the Academic Year, the institution reviews the current state of its student fee receivables.

Typical reporting activities include:

* Reviewing outstanding Fee Obligations.
* Reviewing a Student's financial history.
* Monitoring daily collections.
* Identifying fee defaulters.
* Reviewing Discounts granted.
* Monitoring pending approvals.
* Reviewing financial Corrections.

Reports always represent the current Business State while remaining explainable through the underlying Business Events.

---

## Outcome

The institution gains a reliable and explainable understanding of its financial position.

---

## Related Business Rules

* BR-029
* BR-030
* BR-031
* BR-032
* BR-033
* BR-034
* BR-035
* BR-036

---

# Business Operation 9 — Student Exit

## Purpose

Conclude a Student's active participation in the institution while preserving complete financial history.

---

## Participants

* Accountant / Receptionist

---

## Trigger

A Student leaves the institution before or after completing an Academic Year.

---

## Workflow

The institution:

1. Marks the Student as inactive.
2. Preserves all historical financial information.
3. Prevents the Student from participating in future operational activities unless explicitly reactivated.

Student Exit does not remove:

* Fee Obligations.
* Payments.
* Receipts.
* Discounts.
* Corrections.
* Audit History.

Historical financial information remains permanently available.

---

## Outcome

The Student is no longer operationally active.

Historical financial information remains complete and fully auditable.

---

## Related Business Rules

* BR-004
* BR-005

---

# Business Operation 10 — Academic Year Closure

## Purpose

Conclude operational activities for an Academic Year while preserving the institution's financial position.

---

## Participants

* Accountant
* Principal
* School Manager

---

## Trigger

The Academic Year reaches its operational conclusion.

---

## Preconditions

The institution has completed normal fee collection activities for the Academic Year.

---

## Workflow

The institution:

1. Reviews outstanding Fee Obligations.
2. Identifies any remaining unsettled financial responsibilities.
3. Consolidates remaining receivables into a Final Settlement Obligation for each Student.
4. Closes the Academic Year.

Once closed:

* Normal operational activities cease.
* Historical financial information remains available.
* The Academic Year becomes read-only.

---

## Outcome

The Academic Year is formally concluded.

The institution preserves a complete, auditable summary of every Student's financial position for that Academic Year.

---

## Related Business Rules

* BR-001
* BR-002
* BR-003

---

# Workflow Principles

Every business operation described in this document should preserve the following principles:

* Financial history is preserved.
* Business Events remain traceable.
* Every financial decision is explainable.
* Financial Corrections remain transparent.
* Business reporting remains reliable.
* Historical information is never silently removed.
* Financial integrity takes precedence over operational convenience.

---

# Key Decisions

* Business operations are documented before software behaviour.
* Business workflows remain independent of implementation technology.
* Historical financial information is preserved throughout the Student lifecycle.
* Payments and Receipts remain traceable throughout their lifecycle.
* Corrections preserve history rather than replacing it.
* Closed Academic Years become immutable.
* Every business operation contributes to an explainable financial history.

---

# Related Documents

* UserPersonas.md
* DomainGlossary.md
* BusinessRules.md
* BusinessObjectGraph.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                    |
| ------- | ---------- | ---------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                       |
| 1.1.0   | 2026-07-03 | Reorganized around business operations and aligned with the completed Gate 2 conceptual model. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
