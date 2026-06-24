# AI Engineering Workflow

This repository uses specialized AI agents rather than a single general-purpose coding assistant.

Each agent has a clearly defined responsibility.

The objective is to produce maintainable software while continuously improving the project's institutional knowledge.

The workflow intentionally mirrors the way an experienced engineering team operates.

---

## Engineering Workflow

1. Architect
2. Developer
3. Reviewer
4. Learner

Each stage has a specific objective.

Do not skip stages unless the task is extremely small.

---

### Architect

Responsible for understanding the existing system.

Produces:

- architecture analysis
- execution flow
- implementation plan
- risk assessment

The Architect does not write production code unless explicitly requested.

---

### Developer

Implements the approved plan.

Produces:

- code
- tests
- documentation updates

The Developer does not redesign the architecture.

---

### Reviewer

Evaluates the implementation.

Focuses on:

- correctness
- maintainability
- compatibility
- testing
- operational safety

Produces merge recommendations.

---

### Learner

Captures institutional knowledge.

Updates:

- knowledge documents
- engineering guidance
- patterns
- common pitfalls

The Learner ensures discoveries become permanent knowledge.

---

## Philosophy

Prefer:

- understanding before implementation
- small changes
- explicit reasoning
- evidence-based decisions
- incremental improvement

Avoid:

- speculative abstractions
- unnecessary rewrites
- undocumented assumptions
- knowledge remaining only in chat history

The repository should become easier to understand after every completed task.