# Value Object Examples

```yaml
---
document_id: AI-REF-002
title: Value Object Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Value Object Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing Value Objects within the E-Fee platform.

The examples in this document are derived from validated implementations completed during the project and represent the preferred Value Object implementation style.

This document focuses on Value Object responsibilities only.

For related implementation guidance, see:

- ValidationPatterns
- ConstructorPatterns

---

# Value Object Responsibilities

A Value Object is responsible for:

- representing a business concept;
- validating its own state;
- remaining immutable after construction;
- providing value-based equality.

A Value Object SHALL NOT:

- own business behaviour;
- maintain lifecycle state;
- reference infrastructure;
- expose mutators.

---

# Canonical Value Object Structure

```java
public final class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {

        Objects.requireNonNull(amount);

        if (amount.signum() < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }

        this.amount = amount;
    }

    public BigDecimal amount() {
        return amount;
    }

}
```

---

# What This Demonstrates

- immutable state;
- constructor validation;
- no setters;
- self-validating object;
- simple business representation.

---

# Value Objects Validate Themselves

Each Value Object is responsible for ensuring that it never represents an invalid business value.

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

Validation should occur during construction.

---

# Immutability

Value Objects should be immutable.

Preferred implementation:

```java
private final StudentName studentName;
```

Avoid:

```java
private StudentName studentName;

public void setStudentName(StudentName studentName) {
    this.studentName = studentName;
}
```

---

# Equality

Two Value Objects are equal when their values are equal.

Preferred implementation:

```java
@Override
public boolean equals(Object other) {
    ...
}

@Override
public int hashCode() {
    ...
}
```

Equality should be based solely on the contained value.

---

# Common Examples

Typical Value Objects within E-Fee include:

- StudentNumber
- StudentName
- ReceiptNumber
- AcademicYearName
- Money
- Percentage

---

# Common Mistakes

Avoid:

- mutable fields;
- setters;
- partial validation;
- infrastructure dependencies;
- lifecycle behaviour;
- business workflows.

---

# Related Example Libraries

- ValidationPatterns
- ConstructorPatterns
- AggregateExamples
- UnitTestExamples

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial Value Object implementation examples extracted from validated Sprint-001 and Sprint-002 implementations. |