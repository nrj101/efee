# AI Engineering Framework Improvement Backlog

```yaml
---
document_id: AI-FWK-IMPROVEMENT-001
title: AI Engineering Framework Improvement Backlog
version: 1.0.0
status: Active

owner: Chief Architect
reviewer: CTO

created: 2026-07-13
last_updated: 2026-07-13

related_documents:
  - Engineering-Constitution.md
  - DeveloperPersona.md
  - Developer_Runtime_Prompt.md
  - CanonicalExamples.md
---
```

---

# Purpose

This document captures implementation observations, lessons learned and proposed improvements identified while developing the E-Fee platform using the AI Engineering Framework.

Unlike speculative improvements, every observation recorded here originates from actual implementation experience and review of completed Stories.

The objective is to continuously improve the AI Engineering Framework while preserving development velocity.

---

# Scope

This document covers improvements to:

- Engineering Constitution
- Developer Persona
- Developer Runtime Prompt
- Story Package
- Implementation Guide
- Aggregate Technical Specification (ATS)
- Persistence Models
- Canonical Examples
- Review Process
- Prompt Templates

This document SHALL NOT introduce changes to Product Specifications or Business Rules.

---

# Current Status

Implementation experience has been gathered from:

- Sprint-001 / Story-001
- Sprint-001 / Story-002
- Sprint-001 / Story-003

These Stories were implemented using the local LLM through Continue for VS Code, followed by human review and refinement.

---

# Key Observations

## 1. Story Packages significantly improve implementation quality

Providing an explicit Story Package reduced architectural invention and kept implementations focused on the approved Story.

Observed improvement:

- reduced speculative implementation
- reduced architectural drift
- improved implementation consistency

Priority: High

---

## 2. Aggregate Technical Specifications reduce ambiguity

Adding an Aggregate Technical Specification greatly reduced ambiguity regarding:

- Aggregate ownership
- Lifecycle
- Responsibilities
- Business invariants

However, early ATS documents still allowed implementation assumptions.

Priority: High

---

## 3. Persistence Models improve implementation consistency

Persistence Models reduced ambiguity around:

- Aggregate state
- Mutability
- Ownership
- Persistent fields

The implementation became more consistent after introducing explicit Persistent State tables.

Priority: High

---

## 4. Local LLM tends to invent implementation details

Observed recurring behaviour:

- package declarations
- repositories
- services
- DTOs
- Aggregate wrappers
- lifecycle states
- setters
- additional classes
- Maven layouts

This behaviour reduced after improving Story documentation but has not been fully eliminated.

Priority: High

---

## 5. Local LLM frequently assumes standard Java conventions

Examples:

- equals()
- hashCode()
- setters
- constructors
- package names
- repository interfaces
- service classes

These assumptions frequently exceeded Story scope.

Priority: High

---

## 6. Prompt wording significantly affects implementation quality

Prompt refinements that improved output included:

- explicit Write Scope enforcement
- clarification-first behaviour
- prohibition on assumptions
- staged execution
- explicit implementation validation

Prompt quality had a greater impact than expected.

Priority: High

---

## 7. Context quality is more important than context quantity

Attaching many documents reduced implementation consistency.

Better results were obtained by attaching:

- Story Package
- Engineering documents
- only directly relevant technical specifications

rather than the complete specification set.

Priority: High

---

## 8. Canonical Examples should evolve only after review

Canonical Examples should represent approved engineering patterns.

Only reviewed and merged implementations should become Canonical Examples.

Priority: Medium

---

# Proposed Improvements

---

# Engineering Constitution

Potential additions:

- Aggregate ownership rules
- Collection encapsulation
- Aggregate invariant preservation
- No speculative architecture
- Clarification over assumption
- Review-ready implementation expectations

Priority: High

---

# Developer Persona

Potential additions:

- Behave as a Senior Software Engineer
- Preserve architecture before implementation
- Avoid speculative implementation
- Optimise for maintainability
- Prefer explicit clarification over assumptions

Priority: Medium

---

# Developer Runtime Prompt

Potential improvements:

- mandatory context verification
- staged implementation workflow
- assumption prevention
- implementation validation
- completion checklist
- Write Scope enforcement
- clarification gates

Priority: Very High

---

# Story Template

Potential additions:

- Required Context
- Output Locations
- Write Scope
- Acceptance Criteria
- Dependencies
- Implementation Constraints

Priority: High

---

# Implementation Guide

Potential additions:

- implementation sequence
- testing expectations
- validation expectations
- README expectations
- review checklist

Priority: High

---

# Aggregate Technical Specification

ATS should define implementation contracts without becoming source code.

Potential additions:

- approved Aggregate state
- approved operations
- supporting entities
- visibility expectations
- mutability expectations
- Aggregate ownership
- lifecycle expectations

ATS SHALL remain implementation-neutral.

Priority: High

---

# Persistence Model

Potential additions:

- approved persistent fields
- mutability
- derived state
- transient state
- implementation constraints
- traceability

Priority: Medium

---

# Prompt Templates

Continue evaluating:

- staged prompts
- embedded context references
- clarification-first prompts
- deterministic execution
- implementation completion validation

Priority: High

---

# Review Process

Formalise engineering review.

Suggested review checklist:

- Story compliance
- Write Scope compliance
- Aggregate ownership
- Business invariant preservation
- Implementation quality
- Testing completeness
- Documentation quality

Priority: Medium

---

# Canonical Examples

Canonical Examples SHALL:

- originate from merged implementations
- represent approved engineering patterns
- never represent experimental implementations

Priority: Medium

---

# Success Metrics

The AI Engineering Framework should evolve toward:

- minimal architectural invention
- deterministic implementations
- Story compliance
- consistent engineering quality
- review time under approximately 15 minutes
- merge-ready implementations after normal engineering review

---

# Current Assessment

Implementation quality has improved substantially across Sprint-001.

Observed progression:

Story-001

- Basic implementation
- Required significant review

Story-002

- Improved lifecycle handling
- Reduced architectural invention

Story-003

- Aggregate ownership preserved
- Business invariants enforced
- Mutable state encapsulated
- Review effort significantly reduced

The current framework demonstrates that specification-driven AI-assisted development is practical for implementation of well-defined Stories.

Future framework evolution should prioritise reducing ambiguity while preserving engineering judgement.

---

# Future Work

The AI Engineering Framework should continue evolving incrementally.

Framework improvements SHALL be driven by implementation experience rather than speculative enhancement.

Each completed Sprint SHOULD include a retrospective to identify recurring implementation patterns and update the framework where justified.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-13 | Initial implementation observations captured after Sprint-001 Stories 001–003. |

---

# Approval

**Status:** Active