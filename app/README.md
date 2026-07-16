# E-Fee Production Application

---

# Purpose

The `app` module contains the executable production implementation of the
Student Fee Receivables Platform.

Reference implementations generated during Sprint execution remain under
`Sprint-XXX` and are never modified after approval.

Production code is integrated into the `app` module after implementation
review, architectural validation and successful build verification.

The `app` module is the only source deployed to Development, QA, UAT and
Production environments.

---

# Repository Structure

```text
Sprint-XXX
        │
        ▼
Reference Implementation
        │
        ▼
Implementation Review
        │
        ▼
Production Integration
        │
        ▼
app/
```

The `Sprint-XXX` folders preserve the approved reference implementations
generated during Sprint execution.

The `app` module contains the production-ready implementation assembled
from those approved reference implementations.

---

# Production Source Layout

```text
app
└── src
    ├── main
    │   └── java
    │       └── com.efee
    │
    ├── test
    │   └── java
    │       └── com.efee
    │
    └── resources
```

Production code follows the approved package structure defined by the
Software Architecture.

---

# Build

The application uses Gradle.

Run a complete build:

```bash
./gradlew clean build
```

Run all unit tests:

```bash
./gradlew test
```

Generate the test report:

```bash
./gradlew test
```

The HTML report is generated under:

```text
build/reports/tests/test/index.html
```

---

# Development Workflow

Development follows the approved engineering workflow.

```text
Business Specification
        │
        ▼
Software Architecture
        │
        ▼
Story Package
        │
        ▼
Reference Implementation
        │
        ▼
Implementation Review
        │
        ▼
Production Integration
        │
        ▼
Executable Application
```

Only reviewed and approved implementations are integrated into the
production application.

---

# Engineering Principles

The production application follows the approved engineering standards.

- Business-first design.
- Domain-Driven Design.
- Aggregate ownership preservation.
- Immutable Value Objects.
- Stable Aggregate boundaries.
- Framework-independent domain model.
- Comprehensive automated unit testing.

---

# Relationship to Sprint Packages

Sprint folders are historical implementation records.

They preserve:

- Story Package
- Implementation Guide
- Reference implementation
- Unit tests
- Story documentation

Once approved, implementations are integrated into the production
application.

Future development SHALL occur within the `app` module.

Reference implementations remain preserved for traceability and shall not
be modified after Sprint approval.

---

# Related Documents

- README.md
- Software Architecture
- Aggregate Design
- Sprint-001
- Specification Standards

---

# Current Baseline

Current production baseline:

```text
Sprint-001
```

This baseline establishes the first executable reference implementation
of the Student Fee Receivables Platform.