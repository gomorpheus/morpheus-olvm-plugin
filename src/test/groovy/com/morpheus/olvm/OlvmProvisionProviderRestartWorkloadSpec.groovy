package com.morpheus.olvm

import com.morpheusdata.model.Workload
import com.morpheusdata.response.ServiceResponse
import spock.lang.Specification

/**
 * MORPH-16077: restartWorkload previously always returned ServiceResponse.success() without ever
 * issuing stop/start calls against OLVM, so the "Restart" instance action reported success but never
 * actually power-cycled the VM. It must delegate to stopWorkload()/startWorkload() (mirroring the
 * pattern used by the other provision providers) so a real restart is attempted, and must propagate
 * failure if the stop step doesn't succeed rather than silently continuing to start.
 */
class OlvmProvisionProviderRestartWorkloadSpec extends Specification {

	OlvmProvisionProvider provider = Spy(OlvmProvisionProvider, constructorArgs: [null, null])

	def "restartWorkload stops then starts the workload when the stop succeeds"() {
		given:
		Workload workload = new Workload()
		1 * provider.stopWorkload(workload) >> ServiceResponse.success()
		1 * provider.startWorkload(workload) >> ServiceResponse.success()

		when:
		ServiceResponse result = provider.restartWorkload(workload)

		then:
		result.success == true
	}

	def "restartWorkload does not attempt to start when the stop fails"() {
		given:
		Workload workload = new Workload()
		1 * provider.stopWorkload(workload) >> ServiceResponse.error('Failed to stop vm')
		0 * provider.startWorkload(_)

		when:
		ServiceResponse result = provider.restartWorkload(workload)

		then:
		result.success == false
		result.errors?.error == 'Failed to stop vm'
	}
}
