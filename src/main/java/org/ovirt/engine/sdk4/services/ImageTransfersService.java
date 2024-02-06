/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ImageTransferBuilder;
import org.ovirt.engine.sdk4.types.ImageTransfer;

/**
 * This service manages image transfers, for performing Image I/O API in {product-name}.
 * Please refer to <<services/image_transfer, image transfer>> for further
 * documentation.
 */
public interface ImageTransfersService extends Service {
    /**
     * Add a new image transfer. An image, disk or disk snapshot needs to be specified
     * in order to make a new transfer.
     * 
     * IMPORTANT: The `image` attribute is deprecated since version 4.2 of the engine.
     * Use the `disk` or `snapshot` attributes instead.
     * 
     * *Creating a new image transfer for downloading or uploading a `disk`:*
     * 
     * To create an image transfer to download or upload a disk with id `123`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <disk id="123"/>
     *   <direction>upload|download</direction>
     * </image_transfer>
     * ----
     * 
     * 
     * *Creating a new image transfer for downloading or uploading a `disk_snapshot`:*
     * 
     * To create an image transfer to download or upload a `disk_snapshot` with id `456`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <snapshot id="456"/>
     *   <direction>download|upload</direction>
     * </image_transfer>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest imageTransfer(ImageTransfer imageTransfer);
        /**
         * The image transfer to add.
         */
        AddRequest imageTransfer(ImageTransferBuilder imageTransfer);
    }
    
    /**
     * Add a new image transfer. An image, disk or disk snapshot needs to be specified
     * in order to make a new transfer.
     * 
     * IMPORTANT: The `image` attribute is deprecated since version 4.2 of the engine.
     * Use the `disk` or `snapshot` attributes instead.
     * 
     * *Creating a new image transfer for downloading or uploading a `disk`:*
     * 
     * To create an image transfer to download or upload a disk with id `123`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <disk id="123"/>
     *   <direction>upload|download</direction>
     * </image_transfer>
     * ----
     * 
     * 
     * *Creating a new image transfer for downloading or uploading a `disk_snapshot`:*
     * 
     * To create an image transfer to download or upload a `disk_snapshot` with id `456`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <snapshot id="456"/>
     *   <direction>download|upload</direction>
     * </image_transfer>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The image transfer to add.
         */
        ImageTransfer imageTransfer();
    }
    
    /**
     * Add a new image transfer. An image, disk or disk snapshot needs to be specified
     * in order to make a new transfer.
     * 
     * IMPORTANT: The `image` attribute is deprecated since version 4.2 of the engine.
     * Use the `disk` or `snapshot` attributes instead.
     * 
     * *Creating a new image transfer for downloading or uploading a `disk`:*
     * 
     * To create an image transfer to download or upload a disk with id `123`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <disk id="123"/>
     *   <direction>upload|download</direction>
     * </image_transfer>
     * ----
     * 
     * 
     * *Creating a new image transfer for downloading or uploading a `disk_snapshot`:*
     * 
     * To create an image transfer to download or upload a `disk_snapshot` with id `456`,
     * send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/imagetransfers
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <image_transfer>
     *   <snapshot id="456"/>
     *   <direction>download|upload</direction>
     * </image_transfer>
     * ----
     */
    AddRequest add();
    
    public interface AddForDiskRequest extends Request<AddForDiskRequest, AddForDiskResponse> {
        AddForDiskRequest imageTransfer(ImageTransfer imageTransfer);
        /**
         * The image transfer to add.
         */
        AddForDiskRequest imageTransfer(ImageTransferBuilder imageTransfer);
    }
    
    public interface AddForDiskResponse extends Response {
        /**
         * The image transfer to add.
         */
        ImageTransfer imageTransfer();
    }
    
    AddForDiskRequest addForDisk();
    
    public interface AddForImageRequest extends Request<AddForImageRequest, AddForImageResponse> {
        AddForImageRequest imageTransfer(ImageTransfer imageTransfer);
        /**
         * The image transfer to add.
         */
        AddForImageRequest imageTransfer(ImageTransferBuilder imageTransfer);
    }
    
    public interface AddForImageResponse extends Response {
        /**
         * The image transfer to add.
         */
        ImageTransfer imageTransfer();
    }
    
    AddForImageRequest addForImage();
    
    public interface AddForSnapshotRequest extends Request<AddForSnapshotRequest, AddForSnapshotResponse> {
        AddForSnapshotRequest imageTransfer(ImageTransfer imageTransfer);
        /**
         * The image transfer to add.
         */
        AddForSnapshotRequest imageTransfer(ImageTransferBuilder imageTransfer);
    }
    
    public interface AddForSnapshotResponse extends Response {
        /**
         * The image transfer to add.
         */
        ImageTransfer imageTransfer();
    }
    
    AddForSnapshotRequest addForSnapshot();
    
    /**
     * Retrieves the list of image transfers that are currently
     * being performed.
     * 
     * The order of the returned list of image transfers is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Retrieves the list of image transfers that are currently
     * being performed.
     * 
     * The order of the returned list of image transfers is not guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A list of image transfers that are currently being performed.
         */
        List<ImageTransfer> imageTransfer();
    }
    
    /**
     * Retrieves the list of image transfers that are currently
     * being performed.
     * 
     * The order of the returned list of image transfers is not guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages an
     * specific image transfer.
     */
    ImageTransferService imageTransferService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

