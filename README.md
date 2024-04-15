## Morpheus OLVM Plugin

This is the official Morpheus plugin for interacting with Oracle's Linux Virtualization Manager.  The plugin provides the ability to
provision VMs, Docker Clusters, snapshots, etc within an OLVM environment.

### Requirements
- Java 17
- Gradle 8.3

### Building

This is a Morpheus plugin that leverages the `morpheus-plugin-core` which can be referenced by visiting [https://developer.morpheusdata.com](https://developer.morpheusdata.com). It is a groovy plugin designed to be uploaded into a Morpheus environment via the `Administration -> Integrations -> Plugins` section. To build this product from scratch simply run the shadowJar gradle task on java 17:

```bash
./gradlew shadowJar
```

A jar will be produced in the `build/lib` folder that can be uploaded into a Morpheus environment.


### Configuring

Once the plugin is loaded in the environment, OLVM becomes available as a cloud type when creating a new cloud in `Infrastructure -> Clouds`.

The following information is required when adding an OLVM cloud:

1. API URL: The endpoint to the OLVM api that you wish to integrate with.
2. Username: An authorized OLVM user with api access.
3. Password: Password for above username
4. Datacenter: (optional) If you wish to scope your morpheus cloud to a single data center.  Defaults to `All`
