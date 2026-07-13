# Fee Structure Aggregate

This package contains the implementation for the Fee Structure Aggregate, which manages the institutional charging policy for an Academic Year.

## Key Components
- `FeeComponent.java`: Represents individual components of the Fee Structure (e.g., tuition, fees, etc.).
- `FeeStructure.java`: Represents the Fee Structure with its components and status.
- `FeeComponentTest.java`: Unit tests for the `FeeComponent` class.
- `FeeStructureTest.java`: Unit tests for the `FeeStructure` class.

## Implementation Notes
- The Fee Structure is immutable once created.
- Fee Components can be modified but must remain part of the Fee Structure.
- The Fee Structure can be activated or deactivated to control its applicability.

## Testing
- Unit tests for both `FeeComponent` and `FeeStructure` are included in the tests directory.