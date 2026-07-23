# Constructor Patterns

```yaml
---
document_id: AI-REF-006
title: Constructor Patterns
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Constructor Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical constructor patterns used throughout the E-Fee platform.

Constructors are responsible for creating valid objects by establishing mandatory state and enforcing object invariants.

This document focuses on constructor implementation only.

For related implementation guidance, see:

- AggregateExamples
- ValueObjectExamples
- ValidationPatterns

---

# Constructor Responsibilities

Constructors are responsible for:

- creating valid objects;
- initializing mandatory state;
- validating constructor arguments;
- establishing object invariants.

Constructors SHALL NOT:

- perform business workflows;
- invoke infrastructure services;
- coordinate multiple Aggregates.

---

# Constructor Validation

Mandatory constructor arguments should be validated immediately.

Preferred implementation:

```java
public StudentNumber(String value) {

    Objects.requireNonNull(value);

    if (value.isBlank()) {
        throw new IllegalArgumentException(
                "Student Number cannot be blank.");
    }

    this.value = value;
}
```

---

# Mandatory State Initialization

Mandatory business state should be established during construction.

Preferred implementation:

```java
public Student(
        StudentId studentId,
        StudentNumber studentNumber,
        StudentName studentName) {

    this.studentId =
            Objects.requireNonNull(studentId);

    this.studentNumber =
            Objects.requireNonNull(studentNumber);

    this.studentName =
            Objects.requireNonNull(studentName);

    this.status = StudentStatus.ACTIVE;
}
```

The constructed object should always be valid.

---

# Immutable Fields

Fields that should never change after construction should be declared as `final`.

Preferred implementation:

```java
private final StudentId studentId;
```

Avoid:

```java
private StudentId studentId;
```

---

# Constructors Should Remain Simple

Constructors should only establish object state.

Avoid constructors that:

- perform business workflows;
- update other objects;
- invoke repositories;
- publish events;
- execute complex business logic.

---

# Construction Completes Initialization

The object should be ready for use immediately after construction.

Avoid partially initialized objects that require additional setup before they become valid.

---

# Common Mistakes

Avoid:

- missing null validation;
- optional initialization of mandatory fields;
- infrastructure dependencies;
- business workflows inside constructors;
- leaving objects in an incomplete state.

---

# Related Example Libraries

- AggregateExamples
- ValueObjectExamples
- ValidationPatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial constructor patterns extracted from validated Sprint-001 and Sprint-002 implementations. |