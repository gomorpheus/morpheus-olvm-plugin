---
title: Project Overview
type: context
status: active
created: 2026-07-10
tags: [auto-generated, project-scan]
---

## What is Morpheus OLVM Cloud Plugin

This plugin provides a full integration between Oracle Linux Virtualization Manager (OLVM) and [Morpheus](https://morpheusdata.com). It enables cloud inventory sync, VM provisioning, VM power and resize actions, and snapshot-based backups from within the Morpheus platform.

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Groovy |
| Build | Gradle (`build.gradle`) |
| Package manager | Gradle |
| Testing | Spock |

## Package Organization

- `build/` — build output (assets, classes, generated, generated-resources, +3 more)
- `gradle/` — contains: wrapper
- `src/` — application source code (assets, main)

## Project Structure

## Documentation

- `README.md`
- `LICENSE`

## Architecture Summary

The plugin registers four Morpheus providers from `OlvmCloudPlugin` (code `cloud.olvm`): a cloud
provider (inventory sync), a provision provider (VM lifecycle), an option-source provider (UI
dropdowns), and a snapshot-based backup provider. See the architecture-overview knowledge entry
for the full breakdown.

## Current Gaps

- **No CI/CD** — no CI provider detected
- **No linters** — no linter or formatter configuration detected

<!-- Add project-specific context here:
- Architecture overview and key design patterns
- Deployment topology (cloud provider, regions, etc.)
- Important environment variables
- Third-party service dependencies
-->
