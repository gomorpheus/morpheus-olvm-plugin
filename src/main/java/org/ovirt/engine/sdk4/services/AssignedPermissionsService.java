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
import org.ovirt.engine.sdk4.builders.PermissionBuilder;
import org.ovirt.engine.sdk4.types.Permission;

/**
 * Represents a permission sub-collection, scoped by user, group or some entity type.
 */
public interface AssignedPermissionsService extends Service {
    /**
     * Assign a new permission to a user or group for specific entity.
     * 
     * For example, to assign the `UserVmManager` role to the virtual machine with id `123` to the user with id `456`
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserVmManager</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * To assign the `SuperUser` role to the system to the user with id `456` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>SuperUser</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * If you want to assign permission to the group instead of the user please replace the `user` element with the
     * `group` element with proper `id` of the group. For example to assign the `UserRole` role to the cluster with
     * id `123` to the group with id `789` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserRole</name>
     *   </role>
     *   <group id="789"/>
     * </permission>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Assign a new permission to a user or group for specific entity.
     * 
     * For example, to assign the `UserVmManager` role to the virtual machine with id `123` to the user with id `456`
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserVmManager</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * To assign the `SuperUser` role to the system to the user with id `456` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>SuperUser</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * If you want to assign permission to the group instead of the user please replace the `user` element with the
     * `group` element with proper `id` of the group. For example to assign the `UserRole` role to the cluster with
     * id `123` to the group with id `789` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserRole</name>
     *   </role>
     *   <group id="789"/>
     * </permission>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Assign a new permission to a user or group for specific entity.
     * 
     * For example, to assign the `UserVmManager` role to the virtual machine with id `123` to the user with id `456`
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserVmManager</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * To assign the `SuperUser` role to the system to the user with id `456` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>SuperUser</name>
     *   </role>
     *   <user id="456"/>
     * </permission>
     * ----
     * 
     * If you want to assign permission to the group instead of the user please replace the `user` element with the
     * `group` element with proper `id` of the group. For example to assign the `UserRole` role to the cluster with
     * id `123` to the group with id `789` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permission>
     *   <role>
     *     <name>UserRole</name>
     *   </role>
     *   <group id="789"/>
     * </permission>
     * ----
     */
    AddRequest add();
    
    /**
     * Add a new permission on the cluster to the group in the system.
     */
    public interface AddClusterPermissionRequest extends Request<AddClusterPermissionRequest, AddClusterPermissionResponse> {
        AddClusterPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddClusterPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the cluster to the group in the system.
     */
    public interface AddClusterPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the cluster to the group in the system.
     */
    AddClusterPermissionRequest addClusterPermission();
    
    /**
     * Add a new permission on the data center to the group in the system.
     */
    public interface AddDataCenterPermissionRequest extends Request<AddDataCenterPermissionRequest, AddDataCenterPermissionResponse> {
        AddDataCenterPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddDataCenterPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the data center to the group in the system.
     */
    public interface AddDataCenterPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the data center to the group in the system.
     */
    AddDataCenterPermissionRequest addDataCenterPermission();
    
    /**
     * Add a new group level permission for a given virtual machine.
     */
    public interface AddGroupLevelRequest extends Request<AddGroupLevelRequest, AddGroupLevelResponse> {
        AddGroupLevelRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddGroupLevelRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new group level permission for a given virtual machine.
     */
    public interface AddGroupLevelResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new group level permission for a given virtual machine.
     */
    AddGroupLevelRequest addGroupLevel();
    
    /**
     * Add a new permission on the host to the group in the system.
     */
    public interface AddHostPermissionRequest extends Request<AddHostPermissionRequest, AddHostPermissionResponse> {
        AddHostPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddHostPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the host to the group in the system.
     */
    public interface AddHostPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the host to the group in the system.
     */
    AddHostPermissionRequest addHostPermission();
    
    /**
     * List all the permissions of the specific entity.
     * 
     * For example to list all the permissions of the cluster with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * [source,xml]
     * ----
     * <permissions>
     *   <permission id="456">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <user id="451"/>
     *   </permission>
     *   <permission id="654">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <group id="127"/>
     *   </permission>
     * </permissions>
     * ----
     * 
     * The order of the returned permissions isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * List all the permissions of the specific entity.
     * 
     * For example to list all the permissions of the cluster with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * [source,xml]
     * ----
     * <permissions>
     *   <permission id="456">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <user id="451"/>
     *   </permission>
     *   <permission id="654">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <group id="127"/>
     *   </permission>
     * </permissions>
     * ----
     * 
     * The order of the returned permissions isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of permissions.
         */
        List<Permission> permissions();
    }
    
    /**
     * List all the permissions of the specific entity.
     * 
     * For example to list all the permissions of the cluster with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/clusters/123/permissions
     * ....
     * 
     * [source,xml]
     * ----
     * <permissions>
     *   <permission id="456">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <user id="451"/>
     *   </permission>
     *   <permission id="654">
     *     <cluster id="123"/>
     *     <role id="789"/>
     *     <group id="127"/>
     *   </permission>
     * </permissions>
     * ----
     * 
     * The order of the returned permissions isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Add a new permission on the storage domain to the group in the system.
     */
    public interface AddStorageDomainPermissionRequest extends Request<AddStorageDomainPermissionRequest, AddStorageDomainPermissionResponse> {
        AddStorageDomainPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddStorageDomainPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the storage domain to the group in the system.
     */
    public interface AddStorageDomainPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the storage domain to the group in the system.
     */
    AddStorageDomainPermissionRequest addStorageDomainPermission();
    
    /**
     * Add a new permission on the template to the group in the system.
     */
    public interface AddTemplatePermissionRequest extends Request<AddTemplatePermissionRequest, AddTemplatePermissionResponse> {
        AddTemplatePermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddTemplatePermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the template to the group in the system.
     */
    public interface AddTemplatePermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the template to the group in the system.
     */
    AddTemplatePermissionRequest addTemplatePermission();
    
    /**
     * Add a new user level permission for a given virtual machine.
     */
    public interface AddUserLevelRequest extends Request<AddUserLevelRequest, AddUserLevelResponse> {
        AddUserLevelRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddUserLevelRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new user level permission for a given virtual machine.
     */
    public interface AddUserLevelResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new user level permission for a given virtual machine.
     */
    AddUserLevelRequest addUserLevel();
    
    /**
     * Add a new permission on the vm to the group in the system.
     */
    public interface AddVmPermissionRequest extends Request<AddVmPermissionRequest, AddVmPermissionResponse> {
        AddVmPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddVmPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the vm to the group in the system.
     */
    public interface AddVmPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the vm to the group in the system.
     */
    AddVmPermissionRequest addVmPermission();
    
    /**
     * Add a new permission on the vm pool to the group in the system.
     */
    public interface AddVmPoolPermissionRequest extends Request<AddVmPoolPermissionRequest, AddVmPoolPermissionResponse> {
        AddVmPoolPermissionRequest permission(Permission permission);
        /**
         * The permission.
         */
        AddVmPoolPermissionRequest permission(PermissionBuilder permission);
    }
    
    /**
     * Add a new permission on the vm pool to the group in the system.
     */
    public interface AddVmPoolPermissionResponse extends Response {
        /**
         * The permission.
         */
        Permission permission();
    }
    
    /**
     * Add a new permission on the vm pool to the group in the system.
     */
    AddVmPoolPermissionRequest addVmPoolPermission();
    
    /**
     * Sub-resource locator method, returns individual permission resource on which the remainder of the URI is
     * dispatched.
     */
    PermissionService permissionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

