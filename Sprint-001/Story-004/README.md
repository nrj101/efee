src/main/README.md
```

```markdown
# Story-004: Discount Management

## Purpose

This story implements the Discount Aggregate, which manages authorized financial reductions granted to students while preserving financial auditability and historical records.

## Aggregate Responsibility

The Discount Aggregate owns the lifecycle of approved financial concessions granted to students. It preserves discount identity, eligibility, reduction rules, applicable fee components, and discount lifecycle.

## Implemented Files

- `Discount.java` - Java source file for the Discount Aggregate
- `DiscountTest.java` - Unit test file for the Discount Aggregate
- `README.md` - Story README file

## Supported Operations

- `Discount(...)` - Constructor to create a new discount
- `update(...)` - Update the discount's applicable fee components and discount value
- `retire()` - Retire the discount (mark it as inactive)

## Implementation Notes

- The Discount Aggregate preserves its state and lifecycle integrity.
- The implementation follows the approved technical specification and persistence model.
- The implementation ensures that all business invariants are preserved.
- Lifecycle transitions are exclusively managed by the `retire()` method.
- The `update()` method does not alter the lifecycle state of the discount.
- The `validateFeeComponents()` method is used to validate both the constructor and the update method.
- The `getApplicableFeeComponents()` method returns an immutable list to prevent external modification of the caller's collection.
- External modification of the caller's collection does not affect the Aggregate.