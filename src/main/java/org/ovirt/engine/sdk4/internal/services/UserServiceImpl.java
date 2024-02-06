/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.UserBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlUserReader;
import org.ovirt.engine.sdk4.internal.xml.XmlUserWriter;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.AssignedRolesService;
import org.ovirt.engine.sdk4.services.AssignedTagsService;
import org.ovirt.engine.sdk4.services.DomainUserGroupsService;
import org.ovirt.engine.sdk4.services.EventSubscriptionsService;
import org.ovirt.engine.sdk4.services.SshPublicKeysService;
import org.ovirt.engine.sdk4.services.UserOptionsService;
import org.ovirt.engine.sdk4.services.UserService;
import org.ovirt.engine.sdk4.types.User;

public class UserServiceImpl extends ServiceImpl implements UserService {
    
    public UserServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private String follow;
        public GetRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public GetResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpGet(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    GetResponseImpl actionResponse = new GetResponseImpl();
                    actionResponse.user(XmlUserReader.readOne(reader));
                    return actionResponse;
                }
                catch (IOException ex) {
                    throw new Error("Failed to read response", ex);
                }
                finally {
                    EntityUtils.consumeQuietly(response.getEntity());
                }
            }
            else {
                checkFault(response);
                return new GetResponseImpl();
            }
        }
        
    }
    
    private class GetResponseImpl implements GetResponse {
        private User user;
        
        public void user(User user) {
            this.user = user;
        }
        
        public User user() {
            return user;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpDelete(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
            ) {
                EntityUtils.consumeQuietly(response.getEntity());
                return new RemoveResponseImpl();
            }
            else {
                checkFault(response);
                return new RemoveResponseImpl();
            }
        }
        
    }
    
    private class RemoveResponseImpl implements RemoveResponse {
    }
    
    public RemoveRequest remove() {
        return new RemoveRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private User user;
        public UpdateRequest user(User user) {
            this.user = user;
            return this;
        }
        
        public UpdateRequest user(UserBuilder user) {
            this.user = user.build();
            return this;
        }
        
        public UpdateResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPut(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlUserWriter.writeOne(user, xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to parse response", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    UpdateResponseImpl actionResponse = new UpdateResponseImpl();
                    actionResponse.user(XmlUserReader.readOne(reader));
                    return actionResponse;
                }
                catch (IOException ex) {
                    throw new Error("Failed to read response", ex);
                }
                finally {
                    EntityUtils.consumeQuietly(response.getEntity());
                }
            }
            else {
                checkFault(response);
                return new UpdateResponseImpl();
            }
        }
        
    }
    
    private class UpdateResponseImpl implements UpdateResponse {
        private User user;
        
        public void user(User user) {
            this.user = user;
        }
        
        public User user() {
            return user;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public EventSubscriptionsService eventSubscriptionsService() {
        return new EventSubscriptionsServiceImpl(getConnection(), getPath() + "/eventsubscriptions");
    }
    
    public DomainUserGroupsService groupsService() {
        return new DomainUserGroupsServiceImpl(getConnection(), getPath() + "/groups");
    }
    
    public UserOptionsService optionsService() {
        return new UserOptionsServiceImpl(getConnection(), getPath() + "/options");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public AssignedRolesService rolesService() {
        return new AssignedRolesServiceImpl(getConnection(), getPath() + "/roles");
    }
    
    public SshPublicKeysService sshPublicKeysService() {
        return new SshPublicKeysServiceImpl(getConnection(), getPath() + "/sshpublickeys");
    }
    
    public AssignedTagsService tagsService() {
        return new AssignedTagsServiceImpl(getConnection(), getPath() + "/tags");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("eventsubscriptions")) {
            return eventSubscriptionsService();
        }
        if (path.startsWith("eventsubscriptions/")) {
            return eventSubscriptionsService().service(path.substring(19));
        }
        if (path.equals("groups")) {
            return groupsService();
        }
        if (path.startsWith("groups/")) {
            return groupsService().service(path.substring(7));
        }
        if (path.equals("options")) {
            return optionsService();
        }
        if (path.startsWith("options/")) {
            return optionsService().service(path.substring(8));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("roles")) {
            return rolesService();
        }
        if (path.startsWith("roles/")) {
            return rolesService().service(path.substring(6));
        }
        if (path.equals("sshpublickeys")) {
            return sshPublicKeysService();
        }
        if (path.startsWith("sshpublickeys/")) {
            return sshPublicKeysService().service(path.substring(14));
        }
        if (path.equals("tags")) {
            return tagsService();
        }
        if (path.startsWith("tags/")) {
            return tagsService().service(path.substring(5));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "UserService:" + getPath();
    }
    
}

