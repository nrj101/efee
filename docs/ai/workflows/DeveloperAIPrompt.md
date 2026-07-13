Your role, persona and expected behavior are described in the attached files "DeveloperPersona.md"  "Developer_Runtime_Prompt.md"  and "Engineering-Constitution.md"  . 

Your tasks are as below: 


Task 1: Review the assigned Story as defined in attached Story.md file  and ImplementationGuide.md file  , and confirm the files that are expected to be created (typically, the filenames are defined under Write Scope and/or Output Locations). If Output Locations cannot be determined unambiguously, STOP and request clarification. Make sure that exactly those files are created or edited during the course of implementation, no more and no less. If implementation requires creating an additional source artifact that is not explicitly listed in the Story Write Scope,STOP and request clarification before continuing. All expected output files must be created/edited in a single output. Must validate that for each line of code must be covered under the corresponding "...Test.java" files. Do not begin implementation yet. 


Task 2: Summarize the Story as described in attached Story.md file: Provide a concise summary including: Story ID, Story Title, Aggregate Root, Business Objective. Thoroughly review the "FeeStructure" Aggregate Design defined in the attached file  , "FeeStructure" Aggregate Technical Specification defined in the attached file  , and "FeeStructure" Persistence model defined in the attached file  , and identify:

• Aggregate Root

• Supporting Entities

• Approved Business Operations

• Approved Aggregate State

• Approved Business Invariants

• Approved Write Scope


If any implementation detail required to realize the approved behaviour (e.g. class members, method signatures, data types, return types, visibility, or object relationships) is not explicitly defined by the attached documentation, STOP and request clarification rather than inventing it. If implementation requires the public API of a collaborating type (for example, a supporting entity, value object, or domain type) and that API is not explicitly defined in the attached engineering documents, STOP and request clarification. Do not invent constructors, methods, fields, or behavior for collaborating types.


Do not assume, invent or follow a standard (i.e. popular in industry, typical approach) software engineering convention when some required details are not explicitly specified in the attached documentation files. Do not makeup for any required business behaviour, software behavior, aggregate state, attribute, operation,type, lifecycle, invariant or architectural component that is not explicitly defined by the attached documents. STOP AND ASK for further clarification if implementation requires details that are missing. Do not begin implementation yet. 


Task 3: Implement the Story as per the description provided in the attached Story.md and ImplementationGuide.md files. You must ensure that the implementation follows the attached engineering documentation "Engineering-Constitution.md". Implement only the functionality approved by the Story. Do not assume, invent or follow a standard (i.e. popular in industry, typical approach) software engineering convention when some required details are not explicitly specified in the attached documentation files. Do not makeup for any required business behaviour, software behavior, aggregate state, attribute, operation,type, lifecycle, invariant or architectural component that is not explicitly defined by the attached documents STOP AND ASK for further clarification if implementation requires details that are missing, rather than assuming the default standard implementation. Make sure that you output exactly those files that were identified in Task1 above, no more and no less. If implementation requires creating an additional source artifact that is not explicitly listed in the Story Write Scope, STOP and request clarification before continuing. All expected output files must be created/edited in a single output. 


Note: For the Task 3, you may need to refer to the "FeeStructure" Aggregate Design, "FeeStructure" Aggregate Technical Specification and "FeeStructure" Persistence model related documents attached for Task 2 above.


Criteria for completion: 

1. generate all requested artifacts; 

2. preserve the Story Package directory structure; 

3. remain within the approved Write Scope, and create/modify only expected files 

4. STRICTLY NO additional implementation artifacts unless explicitly approved by the Story 

