/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A list of possible phases for an <<types/image_transfer, image transfer>> entity. Each of these values
 * defines a specific point in a transfer flow.
 * 
 * Please refer to <<services/image_transfer, image transfer>> for more
 * information.
 */
public enum ImageTransferPhase {
    /**
     * This phase will be set as a result of the user cancelling the transfer. The cancellation can only be performed
     * in the Administration Portal.
     */
    CANCELLED("cancelled"),
    /**
     * This phase will be set as a result of the system cancelling the transfer.
     */
    CANCELLED_SYSTEM("cancelled_system"),
    /**
     * This phase will be set as a result of the user cancelling the transfer.
     */
    CANCELLED_USER("cancelled_user"),
    /**
     * This phase indicates that the user cancelled the transfer, and necessary cleanup is being done.
     */
    FINALIZING_CLEANUP("finalizing_cleanup"),
    /**
     * This phase can only be set in the Administration Portal, and indicates that there was an error during the transfer, and it
     * is being finalized with a failure.
     */
    FINALIZING_FAILURE("finalizing_failure"),
    /**
     * This phase will be set when the user calls <<services/image_transfer/methods/finalize, finalize>>. Calling
     * finalize is essential to finish the transfer session, and finish using the targeted image. After finalizing,
     * the phase will be changed to `finished_success` or `finished_failure`.
     * 
     * Refer to <<services/image_transfer, image transfer>> for more information.
     */
    FINALIZING_SUCCESS("finalizing_success"),
    /**
     * This phase indicates that the user cancelled the transfer, and necessary cleanup is done.
     */
    FINISHED_CLEANUP("finished_cleanup"),
    /**
     * Indicates that the targeted image failed the verification, and cannot be used. After reaching this phase,
     * the image transfer entity will be deleted, and the targeted image will be set to illegal. System cancelling the
     * transfer will also result in this.
     */
    FINISHED_FAILURE("finished_failure"),
    /**
     * Indicates that the transfer session was successfully closed, and the targeted image was verified and ready to be
     * used. After reaching this phase, the image transfer entity will be deleted.
     */
    FINISHED_SUCCESS("finished_success"),
    /**
     * The initial phase of an image transfer. It is set while the transfer session is establishing.
     * Once the session is established, the phase will be changed to `transferring`
     */
    INITIALIZING("initializing"),
    /**
     * This phase means the session timed out, or some other error occurred
     * with this transfer; for example ovirt-imageio-daemon is not running in the selected host.
     * To resume the session, the client should call <<services/image_transfer/methods/resume, resume>>. After
     * resuming, the phase will change to `resuming`.
     */
    PAUSED_SYSTEM("paused_system"),
    /**
     * This phase is a result of a pause call by the user, using
     * <<services/image_transfer/methods/pause, pause>>.
     */
    PAUSED_USER("paused_user"),
    /**
     * The phase where the transfer has been resumed by the client calling
     * <<services/image_transfer/methods/resume, resume>>. Resuming starts a new session, and after calling it,
     * the phase will be changed to `transferring`, or `paused_system` in case of a failure.
     */
    RESUMING("resuming"),
    /**
     * The phase where the transfer session is open, and the client can input or output the desired image using the preferred
     * tools.
     */
    TRANSFERRING("transferring"),
    /**
     * An unknown phase. This will only be set in cases of unpredictable errors.
     */
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ImageTransferPhase.class);
    
    private String image;
    
    ImageTransferPhase(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ImageTransferPhase fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ImageTransferPhase' enumerated type. " +
            "Valid values are 'cancelled', 'cancelled_system', 'cancelled_user', 'finalizing_cleanup', 'finalizing_failure', 'finalizing_success', 'finished_cleanup', 'finished_failure', 'finished_success', 'initializing', 'paused_system', 'paused_user', 'resuming', 'transferring' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

