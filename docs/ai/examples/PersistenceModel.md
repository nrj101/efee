# Persistence Model Examples

```yaml
---
document_id: AI-REF-010
title: Persistence Model Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Persistence Model Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing Persistence Models within the E-Fee platform.

Persistence Models represent how domain information is stored and retrieved from the underlying data store. They exist to support persistence and should remain separate from the domain model.

This document focuses on Persistence Model responsibilities only.

For related implementation guidance, see:

- AggregateExamples
- ApplicationServiceExamples
- ArchitectureResponsibilities

---

# Persistence Model Responsibilities

A Persistence Model is responsible for:

- representing data for persistence;
- mapping domain state to storage;
- supporting repository operations;
- reflecting the persistence schema.

A Persistence Model SHALL NOT:

- implement business rules;
- own business behaviour;
- coordinate business workflows;
- contain domain decision logic.

---

# Canonical Persistence Model Structure

```java
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    private String paymentId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}
```

---

# Persistence Models Represent Stored Data

Persistence Models should contain only the data required for persistence.

Business behaviour belongs in the corresponding Aggregate.

Preferred implementation:

```java
PaymentEntity
```

Avoid:

```java
public void realise() {
    ...
}
```

---

# Persistence Models Mirror Storage

Persistence Models should accurately represent the persistence schema.

Examples include:

- identifiers;
- primitive values;
- embedded objects;
- persistence relationships.

Business concepts should remain in the domain model.

---

# Persistence Models Are Infrastructure Objects

Persistence Models belong to the infrastructure layer.

They should not be exposed directly to:

- Application Services;
- domain objects;
- business workflows.

---

# Mapping Between Models

Repositories are responsible for converting between:

```text
Persistence Model
        ⇅
Repository
        ⇅
Domain Aggregate
```

Each model remains focused on its own responsibility.

---

# Persistence Models Should Remain Simple

Persistence Models should primarily contain:

- fields;
- persistence annotations;
- constructors;
- getters/setters required by the persistence framework.

Complex business logic should never be added.

---

# Common Mistakes

Avoid:

- business methods;
- business validation;
- lifecycle decisions;
- orchestration logic;
- infrastructure leaking into the domain model;
- exposing Persistence Models outside the infrastructure layer.

---

# Related Example Libraries

- AggregateExamples
- ApplicationServiceExamples
- ArchitectureResponsibilities

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial Persistence Model examples extracted from validated Sprint-002 implementations. |