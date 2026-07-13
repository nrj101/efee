# AI Engineering Framework Improvement Backlog

```yaml
---
document_id: AI-FEEDBACK-001
title: AI Engineering Framework Improvement Backlog
version: 1.0.0
status: Living Document

owner: Product Owner

created: 2026-07-13
last_updated: 2026-07-13
---
```

---

# Purpose

This document captures observations, lessons learned and proposed improvements identified while implementing the EFee MVP using the AI Engineering Framework.

The purpose of this backlog is to preserve improvement ideas without interrupting MVP delivery.

Framework improvements should be implemented only when they provide measurable engineering value.

---

# Current Strategy

Current priority:

> Deliver the EFee MVP while validating the AI Engineering Framework through real implementation work.

The framework should evolve gradually based on evidence gathered from actual Story implementations rather than speculative design.

---

# Observations from Sprint-001

Implementation of Stories 001–005 demonstrated several recurring patterns.

The majority of review comments were not caused by missing business context.

Instead, they were caused by missing engineering conventions.

Typical examples included:

- Aggregate invariant enforcement
- Defensive copying
- Immutable collection exposure
- Duplicate detection
- Lifecycle validation
- Ownership preservation
- Test completeness
- README completeness

These observations indicate that the Engineering Framework should increasingly teach engineering behaviour rather than implementation details.

---

# Guiding Principle

Move stable engineering behaviour into the framework.

Avoid embedding implementation-specific instructions inside:

- Story.md
- ImplementationGuide.md
- Aggregate Technical Specifications

Stories should describe **what** to implement.

The framework should guide **how** to implement.

---

# Proposed Framework Evolution

## Phase 1 — Engineering Constitution Evolution

Expand the Engineering Constitution into the primary engineering policy document.

Potential additions include:

- Specification Authority
- Story Scope Preservation
- Aggregate Ownership Preservation
- Contract Preservation
- Persistent State Preservation
- Domain Inference Prevention
- Review Behaviour
- Test Philosophy
- Quality Gates
- Engineering Anti-patterns

The Constitution should define permanent engineering rules that apply across all projects.

---

## Phase 2 — Developer Runtime Prompt Evolution

Reduce the Runtime Prompt to execution guidance only.

Potential improvements:

- Context loading workflow
- Story analysis workflow
- Output validation workflow
- Assumption handling workflow
- Review implementation workflow
- Completion checklist refinement

The Runtime Prompt should describe execution rather than engineering policy.

---

## Phase 3 — Developer Persona Evolution

Expand the Developer Persona to better emulate an experienced software engineer.

Potential improvements:

- Defensive programming mindset
- Ownership thinking
- Review-driven refinement
- Incremental implementation
- Test-first thinking
- Simplicity preference
- Architecture awareness

The Persona should influence engineering judgement rather than implementation mechanics.

---

## Phase 4 — Project Implementation Standards Migration

Move implementation standards currently embedded inside the Runtime Prompt into the Engineering Constitution.

Examples include:

- BigDecimal usage
- LocalDate usage
- Instant usage
- Immutable collections
- Aggregate identity
- Historical data preservation
- Null handling
- Default implementation behaviour

This avoids duplication across Runtime Prompts.

---

## Phase 5 — AI Review Behaviour

Teach the framework to naturally behave like an experienced reviewer.

Potential behaviour:

- Detect invariant violations
- Detect ownership violations
- Detect mutable exposure
- Detect missing validation
- Detect lifecycle issues
- Detect incomplete tests
- Detect undocumented assumptions

The objective is to reduce manual review effort.

---

## Phase 6 — Story Package Simplification

As framework maturity increases:

Story Packages should become progressively smaller.

Move reusable engineering guidance into the framework.

Keep Story Packages focused on:

- Business behaviour
- Acceptance criteria
- Output files
- Story-specific constraints

---

## Phase 7 — Canonical Examples

Introduce high-quality reference implementations.

Examples should demonstrate:

- Aggregate implementation
- Value Object implementation
- Application Service implementation
- Domain Service implementation
- Repository implementation
- Unit testing style
- README structure

These examples should influence implementation style without becoming templates.

---

## Phase 8 — Quality Gates

Introduce lightweight engineering quality gates.

Potential gates include:

### Design

- Ownership preserved
- Responsibilities correct
- Invariants protected

### Code

- Defensive copying
- Immutable exposure
- Validation completeness
- Simplicity

### Testing

- Happy path
- Validation failures
- Lifecycle transitions
- Boundary conditions

### Documentation

- Story README
- Traceability
- Implementation summary

---

# Validation Strategy

Framework improvements should always be validated using real Stories.

Recommended validation process:

1. Implement Story using current framework.
2. Perform human review.
3. Capture recurring review comments.
4. Update framework.
5. Implement next Story.
6. Compare review effort.

The objective is to progressively reduce the time required to reach merge-ready code.

---

# Success Metrics

Potential metrics include:

- Average review comments per Story
- Average implementation time
- Average review time
- Number of regenerated files
- Number of manual code edits
- Stories merged without architectural changes

---

# Current Decision

Decision:

Do not pause MVP delivery for framework evolution.

Continue implementing Stories while recording framework improvements in this backlog.

Framework evolution should occur incrementally and be justified by repeated engineering observations.

---

# Status

Current Status:

- Framework validated through multiple Stories.
- Improvement opportunities identified.
- MVP delivery remains the primary objective.
- Framework evolution will proceed alongside product development.

# Future Research Topics

The following areas are intentionally deferred until after the MVP.

- Multi-language support
- Framework-specific conventions (Spring Boot)
- JPA / Persistence conventions
- API implementation standards
- Event-driven implementation standards
- AI-assisted code review automation
- AI-assisted refactoring
- Automatic Story Package generation
- Canonical implementation library
- Self-improving engineering prompts
- AI engineering metrics dashboard