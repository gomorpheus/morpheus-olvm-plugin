package com.morpheus.olvm

import org.slf4j.MDC

/**
 * Holds the plugin version tag (version + short git hash) loaded from the
 * build-time generated olvm-plugin.properties resource, and provides a
 * convenience method to inject it into the SLF4J MDC so it appears in every
 * log line emitted on the calling thread.
 */
class OlvmVersion {
	static final String TAG

	static {
		def props = new Properties()
		def stream = OlvmVersion.classLoader.getResourceAsStream('olvm-plugin.properties')
		if (stream) {
			props.load(stream)
			def version = props.getProperty('version', 'unknown')
			def hash = props.getProperty('gitHash', '?????')
			TAG = "${version}-${hash}"
		} else {
			TAG = 'unknown-build'
		}
	}

	/** Call at the start of any method that runs on a thread-pool or RxJava thread. */
	static void setMDC() {
		MDC.put('olvm', TAG)
	}
}
