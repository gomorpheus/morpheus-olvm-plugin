# Glossary

Terms, abbreviations, and product names used across this project and related HPE systems.

## PCCP — Private Cloud Control Plane

Deprecated HPE product name. Superseded by **PCO**. May still appear in older Jira
tickets (e.g. MORPH-5530), Teams discussions, and internal documentation. When you
encounter PCCP, treat it as synonymous with PCO.

## PCO — Private Cloud Orchestrator

Current HPE product name for the overarching private cloud platform. This plugin
(morpheus-olvm-plugin) is deployed as a component of PCO, providing OLVM/oVirt cloud
integration to the Morpheus-based orchestration layer.

## OLVM — Oracle Linux Virtualization Manager

The virtualization management platform this plugin integrates with. Based on oVirt.
OLVM and oVirt are functionally equivalent for plugin purposes — the OLVM REST API
is the oVirt REST API.

## Morpheus

The orchestration platform that hosts this plugin. Provides the plugin framework
(providers, lifecycle methods, context APIs) that this plugin implements.
