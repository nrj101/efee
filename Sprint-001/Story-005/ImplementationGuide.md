# Implementation Guide

---

# Objective

Implement the Fee Obligation Aggregate exactly as defined by the approved documentation.

The implementation SHALL preserve business behaviour without introducing additional functionality.

---

# Implementation Inputs

The implementation SHALL use the following documents.

- Story.md
- Fee Obligation Aggregate Design
- Fee Obligation Aggregate Technical Specification
- Fee Obligation Aggregate Persistence Model
- Business Rules
- Fee Obligation Management Workflow
- Engineering Constitution

---

# Aggregate Contract

Implement only the approved public API defined in the Aggregate Technical Specification.

This includes:

Constructor

```
FeeObligation(...)
```

Business Operations

```
update(...)

retire()
```

Accessors

```
getFeeObligationIdentifier()

getStudentIdentifier()

getAcademicYearIdentifier()

getFeeStructureIdentifier()

getObligationLines()

getOutstandingAmount()

isActive()
```

No additional public methods shall be introduced.

---

# Implementation Rules

The implementation SHALL:

- validate all constructor arguments;
- validate all business operation arguments;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve business invariants;
- preserve identifier immutability;
- reject duplicate Obligation Lines;
- reject null Obligation Lines;
- reject invalid lifecycle transitions;
- reject modification after retirement;
- return immutable collections;
- defensively copy externally supplied collections.

The implementation SHALL NOT:

- expose public setters;
- expose mutable Aggregate collections;
- introduce additional state;
- introduce helper classes;
- introduce persistence concerns;
- introduce framework dependencies;
- introduce undocumented behaviour.

---

# Unit Testing

Tests SHALL verify:

- successful Aggregate creation;
- constructor validation;
- successful update;
- update validation;
- retirement;
- repeated retirement rejection;
- update after retirement rejection;
- duplicate Obligation Line rejection;
- null Obligation Line rejection;
- immutable collection behaviour;
- defensive copy behaviour.

Each public operation SHALL have corresponding unit tests.

---

# Story Documentation

README.md SHALL contain:

- Story purpose;
- Aggregate responsibility;
- implemented files;
- supported operations;
- Aggregate invariants;
- implementation notes;
- testing summary.

---

# Output Files

Only the following files shall be generated.

```
/Sprint-001/Story-005/source/FeeObligation.java

/Sprint-001/Story-005/tests/FeeObligationTest.java

/Sprint-001/Story-005/README.md
```

Generation of any additional source artifact requires clarification before implementation.