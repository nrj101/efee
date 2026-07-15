# Fee Structure Aggregate Persistence Model

```yaml
---
document_id: TD-FEESTRUCTURE-001
title: Fee Structure Aggregate Persistence Model
version: 2.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-13

related_documents:
  - ../../architecture/aggregates/FeeStructure.md
  - ../../architecture/technical-specification/aggregates/FeeStructure.md
  - ../../architecture/SoftwareArchitecture.md
---
```

---

# Purpose

This document defines the approved persistence representation of the Fee Structure Aggregate.

It realizes the implementation contract defined by the Fee Structure Aggregate Technical Specification by specifying the concrete persistent field names, implementation types and persistence representation.

This document SHALL NOT introduce new business behaviour, Aggregate responsibilities or public interfaces.

---

# Aggregate

**Fee Structure**

---

# Aggregate Responsibility

Persist the business truth owned by the Fee Structure Aggregate while preserving:

- Fee Structure identity;
- Fee Structure definition;
- Fee Component collection;
- Aggregate lifecycle.

Business truth owned by collaborating Aggregates remains outside the scope of this document.

---

# Persistent Aggregate State

The following Aggregate state is approved for persistence.

| Persistent Field | Implementation Type | Required | Mutable |
|------------------|---------------------|----------|----------|
| feeStructureIdentifier | String | Yes | No |
| feeStructureName | String | Yes | Yes |
| feeComponents | List<FeeComponent> | Yes | Yes |
| active | Boolean | Yes | Yes |

No additional Aggregate state shall be persisted.

---

# Persistent Supporting Entity State

## Fee Component

The following Supporting Entity state is approved.

| Persistent Field | Implementation Type | Required | Mutable |
|------------------|---------------------|----------|----------|
| feeComponentIdentifier | String | Yes | No |
| feeComponentName | String | Yes | Yes |
| feeAmount | BigDecimal | Yes | Yes |

No additional Supporting Entity state shall be persisted.

---

# Aggregate Construction Mapping

The approved Aggregate constructor SHALL map to the following persistent state.

| Constructor Parameter | Persistent Field |
|-----------------------|------------------|
| feeStructureIdentifier | feeStructureIdentifier |
| feeStructureName | feeStructureName |
| feeComponents | feeComponents |

Lifecycle state SHALL be initialized by the Aggregate implementation.

---

# Public Interface Mapping

The following approved Aggregate interface maps to the persistent representation.

| Approved Interface | Persistent State |
|--------------------|------------------|
| getFeeStructureIdentifier() | feeStructureIdentifier |
| getFeeStructureName() | feeStructureName |
| getFeeComponents() | feeComponents |
| isActive() | active |

---

# Collection Representation

The following collection implementations are approved.

| Domain Concept | Implementation Type |
|----------------|---------------------|
| Fee Components | List<FeeComponent> |

Alternative collection implementations require explicit architectural approval.

---

# Value Type Representation

The following implementation types are approved.

| Domain Concept | Implementation Type |
|----------------|---------------------|
| Fee Structure Identifier | String |
| Fee Structure Name | String |
| Fee Component Identifier | String |
| Fee Component Name | String |
| Monetary Value | BigDecimal |
| Fee Component Collection | List<FeeComponent> |
| Fee Structure Lifecycle | Boolean |

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Fee Structure Aggregate owns:

- Fee Component

The Fee Structure Aggregate SHALL NOT persist references to:

- Academic Year
- Fee Obligation

Ownership remains defined by the Software Architecture.

---

# Persistence Constraints

Implementation SHALL NOT:

- introduce additional persistent fields;
- rename approved persistent fields;
- change approved implementation types;
- remove approved fields;
- change field mutability.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Technology Independence

This document intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- indexes;
- persistence framework configuration.

These belong to subsequent Technical Design documents.

---

# Traceability

| Persistent Element | Source |
|--------------------|--------|
| feeStructureIdentifier | Fee Structure ATS |
| feeStructureName | Fee Structure ATS |
| feeComponents | Fee Structure ATS |
| active | Fee Structure ATS |
| feeComponentIdentifier | Fee Structure ATS |
| feeComponentName | Fee Structure ATS |
| feeAmount | Fee Structure ATS |

---

# Notes

The Aggregate Technical Specification defines the approved software contract.

This document defines the concrete persistence representation of that contract.

Implementation SHALL faithfully realize both documents without introducing undocumented fields, types or alternative representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial persistence model. |
| 2.0.0 | 2026-07-13 | Expanded to define concrete persistent field names, implementation types, constructor mapping, interface mapping and supporting entity persistence. |

---

# Approval

**Status:** Approved