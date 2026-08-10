---
title: Project Overview
type: context
status: active
created: 2026-07-14
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

Detailed architecture documentation is available in the architecture-overview knowledge entry.

This is a **Morpheus cloud plugin** for Oracle Linux Virtualization Manager (OLVM). It integrates with the [morpheus-plugin-api](https://developer.morpheusdata.com) and is loaded into a Morpheus appliance at `Administration → Integrations → Plugins`.

## Current Gaps

- **No CI/CD** — no CI provider detected
- **No linters** — no linter or formatter configuration detected

<!-- Add project-specific context here:
- Architecture overview and key design patterns
- Deployment topology (cloud provider, regions, etc.)
- Important environment variables
- Third-party service dependencies
-->
