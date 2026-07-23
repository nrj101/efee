# Canonical Engineering Examples

```yaml
---
document_id: AI-REF-001
title: Canonical Engineering Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Developer Learning Examples
last_updated: 2026-07-17
---
```

---

# Purpose

This document contains canonical engineering examples that demonstrate the expected implementation style for Developer personas.

These examples teach engineering style rather than business behaviour.

They illustrate:

- implementation style;
- engineering judgement;
- coding conventions;
- testing style;
- documentation style.

Business behaviour SHALL NOT be copied unless it is relevant to the current Story.

If a Story Package conflicts with these examples, the Story Package always takes precedence.

---

# Engineering Principles

Future implementations SHOULD:

- preserve Aggregate ownership;
- preserve business invariants;
- prefer simple implementations;
- validate inputs early;
- fail fast on invalid state;
- prefer immutable implementations where practical;
- maximise compile-time safety;
- minimise mutable state;
- implement only approved Story scope.

Future implementations SHALL NOT introduce:

- Repository
- Service Layer
- Factory
- Builder
- Dependency Injection
- REST
- Database
- Frameworks

unless explicitly requested by the approved Story.

---

# Canonical Aggregate Example

The following example demonstrates the preferred Aggregate implementation style.

```java
import java.util.Objects;
import java.util.UUID;

public class Member {

    private final UUID memberId;
    private final String name;

    public Member(String name) {

        this.memberId = UUID.randomUUID();

        this.name = Objects.requireNonNull(name);

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Member name cannot be blank.");
        }
    }

    public UUID getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
```

---

# What This Example Demonstrates

- Constructor validates inputs.
- Aggregate owns business state.
- Identifier is immutable.
- Fields are immutable.
- Business validation occurs inside the Aggregate.
- No Repository.
- No Service.
- No framework annotations.

---

# Canonical Lifecycle Example

Finite lifecycle states should prefer language-supported enumerations.

```java
public enum PaymentLifecycle {

    RECORDED,
    REALISED,
    CANCELLED

}
```

The Aggregate owns lifecycle transitions.

```java
public void realise() {

    if (lifecycle != PaymentLifecycle.RECORDED) {
        throw new IllegalStateException(
                "Payment has already been finalised.");
    }

    lifecycle = PaymentLifecycle.REALISED;
}
```

---

# What This Example Demonstrates

- finite lifecycle represented as an enum;
- Aggregate controls lifecycle transitions;
- compile-time safety preferred over String constants;
- lifecycle behaviour remains explicit.

---

# Canonical Value Object Example

Supporting Value Objects should normally be immutable.

```java
public final class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {

        this.amount = Objects.requireNonNull(amount);

        if (amount.signum() < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }
    }

    public BigDecimal amount() {
        return amount;
    }
}
```

---

# What This Example Demonstrates

- immutable Value Object;
- constructor validation;
- no mutators;
- invalid state prevented during construction.

---

# Canonical Unit Test Example

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void shouldCreateMember() {

        Member member = new Member("Alice");

        assertNotNull(member.getMemberId());
        assertEquals("Alice", member.getName());
    }

    @Test
    void shouldRejectBlankName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Member("")
        );
    }

    @Test
    void shouldRejectNullName() {

        assertThrows(
                NullPointerException.class,
                () -> new Member(null)
        );
    }
}
```

---

# What This Test Demonstrates

Tests should verify:

- successful construction;
- constructor validation;
- business operations;
- lifecycle transitions;
- invalid operations.

Tests should:

- remain independent;
- avoid implementation details;
- remain readable;
- verify approved behaviour only.

---

# Canonical Story README

```markdown
# Story-001 Implementation Summary

## Story

Register Member

---

## Artifacts

### Source

- Member.java

### Tests

- MemberTest.java

---

## Business Rules

Implemented

- BR-001

---

## Assumptions

None.

---

## Architecture

Aggregate boundaries preserved.

No additional architectural components introduced.
```

---

# What This README Demonstrates

Every completed Story SHOULD document:

- implementation summary;
- generated artifacts;
- implemented business rules;
- assumptions;
- architecture observations.

README documents implementation.

It SHALL NOT redefine requirements.

---

# Patterns To Follow

Future implementations SHOULD:

- keep constructors small;
- validate inputs immediately;
- preserve Aggregate ownership;
- preserve business invariants;
- prefer immutable state;
- use enums for finite lifecycle states;
- produce focused unit tests;
- generate concise README documentation;
- preserve approved architecture;
- implement only approved Story scope.

---

# Patterns To Avoid

Future implementations SHALL NOT:

- invent business behaviour;
- introduce architectural layers;
- speculate about future requirements;
- modify artifacts outside the approved Write Scope;
- create unrelated files;
- over-engineer simple Stories;
- use String constants for finite lifecycle states unless explicitly required by the Architecture.

---

# Relationship With Story Packages

Canonical Examples demonstrate engineering style.

Story Packages define business behaviour.

When conflicts occur, the following precedence SHALL apply.

1. Story Package
2. Business Rules
3. Software Architecture
4. Canonical Engineering Examples

The Story Package always takes precedence.

---

# Success Criteria

A successful Developer implementation demonstrates:

- compliance with the approved Story;
- preservation of Business Rules;
- preservation of Software Architecture;
- disciplined engineering judgement;
- implementation within the approved Write Scope;
- absence of undocumented assumptions;
- consistency with these engineering examples.