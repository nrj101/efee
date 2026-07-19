# Implementation Guide

```yaml
---
document_id: IMP-008
story: Story-008
title: Record Payment Application Service
version: 2.0.0
status: Approved

owner: Product Owner

last_updated: 2026-07-18
---
```

---

# Purpose

This document provides implementation guidance specific to Story-008.

It supplements the Story by describing the approved coordination strategy for implementing the Record Payment Application Service.

This document does not redefine business behaviour, Aggregate responsibilities or architectural policy.

The Engineering Constitution and Application Service Developer Prompt remain authoritative.

---

# Business Objective

Implement the approved Record Payment Application Service.

The service coordinates the approved payment recording workflow by invoking the Payment Aggregate through its approved public contract.

The Application Service is responsible for workflow coordination only.

Business behaviour remains implemented by the Payment Aggregate.

---

# Scope

The implementation SHALL:

- implement the approved Story;
- coordinate the approved payment recording workflow;
- invoke only approved Aggregate public contracts;
- generate the requested implementation artifacts;
- generate automated tests.

The implementation SHALL NOT:

- redesign the workflow;
- introduce new business rules;
- invent Aggregate operations;
- duplicate Aggregate behaviour;
- modify unrelated implementation.

---

# Participating Aggregates

This Story coordinates the following Aggregate(s):

| Aggregate | Responsibility |
|-----------|----------------|
| Payment | Owns payment business behaviour |

No additional Aggregates participate in this Story.

If additional Aggregate interactions appear necessary during implementation, STOP implementation and request clarification.

---

# Required Aggregate Contracts

The implementation SHALL use only the approved Payment Aggregate Technical Specification.

Every interaction with the Payment Aggregate SHALL correspond directly to an approved public contract defined by the Aggregate Technical Specification.

The Application Service SHALL NOT:

- invent Aggregate operations;
- reinterpret Aggregate contracts;
- extend Aggregate capabilities;
- bypass Aggregate ownership.

If the approved workflow cannot be completed using the approved Aggregate contract, STOP implementation.

---

# Coordination Strategy

The Application Service coordinates the approved workflow.

The workflow SHALL:

1. receive the approved request;
2. invoke the approved Payment Aggregate operation;
3. return the approved result.

The Application Service SHALL NOT introduce additional workflow steps unless explicitly approved by the Story.

---

# Business Ownership

Business behaviour SHALL remain implemented by the Payment Aggregate.

The Application Service SHALL NOT own:

- business state;
- payment lifecycle;
- payment validation;
- business invariants;
- payment calculations;
- payment decisions.

Its responsibility is limited to coordinating the approved workflow.

---

# Expected Inputs

The Story defines the approved input.

Do not invent additional request parameters.

Do not infer optional inputs.

Do not introduce convenience overloads.

---

# Expected Outputs

The Story defines the approved output.

Return only the approved result.

Do not introduce additional response objects unless explicitly approved.

---

# Failure Handling

The Application Service SHALL fail explicitly whenever:

- required Aggregate contracts are unavailable;
- required workflow steps are undefined;
- required Story information is incomplete.

The Application Service SHALL NOT compensate for missing specifications by introducing assumptions.

---

# Testing Expectations

Generate automated tests that verify:

- workflow coordination;
- invocation of the approved Aggregate contract;
- expected execution sequence;
- approved outputs.

Tests SHALL NOT:

- duplicate Aggregate unit tests;
- validate Payment business rules;
- redefine Aggregate behaviour.

---

# Implementation Constraints

Implementation SHALL remain:

- stateless;
- behaviour-light;
- coordination-focused;
- architecture compliant;
- traceable to the approved Story.

All generated artifacts SHALL be written only to their approved Output Locations.

---

# Out of Scope

The following are explicitly outside the scope of this Story:

- Payment business rules;
- Payment validation;
- Payment lifecycle;
- Aggregate redesign;
- Repository implementation;
- Infrastructure concerns;
- Transaction management;
- Logging strategy;
- Framework configuration;
- Dependency Injection configuration.

---

# Completion Criteria

Before implementation is complete, verify that:

- the approved workflow has been implemented;
- only approved Aggregate contracts have been used;
- no Aggregate behaviour has been duplicated;
- no business rules have been introduced;
- no undocumented assumptions have been made;
- only approved Output Locations have been modified;
- all requested artifacts have been generated;
- automated tests satisfy the Story.

---

# Relationship to Other Documents

Implementation authority for this Story SHALL follow:

1. Engineering Constitution
2. Application Service Developer Prompt
3. Story.md
4. This Implementation Guide
5. Payment Aggregate Technical Specification
6. Software Architecture
7. Approved Reference Implementations

If any conflict exists, the higher-precedence document SHALL take priority.