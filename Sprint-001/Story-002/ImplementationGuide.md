# Implementation Guide

---

# Purpose

This guide provides implementation guidance specific to **Story-002 — Academic Year Aggregate**.

It supplements the approved Story Package by highlighting implementation considerations relevant to this Story.

This document does **not** redefine business behaviour, software architecture or Aggregate ownership.

The Product Specification, Software Architecture, Aggregate Technical Specification and Aggregate Persistence Model remain authoritative.

---

# Implementation Objective

Implement the **Academic Year Aggregate** exactly as defined by the approved architecture.

The implementation shall faithfully realize the approved Aggregate responsibilities while preserving all documented business invariants.

Implementation shall remain intentionally simple.

---

# Aggregate Context

This Story implements the following Aggregate Root:

**Academic Year**

The authoritative definition of the Aggregate, including:

- responsibilities;
- owned business truth;
- invariants;
- lifecycle;
- collaborating Aggregates;

is maintained in **AggregateDesign.md**.

The persistent representation is maintained in the **Academic Year Aggregate Persistence Model**.

This guide intentionally does not duplicate those documents.

---

# Implementation Guidance

The implementation should:

- realize only the approved Academic Year Aggregate;
- implement the Aggregate Model exactly as defined by the Persistence Model;
- preserve Aggregate autonomy;
- expose only approved business operations;
- avoid introducing infrastructure concerns;
- avoid introducing framework-specific behaviour.

Implementation should favour clarity and explicit business behaviour over unnecessary abstraction.

---

# Story Boundaries

The following capabilities belong to this Story:

- Create Academic Year
- Update Academic Year
- Activate Academic Year
- Close Academic Year

The following capabilities belong to other Stories and shall not be introduced here:

- Student management
- Fee Structure management
- Discount management
- Fee Obligation management
- Payment processing
- Receipt management

---

# Implementation Constraints

The implementation shall not introduce:

- additional Aggregate state;
- database persistence;
- repositories;
- REST APIs;
- dependency injection;
- messaging;
- logging;
- authentication;
- authorization;
- framework annotations;
- speculative functionality.

Future implementation shall extend the software through additional Story Packages rather than speculative implementation.

---

# Testing Guidance

Unit tests should validate:

- Aggregate creation;
- approved business operations;
- lifecycle transitions;
- constructor validation;
- update validation;
- Aggregate invariants.

Tests shall validate approved behaviour only.

Tests shall not introduce new business requirements.

---

# Developer Notes

When implementation decisions appear ambiguous:

1. consult the Product Specification;
2. consult the Software Architecture;
3. consult the Aggregate Technical Specification;
4. consult the Aggregate Persistence Model;
5. consult the Story Package.

If ambiguity remains, implementation shall stop and request clarification rather than introducing undocumented assumptions.

---

# Completion Reminder

Before completing the Story, verify that:

- implementation remains faithful to the approved Aggregate Design;
- implementation exactly matches the approved Aggregate Persistence Model;
- implementation scope has not expanded beyond the Story;
- no architectural responsibilities have been redefined;
- no business rules have been invented;
- only approved implementation artifacts have been modified.

The objective of this Story is to faithfully realize the approved Academic Year Aggregate—not to extend the product beyond the approved implementation scope.