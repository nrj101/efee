# Fee Structure Implementation

This project implements the Fee Structure Aggregate as described in the business requirements.

## Overview

The implementation includes:
- `FeeStructure.java`: The Fee Structure Aggregate Root
- `FeeComponent.java`: The Fee Component Supporting Entity
- `FeeStructureTest.java`: Unit tests for the Fee Structure
- `FeeComponentTest.java`: Unit tests for the Fee Component

## Key Features

### Fee Structure Aggregate
- **Owns the institutional charging policy** for an Academic Year
- **Maintains a collection of Fee Components**
- **Has lifecycle states**: Active, Retired
- **Ensures business invariants**:
  - A Fee Structure must have at least one Fee Component
  - Fee Components belong to exactly one Fee Structure
  - Historical Fee Structures remain immutable once used

### Fee Component Supporting Entity
- **Part of a Fee Structure**
- **Has name, amount, and identifier**
- **Cannot be modified after creation** (immutable)

## Implementation Details

### Fee Structure
- **Fee Structure Identifier**: Immutable, uniquely identifies the Fee Structure
- **Fee Structure Name**: Mutable, can be updated
- **Fee Components**: Immutable collection, can be updated through the `update()` method
- **Active State**: Mutable, can be retired through the `retire()` method

### Fee Component
- **Fee Component Identifier**: Immutable, uniquely identifies the Fee Component
- **Fee Component Name**: Immutable
- **Fee Amount**: Immutable, must be a positive value

## Business Requirements

### Fee Structure Management
- **Create Fee Structure**: Must have at least one Fee Component
- **Update Fee Structure**: Can update name and components, but must maintain at least one Fee Component
- **Retire Fee Structure**: Prevents further modifications, maintains historical records

### Fee Component Management
- **Create Fee Component**: Must have a unique identifier, name, and positive amount
- **Prevent Duplicate Fee Components**: Ensures no two Fee Components have the same identifier within the same Fee Structure

## Testing

The implementation includes comprehensive unit tests to validate the expected behavior and ensure correctness, including:
- Valid creation and retrieval of Fee Structures and Fee Components
- Validation of business invariants (e.g., duplicate components, retired Fee Structures)
- Error handling for invalid operations (e.g., creating a Fee Structure with no components)

## Usage

The implementation provides the following operations:
- `createFeeStructure()`: Constructor to create a Fee Structure
- `update()`: Update Fee Structure name and components
- `addFeeComponent()`: Add a Fee Component to the Fee Structure
- `retire()`: Retire a Fee Structure

The implementation ensures that all modifications go through the Fee Structure Aggregate, preventing direct mutation of the internal state.