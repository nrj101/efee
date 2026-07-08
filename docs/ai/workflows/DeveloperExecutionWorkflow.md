Context Files (Attachments):

@README.md @Engineering-Constitution.md @DeveloperPersona.md @Developer_Runtime_Prompt.md 
@CanonicalExamples.md @SoftwareArchitecture.md @AggregateDesign.md @ProductSpecification.md 
@BusinessRules.md @SoftwareDomainModel.md @BusinessWorkflow.md @BusinessObjectGraph.md 
@DomainGlossary.md @Sprint-001.md @Story.md @ImplementationGuide.md

Prompt:

# Repeatable Developer Execution Prompt

## Context Files (Attachments)

Attach the approved engineering documents required for the current Story.

Typical attachments include:

README.md
Engineering-Constitution.md
DeveloperPersona.md
Developer_Runtime_Prompt.md
CanonicalExamples.md
SoftwareArchitecture.md
AggregateDesign.md
BusinessRules.md
SoftwareDomainModel.md
BusinessWorkflow.md
BusinessObjectGraph.md
DomainGlossary.md
Sprint-001.md
Story.md
ImplementationGuide.md

---

## Developer Instructions

Before generating any implementation, complete the following steps in order.

---

### Step 1 — Verify Context

List the names of every attached context document.

Do not describe them.

If any document referenced by the Story Package is missing, STOP and request clarification.

---

### Step 2 — Resolve Output Locations

Read the Story Package and identify the approved Output Location for every writable artifact.

Output the resolved locations using the following format.

```text
Student.java      -> /Sprint-001/Story-001/source/Student.java

StudentTest.java  -> /Sprint-001/Story-001/tests/StudentTest.java

README.md         -> /Sprint-001/Story-001/README.md
```

Output Locations SHALL be taken only from the Story Package.

Do not infer package names.

Do not infer Maven layouts.

Do not infer Gradle layouts.

Do not infer additional folders.

If Output Locations cannot be determined unambiguously, STOP and request clarification.

---

### Step 3 — Summarize the Story

Provide a concise summary including:

* Story ID
* Story Title
* Aggregate Root
* Business Objective

Do not begin implementation yet.

---

### Step 4 — Validate Implementation Contract

Before implementation begins, verify:

* Story Package is internally consistent.
* Aggregate Root is identified.
* Output Locations are defined.
* Write Scope is defined.
* Acceptance Criteria are present.

If any required information is missing or contradictory, STOP and request clarification.

---

### Step 5 — Implement the Story

Implement the Story according to the attached engineering documentation.

The attached documents collectively define the complete engineering context.

Your responsibilities are to:

* follow the Engineering Constitution;
* follow the Developer Persona;
* follow the Developer Runtime Prompt;
* preserve the approved Product Specification;
* preserve the approved Software Architecture;
* preserve the approved Aggregate Design;
* preserve all Business Rules;
* follow the engineering conventions demonstrated by the Canonical Examples.

The Story Package is the authoritative implementation contract.

Implement only the functionality approved by the Story.

Modify or create ONLY the artifacts explicitly listed in the Story Write Scope.

---

### Implementation Rules

Do not:

* invent business rules;
* redesign the architecture;
* introduce speculative functionality;
* modify unrelated implementation;
* infer additional source folders;
* infer Java package hierarchies;
* infer Maven or Gradle project layouts;
* modify artifacts outside the approved Write Scope.

If implementation requires:

* modifying additional artifacts;
* introducing new architectural components;
* changing Aggregate ownership;
* interpreting ambiguous requirements;
* introducing undocumented assumptions;

STOP implementation and request clarification.

---

### Completion

When implementation is complete:

* generate all requested artifacts;
* place every artifact only in its approved Output Location;
* preserve the Story Package directory structure;
* remain within the approved Write Scope.

Do not generate additional implementation artifacts unless explicitly approved by the Story Package.
