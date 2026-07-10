---
title: Development Workflow & Commands
type: context
status: active
created: 2026-07-10
tags: [commands, dev-workflow]
---

## Build

Requires Java 17 active in the shell.

```
./gradlew shadowJar
```

Produces a fat jar under `build/libs/`.

## Deploy to a local Morpheus core

The plugin is loaded by a running Morpheus core (`morpheus-plugin-core`) from its `plugins/`
directory. After building, copy the jar over:

```
mv build/libs/*-all.jar ~/code/morpheus-plugin-core/plugins/
```

## Testing

Tests use the Spock framework (Groovy). Run with the standard Gradle test task:

```
./gradlew test
```

## Hero CLI commands

- `hero status` — workspace state and active specs
- `hero search <query>` — find specs by keyword
- `hero check` — health check
- `hero design <slug>` — start writing a feature spec
