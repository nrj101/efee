# Application Service Examples

```yaml
---
document_id: AI-REF-009
title: Application Service Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Application Service Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing Application Services within the E-Fee platform.

Application Services coordinate use cases by orchestrating interactions between Aggregates and infrastructure while ensuring that business rules remain within the domain model.

This document focuses on Application Service responsibilities only.

For related implementation guidance, see:

- AggregateExamples
- SupportingTypeExamples
- ArchitectureResponsibilities

---

# Application Service Responsibilities

An Application Service is responsible for:

- coordinating a business use case;
- loading and saving Aggregates;
- invoking Aggregate business behaviour;
- coordinating transactional boundaries;
- interacting with infrastructure.

An Application Service SHALL NOT:

- own business state;
- implement business rules;
- manipulate Aggregate state directly;
- perform persistence logic itself.

---

# Canonical Application Service Structure

```java
public class PaymentApplicationService {

    private final PaymentRepository paymentRepository;

    public PaymentApplicationService(
            PaymentRepository paymentRepository) {

        this.paymentRepository = paymentRepository;
    }

}
```

---

# Orchestrate The Use Case

Application Services coordinate the flow of a business operation.

Preferred implementation:

```java
public void realisePayment(
        PaymentId paymentId) {

    Payment payment =
            paymentRepository.find(paymentId);

    payment.realise();

    paymentRepository.save(payment);
}
```

The business decision remains inside the Aggregate.

---

# Delegate Business Behaviour

Application Services should invoke business methods rather than implementing business rules.

Preferred implementation:

```java
payment.allocate(request);
```

Avoid:

```java
if (payment.getStatus() == RECORDED) {
    payment.setStatus(REALISED);
}
```

Business rules belong inside the Aggregate.

---

# Coordinate Multiple Aggregates

When a use case involves multiple Aggregates, the Application Service coordinates their interaction.

Example:

```java
Payment payment = ...

FeeObligation obligation = ...

payment.allocate(...);

obligation.applyAllocation(...);

paymentRepository.save(payment);

feeObligationRepository.save(obligation);
```

Each Aggregate remains responsible for its own business rules.

---

# Infrastructure Interaction

Application Services interact with infrastructure components such as:

- repositories;
- messaging;
- transaction management;
- external services.

Infrastructure concerns should remain outside the domain model.

---

# Common Mistakes

Avoid:

- implementing business rules;
- modifying Aggregate fields directly;
- exposing persistence details to the domain model;
- creating infrastructure dependencies inside Aggregates;
- bypassing Aggregate business methods.

---

# Related Example Libraries

- AggregateExamples
- SupportingTypeExamples
- PersistenceModelExamples
- ArchitectureResponsibilities

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial Application Service examples extracted from validated Sprint-002 implementations. |