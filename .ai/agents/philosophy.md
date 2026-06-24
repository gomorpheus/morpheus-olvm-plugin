# AI Engineering Workflow

## Purpose

This directory defines the AI-assisted engineering workflow used by this project.

Rather than relying on a single general-purpose coding assistant, this project uses specialized agents with clearly defined responsibilities. Each agent contributes a different perspective, mirroring the responsibilities found on a high-performing engineering team.

The goal is not simply to produce working code.

The goal is to produce software that is understandable, maintainable, well-tested, and continuously improves over time.

---

# Guiding Principles

Our engineering process is built on several core principles:

* Understand before implementing.
* Preserve existing architecture whenever practical.
* Favor consistency over cleverness.
* Make the smallest reasonable change.
* Explain decisions, not just conclusions.
* Verify before documenting.
* Capture knowledge so it is not lost.
* Leave the repository easier to understand than you found it.

---

# Engineering Workflow

Most work follows four stages.

```
Investigation
      │
      ▼
 Architect
      │
      ▼
Implementation
      │
      ▼
 Developer
      │
      ▼
Validation
      │
      ▼
 Reviewer
      │
      ▼
Knowledge Capture
      │
      ▼
 Learner
```

Not every task requires every stage, but larger changes should generally follow this sequence.

---

# Agent Responsibilities

## Architect

The Architect develops understanding before implementation.

Responsibilities include:

* understanding the existing architecture
* tracing execution flow
* identifying affected components
* evaluating risks
* proposing implementation plans

The Architect prioritizes investigation over code generation.

---

## Developer

The Developer implements approved plans.

Responsibilities include:

* writing production code
* updating tests
* following repository conventions
* minimizing implementation scope
* documenting implementation decisions

The Developer does not redesign the architecture during implementation.

---

## Reviewer

The Reviewer evaluates completed work.

Responsibilities include:

* correctness
* maintainability
* compatibility
* testing
* operational safety
* code quality

The Reviewer protects the long-term health of the repository.

---

## Learner

The Learner preserves institutional knowledge.

Responsibilities include:

* documenting engineering discoveries
* identifying recurring patterns
* updating knowledge documents
* recording lessons learned
* identifying unanswered questions

The Learner ensures that experience compounds over time.

---

# Choosing the Right Agent

| If you want to...                         | Use...    |
| ----------------------------------------- | --------- |
| Understand how something works            | Architect |
| Design an implementation                  | Architect |
| Implement an approved design              | Developer |
| Add tests                                 | Developer |
| Review a change                           | Reviewer  |
| Assess risks                              | Reviewer  |
| Capture engineering knowledge             | Learner   |
| Update documentation based on recent work | Learner   |

---

# Knowledge Management

The project distinguishes between **behavior** and **knowledge**.

Behavior is defined by the agent documents.

Knowledge is captured in the `knowledge/` directory.

Behavior should remain relatively stable.

Knowledge should grow continuously.

Agents should propose updates to the knowledge base rather than changing their own responsibilities.

---

# Documentation Philosophy

Engineering knowledge should be:

* accurate
* concise
* actionable
* reusable
* evidence-based

When possible, organize knowledge into:

* Verified Knowledge
* Engineering Guidance
* Common Pitfalls
* Open Questions

Clearly distinguish verified facts from assumptions or hypotheses.

---

# Continuous Improvement

Every completed engineering task should improve at least one of the following:

* the product
* the tests
* the documentation
* the engineering knowledge
* the development process

Work is not considered complete until important knowledge has been preserved for future engineers.

---

# Success

Success is measured by more than delivering features.

This workflow is successful when:

* engineers understand the system more quickly
* implementations become more consistent
* code reviews become easier
* recurring mistakes become less common
* architectural decisions become easier to explain
* institutional knowledge grows over time

Every engineering task should make the next engineering task easier.
