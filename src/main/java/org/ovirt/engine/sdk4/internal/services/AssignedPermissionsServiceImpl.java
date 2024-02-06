/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.PermissionBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlPermissionReader;
import org.ovirt.engine.sdk4.internal.xml.XmlPermissionWriter;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.PermissionService;
import org.ovirt.engine.sdk4.types.Permission;

public class AssignedPermissionsServiceImpl extends ServiceImpl implements AssignedPermissionsService {
    
    public AssignedPermissionsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private Permission permission;
        public AddRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddResponseImpl actionResponse = new AddResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddResponseImpl();
            }
        }
        
    }
    
    private class AddResponseImpl implements AddResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class AddClusterPermissionRequestImpl extends BaseRequest<AddClusterPermissionRequest, AddClusterPermissionResponse> implements AddClusterPermissionRequest {
        private Permission permission;
        public AddClusterPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddClusterPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddClusterPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddClusterPermissionResponseImpl actionResponse = new AddClusterPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddClusterPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddClusterPermissionResponseImpl implements AddClusterPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddClusterPermissionRequest addClusterPermission() {
        return new AddClusterPermissionRequestImpl();
    }
    
    private class AddDataCenterPermissionRequestImpl extends BaseRequest<AddDataCenterPermissionRequest, AddDataCenterPermissionResponse> implements AddDataCenterPermissionRequest {
        private Permission permission;
        public AddDataCenterPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddDataCenterPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddDataCenterPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddDataCenterPermissionResponseImpl actionResponse = new AddDataCenterPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddDataCenterPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddDataCenterPermissionResponseImpl implements AddDataCenterPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddDataCenterPermissionRequest addDataCenterPermission() {
        return new AddDataCenterPermissionRequestImpl();
    }
    
    private class AddGroupLevelRequestImpl extends BaseRequest<AddGroupLevelRequest, AddGroupLevelResponse> implements AddGroupLevelRequest {
        private Permission permission;
        public AddGroupLevelRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddGroupLevelRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddGroupLevelResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddGroupLevelResponseImpl actionResponse = new AddGroupLevelResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddGroupLevelResponseImpl();
            }
        }
        
    }
    
    private class AddGroupLevelResponseImpl implements AddGroupLevelResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddGroupLevelRequest addGroupLevel() {
        return new AddGroupLevelRequestImpl();
    }
    
    private class AddHostPermissionRequestImpl extends BaseRequest<AddHostPermissionRequest, AddHostPermissionResponse> implements AddHostPermissionRequest {
        private Permission permission;
        public AddHostPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddHostPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddHostPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddHostPermissionResponseImpl actionResponse = new AddHostPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddHostPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddHostPermissionResponseImpl implements AddHostPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddHostPermissionRequest addHostPermission() {
        return new AddHostPermissionRequestImpl();
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private String follow;
        public ListRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public ListResponse send() {
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
                    ListResponseImpl actionResponse = new ListResponseImpl();
                    actionResponse.permissions(XmlPermissionReader.readMany(reader));
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
                return new ListResponseImpl();
            }
        }
        
    }
    
    private class ListResponseImpl implements ListResponse {
        private List<Permission> permissions;
        
        public void permissions(List<Permission> permissions) {
            this.permissions = permissions;
        }
        
        public List<Permission> permissions() {
            return permissions;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    private class AddStorageDomainPermissionRequestImpl extends BaseRequest<AddStorageDomainPermissionRequest, AddStorageDomainPermissionResponse> implements AddStorageDomainPermissionRequest {
        private Permission permission;
        public AddStorageDomainPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddStorageDomainPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddStorageDomainPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddStorageDomainPermissionResponseImpl actionResponse = new AddStorageDomainPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddStorageDomainPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddStorageDomainPermissionResponseImpl implements AddStorageDomainPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddStorageDomainPermissionRequest addStorageDomainPermission() {
        return new AddStorageDomainPermissionRequestImpl();
    }
    
    private class AddTemplatePermissionRequestImpl extends BaseRequest<AddTemplatePermissionRequest, AddTemplatePermissionResponse> implements AddTemplatePermissionRequest {
        private Permission permission;
        public AddTemplatePermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddTemplatePermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddTemplatePermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddTemplatePermissionResponseImpl actionResponse = new AddTemplatePermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddTemplatePermissionResponseImpl();
            }
        }
        
    }
    
    private class AddTemplatePermissionResponseImpl implements AddTemplatePermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddTemplatePermissionRequest addTemplatePermission() {
        return new AddTemplatePermissionRequestImpl();
    }
    
    private class AddUserLevelRequestImpl extends BaseRequest<AddUserLevelRequest, AddUserLevelResponse> implements AddUserLevelRequest {
        private Permission permission;
        public AddUserLevelRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddUserLevelRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddUserLevelResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddUserLevelResponseImpl actionResponse = new AddUserLevelResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddUserLevelResponseImpl();
            }
        }
        
    }
    
    private class AddUserLevelResponseImpl implements AddUserLevelResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddUserLevelRequest addUserLevel() {
        return new AddUserLevelRequestImpl();
    }
    
    private class AddVmPermissionRequestImpl extends BaseRequest<AddVmPermissionRequest, AddVmPermissionResponse> implements AddVmPermissionRequest {
        private Permission permission;
        public AddVmPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddVmPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddVmPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddVmPermissionResponseImpl actionResponse = new AddVmPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddVmPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddVmPermissionResponseImpl implements AddVmPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddVmPermissionRequest addVmPermission() {
        return new AddVmPermissionRequestImpl();
    }
    
    private class AddVmPoolPermissionRequestImpl extends BaseRequest<AddVmPoolPermissionRequest, AddVmPoolPermissionResponse> implements AddVmPoolPermissionRequest {
        private Permission permission;
        public AddVmPoolPermissionRequest permission(Permission permission) {
            this.permission = permission;
            return this;
        }
        
        public AddVmPoolPermissionRequest permission(PermissionBuilder permission) {
            this.permission = permission.build();
            return this;
        }
        
        public AddVmPoolPermissionResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlPermissionWriter.writeOne(permission, xmlWriter);
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddVmPoolPermissionResponseImpl actionResponse = new AddVmPoolPermissionResponseImpl();
                    actionResponse.permission(XmlPermissionReader.readOne(reader));
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
                return new AddVmPoolPermissionResponseImpl();
            }
        }
        
    }
    
    private class AddVmPoolPermissionResponseImpl implements AddVmPoolPermissionResponse {
        private Permission permission;
        
        public void permission(Permission permission) {
            this.permission = permission;
        }
        
        public Permission permission() {
            return permission;
        }
        
    }
    
    public AddVmPoolPermissionRequest addVmPoolPermission() {
        return new AddVmPoolPermissionRequestImpl();
    }
    
    public PermissionService permissionService(String id) {
        return new PermissionServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return permissionService(path);
        }
        return permissionService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "AssignedPermissionsService:" + getPath();
    }
    
}

