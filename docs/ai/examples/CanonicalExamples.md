# Canonical Engineering Examples

```yaml
---
document_id: AI-REF-001
title: Canonical Engineering Examples
version: 0.1.0
status: Approved

owner: Product Owner

purpose: Developer Learning Examples
---
```

---

# Purpose

This document contains canonical engineering examples for the Library Lending System.

Its purpose is to demonstrate the expected engineering standards for future Developer implementations.

These examples define:

- implementation style;
- coding standards;
- testing style;
- documentation style.

The examples are provided for learning purposes only.

Business behaviour from these examples SHALL NOT be copied unless relevant to the current Story.

When the current Story conflicts with these examples, the current Story always takes precedence.

---

# Engineering Principles

Future implementations should follow these principles.

- Prefer simple implementations.
- Preserve Aggregate boundaries.
- Place business validation inside the Aggregate.
- Avoid speculative abstractions.
- Generate immutable identifiers.
- Keep classes cohesive.
- Keep tests readable.
- Implement only approved Story scope.

Do NOT introduce:

- Repository
- Service Layer
- Factory
- Builder
- Dependency Injection
- REST
- Database
- Frameworks

unless explicitly requested by the Story.

---

# Canonical Aggregate Example

The example below demonstrates the preferred implementation style.

```java
import java.util.UUID;

public class Member {

    // Immutable business identifier
    private final UUID memberId;

    // Immutable business data
    private final String name;

    public Member(String name) {

        // Business validation belongs inside the Aggregate.
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Member name cannot be null or blank.");
        }

        // Identifier generated once during construction.
        this.memberId = UUID.randomUUID();

        this.name = name;
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

- Constructor performs validation.
- Aggregate owns its business data.
- Identifier is immutable.
- No Repository.
- No Service.
- No framework annotations.
- Simple object-oriented design.

---

# Canonical Unit Test Example

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void shouldRegisterMemberSuccessfully() {

        Member member = new Member("Alice");

        assertNotNull(member.getMemberId());
        assertEquals("Alice", member.getName());
    }

    @Test
    void shouldRejectBlankMemberName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Member("")
        );
    }

    @Test
    void shouldRejectNullMemberName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Member(null)
        );
    }
}
```

---

# What This Test Demonstrates

- One test class per Aggregate.
- Test successful behaviour.
- Test validation failures.
- Keep tests independent.
- Keep assertions simple.
- Do not test implementation details.

---

# Canonical Story README

```markdown
# Story-001 Implementation Summary

## Story

Register Member

---

## Artifacts

Source

- Member.java

Tests

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

Every completed Story should document:

- implementation summary;
- generated artifacts;
- implemented Business Rules;
- assumptions;
- architecture observations.

README documents implementation.

It SHALL NOT redefine requirements.

---

# Patterns To Follow

Future implementations SHOULD:

- follow the same class structure;
- keep constructors small;
- validate business inputs early;
- use immutable identifiers;
- generate meaningful unit tests;
- produce concise README documentation;
- preserve approved architecture;
- implement only the current Story.

---

# Patterns To Avoid

Future implementations SHALL NOT:

- invent business behaviour;
- introduce architectural layers;
- speculate about future requirements;
- modify artifacts outside the Story Write Scope;
- create unrelated files;
- over-engineer simple Stories.

---

# Relationship With Story Packages

Canonical Examples demonstrate **engineering style**.

Story Packages define **business behaviour**.

If they differ:

1. Story Package
2. Business Rules
3. Software Architecture
4. Canonical Examples

The Story Package always takes precedence.

---

# Success Criteria

A successful Developer implementation demonstrates:

- consistency with these engineering examples;
- compliance with the approved Story;
- preservation of Business Rules;
- preservation of Architecture;
- implementation within the approved Write Scope;
- absence of undocumented assumptions.