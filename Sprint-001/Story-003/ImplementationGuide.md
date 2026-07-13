# Implementation Guide

---

# Purpose

This guide provides implementation guidance specific to **Story-003 — Fee Structure Aggregate**.

The Product Specification, Software Architecture, Aggregate Technical Specification and Aggregate Persistence Model remain authoritative.

---

# Implementation Objective

Implement the Fee Structure Aggregate exactly as defined by the approved Software Architecture.

The implementation shall faithfully realize the approved Aggregate responsibilities while preserving all documented business invariants.

---

# Aggregate Context

This Story implements the following Aggregate Root.

**Fee Structure**

The authoritative definition of:

- responsibilities;
- owned business truth;
- lifecycle;
- invariants;
- collaborating Aggregates;

is maintained by the approved Architecture documentation.

The persistent representation is maintained by the approved Persistence Model.

---

# Implementation Guidance

The implementation should:

- realize only the approved Fee Structure Aggregate;
- implement the Aggregate Model exactly as defined by the Persistence Model;
- preserve Aggregate autonomy;
- expose only approved business operations;
- avoid introducing infrastructure concerns;
- avoid framework-specific behaviour.

Implementation should favour clarity over unnecessary abstraction.

---

# Story Boundaries

This Story includes:

- Create Fee Structure
- Update Fee Structure
- Activate Fee Structure
- Deactivate Fee Structure

This Story excludes:

- Student management
- Academic Year management
- Discount management
- Fee Obligation management
- Payment processing
- Receipt generation

---

# Implementation Constraints

The implementation shall not introduce:

- additional Aggregate state;
- persistence infrastructure;
- repositories;
- REST APIs;
- dependency injection;
- messaging;
- logging;
- authentication;
- authorization;
- framework annotations;
- speculative implementation.

---

# Testing Guidance

Unit tests should validate:

- Aggregate creation;
- constructor validation;
- approved business operations;
- lifecycle transitions;
- Aggregate invariants;
- update validation.

Tests shall validate approved behaviour only.

---

# Developer Notes

When implementation decisions appear ambiguous:

1. consult the Product Specification;
2. consult the Software Architecture;
3. consult the Aggregate Technical Specification;
4. consult the Aggregate Persistence Model;
5. consult the Story Package.

If ambiguity remains, STOP implementation and request clarification.

---

# Completion Reminder

Before completing the Story, verify:

- implementation remains faithful to the approved Aggregate Design;
- implementation exactly matches the approved Persistence Model;
- implementation scope has not expanded beyond the Story;
- no architectural responsibilities have been redefined;
- no business rules have been invented;
- only approved implementation artifacts have been modified.