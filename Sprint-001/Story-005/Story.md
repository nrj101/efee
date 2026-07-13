# Story

```yaml
---
story_id: Sprint-001 / Story-005
title: Fee Obligation Aggregate
status: Approved

epic: Fee Receivables MVP
sprint: Sprint-001

owner: Product Owner
reviewer: CTO

aggregate: Fee Obligation

priority: High
---
```

---

# Business Objective

Implement the Fee Obligation Aggregate.

The Aggregate owns a Student's financial responsibility for an Academic Year.

The implementation shall preserve Aggregate ownership, financial consistency and lifecycle integrity as defined by the approved architecture.

---

# Scope

This Story implements:

- Fee Obligation Aggregate Root
- Aggregate validation
- Aggregate lifecycle
- Aggregate update behaviour
- Unit tests
- Story documentation

No persistence, repositories, services or APIs are included.

---

# Read Scope

The implementation SHALL use the following approved documents.

## Mandatory

- Fee Obligation Aggregate Design
- Fee Obligation Aggregate Technical Specification
- Fee Obligation Aggregate Persistence Model
- Business Rules
- Fee Obligation Management Workflow

---

# Write Scope

Implementation SHALL modify ONLY the following files.

```
/Sprint-001/Story-005/source/FeeObligation.java

/Sprint-001/Story-005/tests/FeeObligationTest.java

/Sprint-001/Story-005/README.md
```

No additional files may be created.

---

# Expected Behaviour

The implementation SHALL:

- construct a valid Fee Obligation;
- expose only the approved public API;
- preserve Aggregate ownership;
- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate invariants;
- reject invalid lifecycle transitions;
- prevent modification after retirement;
- prevent duplicate Obligation Lines;
- prevent null Obligation Lines;
- prevent external mutation of Aggregate-owned collections.

Implementation SHALL NOT introduce behaviour not explicitly approved by the Aggregate Technical Specification.

---

# Acceptance Criteria

The implementation is complete when:

- FeeObligation.java is implemented.
- FeeObligationTest.java provides unit test coverage for every public operation.
- README.md documents the implementation.
- Aggregate behaviour conforms to the Aggregate Technical Specification.
- Aggregate state conforms to the Persistence Model.
- No files outside the approved Write Scope are modified.