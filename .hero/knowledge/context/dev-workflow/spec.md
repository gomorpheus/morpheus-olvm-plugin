---
title: Development Workflow & Commands
type: context
status: active
created: 2026-07-14
tags: [imported, commands, dev-workflow]
---

## Build & Deploy

**Prerequisites:** Switch to Java 17 before building (Groovy 3 is incompatible with Java 25+):
```bash
sdk use java 17.0.11-jbr
```

**Build the shadow JAR:**
```bash
./gradlew shadowJar
```
Output: `build/libs/*-all.jar`

**Deploy to local Morpheus plugin core for testing:**
```bash
mv build/libs/*-all.jar ~/code/morpheus-plugin-core/plugins/
```

**Run tests:**
```bash
./gradlew test
```
Tests use Spock framework (Groovy). No test files currently exist.

<!-- Imported from: .github/copilot-instructions.md -->
