# Application Service Story Package Template

```yaml
---
document_id: AI-TPL-002
title: Application Service Story Package Template
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-18
last_updated: 2026-07-18

related_documents:
  - ../constitution/Engineering-Constitution.md
  - ../prompts/ApplicationServiceDeveloperPrompt.md
  - ../README.md
---
```

---

# Purpose

This document defines the standard structure for Application Service Story Packages used throughout the AI Engineering Framework.

An Application Service Story Package provides the complete engineering context required to implement a single Application Service.

Its purpose is to establish an explicit implementation contract between Product Engineering and AI Engineering while minimizing implementation ambiguity.

---

# Story Package Philosophy

Every Application Service Story SHALL be self-contained.

A Developer should be able to implement the Story using only:

- the approved Story Package;
- approved engineering documentation; and
- existing project source code.

Stories SHALL NOT depend upon undocumented assumptions.

Stories SHALL define workflow coordination rather than business behaviour.

Business behaviour remains owned by participating Aggregates.

---

# Standard Story Structure

Every Application Service Story SHOULD contain the following sections.

```text
Story Metadata

Business Objective

Approved Workflow

Participating Aggregates

Required Aggregate Contracts

Implementation Scope

Implementation Strategy

Engineering Contract

Write Scope

Output Locations

Authoritative Engineering Artifacts

Acceptance Criteria

Out of Scope

Completion Checklist
```

Sections that are not applicable may be omitted.

---

# Story Metadata

Every Story SHALL define:

- Story Identifier
- Title
- Status
- Owner
- Related Documents

Stories MAY additionally define:

- Sprint
- Dependencies
- Priority

Example:

```yaml
story_id: Story-008
title: Record Payment Application Service
status: Approved
owner: Product Owner
```

---

# Business Objective

Describe the business objective of the Application Service.

This section explains **why** the workflow exists.

It SHALL describe business intent rather than implementation details.

---

# Approved Workflow

Describe the approved business workflow coordinated by the Application Service.

The workflow SHALL describe:

- participating business operation;
- overall execution sequence;
- expected business outcome.

The workflow SHALL NOT redefine business behaviour owned by participating Aggregates.

---

# Participating Aggregates

Identify every Aggregate participating in the approved workflow.

Example:

| Aggregate | Responsibility |
|-----------|----------------|
| Payment | Records approved payments |
| Student | Maintains student information |

Only Aggregates listed in this section are approved participants.

If implementation requires additional participating Aggregates, implementation SHALL stop and clarification SHALL be requested.

---

# Required Aggregate Contracts

Identify the Aggregate Technical Specifications required to implement the approved workflow.

Every participating Aggregate SHALL reference its approved Aggregate Technical Specification.

Example:

```text
Payment Aggregate Technical Specification
Student Aggregate Technical Specification
```

The Application Service SHALL invoke only approved Aggregate public contracts.

Aggregate contracts SHALL NOT be invented, extended or reinterpreted.

---

# Implementation Scope

Implementation Scope defines the software artifacts produced by the Story.

Typical outputs include:

- Application Service
- Supporting Tests
- Story README

Implementation Scope authorizes **what** shall be implemented.

Write Scope authorizes **where** implementation may occur.

---

# Implementation Strategy

Describe the approved implementation approach.

Implementation Strategy SHALL describe:

- overall coordination approach;
- participating Aggregate interactions;
- workflow sequencing;
- implementation constraints.

Implementation Strategy SHALL NOT redefine architecture or business rules.

---

# Engineering Contract

The Engineering Contract defines the implementation boundary for the current Story.

The Developer SHALL implement only the functionality and artifacts explicitly authorized by this contract.

If implementation requires modification outside this contract, implementation SHALL stop and clarification SHALL be requested.

---

## Write Scope

The Developer MAY create or modify ONLY the approved artifacts listed by the Story.

### Source

```text
source/<ApplicationService>.java
```

### Tests

```text
tests/<ApplicationService>Test.java
```

### Documentation

```text
README.md
```

Artifacts not explicitly listed SHALL NOT be modified or created.

---

## Write Scope Principles

The Developer SHALL:

- modify only approved artifacts;
- create only approved artifacts;
- preserve all other project artifacts;
- request clarification before modifying artifacts outside the approved Write Scope.

Implementation permission SHALL NOT be inferred from project structure.

---

# Output Locations

The Story SHALL define the approved Output Location for every generated artifact.

Only approved Output Locations may be modified.

---

# Authoritative Engineering Artifacts

Every Story SHALL identify the engineering artifacts governing implementation.

Typical artifacts include:

- Engineering Constitution
- Application Service Developer Prompt
- Business Workflow
- Aggregate Technical Specifications
- Software Architecture
- Approved Reference Implementations (optional)

Only approved engineering artifacts SHALL govern implementation.

---

# Acceptance Criteria

Acceptance Criteria define the observable behaviour required for Story completion.

Acceptance Criteria SHALL be:

- observable;
- measurable;
- testable;
- implementation-independent.

Acceptance Criteria SHALL verify workflow coordination rather than Aggregate behaviour.

---

# Out of Scope

Explicitly identify functionality intentionally excluded from the Story.

Typical examples include:

- Aggregate implementation;
- Aggregate business rules;
- persistence implementation;
- REST APIs;
- infrastructure;
- authentication;
- optimization;
- future extensibility.

Out-of-scope functionality SHALL NOT be implemented.

---

# Story README

When approved by the Story, the implementation SHALL generate a README describing the completed implementation.

The README documents implementation outcomes.

It SHALL NOT redefine approved specifications, architecture or business behaviour.

---

# Completion Checklist

Before marking the Story complete, verify:

- approved workflow implemented;
- approved Aggregate contracts preserved;
- business ownership preserved;
- implementation remains within Story scope;
- only approved artifacts have been modified or created;
- only approved Output Locations have been used;
- no undocumented assumptions introduced;
- no Aggregate contracts invented, extended or reinterpreted;
- required automated tests generated;
- no unrelated functionality introduced.

---

# Story Design Principles

Application Service Story Packages SHOULD:

- minimize implementation ambiguity;
- define workflow coordination explicitly;
- preserve Aggregate ownership;
- maximize implementation clarity;
- establish explicit implementation authorization;
- discourage speculative implementation.

---

# Common Anti-Patterns

Poor Application Service Stories often:

- omit participating Aggregates;
- omit Aggregate contracts;
- omit workflow sequencing;
- redefine Aggregate behaviour;
- redefine business rules;
- omit implementation boundaries;
- rely upon undocumented assumptions;
- introduce future requirements.

These practices SHOULD be avoided.

---

# Story Flow

```text
Business Workflow
        │
        ▼
Application Service Story Package
        │
        ▼
Aggregate Technical Specifications
        │
        ▼
Application Service Developer Prompt
        │
        ▼
Implementation
```

The Story Package serves as the approved implementation contract between Product Engineering and AI Engineering.

---

# Evolution

This template evolves through practical implementation experience.

New sections SHALL be introduced only when implementation evidence demonstrates they reduce ambiguity or improve implementation quality.

The objective is to preserve simplicity while continually improving implementation reliability.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-18 | Initial Application Service Story Package Template derived from implementation experience during Sprint-001 and validation of Application Service stories. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-18