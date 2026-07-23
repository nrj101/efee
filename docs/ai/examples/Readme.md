# Example Library

```yaml
---
document_id: AI-REF-000
title: Example Library
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Example Library Overview
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This folder contains reusable engineering examples and implementation patterns extracted from validated E-Fee implementations.

These examples demonstrate preferred engineering practices for this project. They supplement the Story Package by illustrating how approved solutions have been implemented elsewhere in the codebase.

Example documents are intended to be loaded selectively based on the implementation being performed.

---

# Available Example Libraries

| Document | Purpose | Status |
|----------|---------|--------|
| Aggregate | Aggregate implementation patterns | ✅ |
| ValueObject | Value Object implementation patterns | ✅ |
| SupportingType | Supporting Type implementation patterns | ✅ |
| LifecyclePatterns | Lifecycle modelling patterns | ✅ |
| ValidationPatterns | Validation and business rule patterns | ✅ |
| ConstructorPatterns | Constructor design patterns | ✅ |
| MethodPatterns | Business method patterns | ✅ |
| CollectionPatterns | Collection ownership and encapsulation | ✅ |
| ApplicationService | Application Service implementation | ✅ |
| PersistenceModel | Persistence model implementation | ✅ |
| UnitTestExamples | Unit testing patterns | ✅ |
| DocumentationExamples | Story README examples | ✅ |
| ArchitectureResponsibilities | Layer responsibilities | ✅ |
| DomainEvent | Domain Event patterns | Planned |
| Repository | Repository patterns | Planned |
| Mapper | Mapper patterns | Planned |
| Projection | Projection patterns | Planned |
| RestController | REST API patterns | Planned |

---

# Selecting Example Libraries

Load only the example libraries that are relevant to the current Story.

For example:

- Aggregate implementation → Aggregate, ValidationPatterns, ConstructorPatterns
- Application Service → ApplicationService
- Persistence implementation → PersistenceModelExamples
- Unit testing → UnitTest

Most Stories require only a small subset of the available examples.

---

# Evolution

This library evolves alongside the project.

New example documents should be added only after implementation patterns have been validated through completed Stories and approved engineering decisions.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial modular example library introduced following Sprint-002. |