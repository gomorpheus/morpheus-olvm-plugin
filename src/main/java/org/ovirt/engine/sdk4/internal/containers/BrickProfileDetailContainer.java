/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.BrickProfileDetail;
import org.ovirt.engine.sdk4.types.GlusterBrick;

public class BrickProfileDetailContainer extends EntityProfileDetailContainer implements BrickProfileDetail {
    private GlusterBrick brick;
    
    public GlusterBrick brick() {
        return brick;
    }
    
    public void brick(GlusterBrick newBrick) {
        brick = newBrick;
    }
    
    public boolean brickPresent() {
        return brick != null;
    }
    
}
