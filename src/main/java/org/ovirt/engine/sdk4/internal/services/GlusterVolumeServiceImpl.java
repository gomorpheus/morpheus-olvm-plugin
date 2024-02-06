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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ActionBuilder;
import org.ovirt.engine.sdk4.builders.OptionBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlGlusterVolumeReader;
import org.ovirt.engine.sdk4.services.GlusterBricksService;
import org.ovirt.engine.sdk4.services.GlusterVolumeService;
import org.ovirt.engine.sdk4.services.StatisticsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;
import org.ovirt.engine.sdk4.types.Option;

public class GlusterVolumeServiceImpl extends MeasurableServiceImpl implements GlusterVolumeService {
    
    public GlusterVolumeServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.volume(XmlGlusterVolumeReader.readOne(reader));
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
        private GlusterVolume volume;
        
        public void volume(GlusterVolume volume) {
            this.volume = volume;
        }
        
        public GlusterVolume volume() {
            return volume;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class GetProfileStatisticsRequestImpl extends BaseRequest<GetProfileStatisticsRequest, GetProfileStatisticsResponse> implements GetProfileStatisticsRequest {
        public GetProfileStatisticsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/getprofilestatistics");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            GetProfileStatisticsResponseImpl actionResponse = new GetProfileStatisticsResponseImpl();
            actionResponse.details(action.details());
            return actionResponse;
        }
        
    }
    
    private class GetProfileStatisticsResponseImpl implements GetProfileStatisticsResponse {
        private GlusterVolumeProfileDetails details;
        
        public void details(GlusterVolumeProfileDetails details) {
            this.details = details;
        }
        
        public GlusterVolumeProfileDetails details() {
            return details;
        }
        
    }
    
    public GetProfileStatisticsRequest getProfileStatistics() {
        return new GetProfileStatisticsRequestImpl();
    }
    
    private class RebalanceRequestImpl extends BaseRequest<RebalanceRequest, RebalanceResponse> implements RebalanceRequest {
        private Boolean async;
        public RebalanceRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean fixLayout;
        public RebalanceRequest fixLayout(Boolean fixLayout) {
            this.fixLayout = fixLayout;
            return this;
        }
        
        private Boolean force;
        public RebalanceRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public RebalanceResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/rebalance");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.fixLayout(fixLayout);
                action.force(force);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new RebalanceResponseImpl();
        }
        
    }
    
    private class RebalanceResponseImpl implements RebalanceResponse {
    }
    
    public RebalanceRequest rebalance() {
        return new RebalanceRequestImpl();
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
    
    private class ResetAllOptionsRequestImpl extends BaseRequest<ResetAllOptionsRequest, ResetAllOptionsResponse> implements ResetAllOptionsRequest {
        private Boolean async;
        public ResetAllOptionsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ResetAllOptionsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/resetalloptions");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new ResetAllOptionsResponseImpl();
        }
        
    }
    
    private class ResetAllOptionsResponseImpl implements ResetAllOptionsResponse {
    }
    
    public ResetAllOptionsRequest resetAllOptions() {
        return new ResetAllOptionsRequestImpl();
    }
    
    private class ResetOptionRequestImpl extends BaseRequest<ResetOptionRequest, ResetOptionResponse> implements ResetOptionRequest {
        private Boolean async;
        public ResetOptionRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public ResetOptionRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        private Option option;
        public ResetOptionRequest option(Option option) {
            this.option = option;
            return this;
        }
        
        public ResetOptionRequest option(OptionBuilder option) {
            this.option = option.build();
            return this;
        }
        
        public ResetOptionResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/resetoption");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                action.option(option);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new ResetOptionResponseImpl();
        }
        
    }
    
    private class ResetOptionResponseImpl implements ResetOptionResponse {
    }
    
    public ResetOptionRequest resetOption() {
        return new ResetOptionRequestImpl();
    }
    
    private class SetOptionRequestImpl extends BaseRequest<SetOptionRequest, SetOptionResponse> implements SetOptionRequest {
        private Boolean async;
        public SetOptionRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Option option;
        public SetOptionRequest option(Option option) {
            this.option = option;
            return this;
        }
        
        public SetOptionRequest option(OptionBuilder option) {
            this.option = option.build();
            return this;
        }
        
        public SetOptionResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/setoption");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.option(option);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new SetOptionResponseImpl();
        }
        
    }
    
    private class SetOptionResponseImpl implements SetOptionResponse {
    }
    
    public SetOptionRequest setOption() {
        return new SetOptionRequestImpl();
    }
    
    private class StartRequestImpl extends BaseRequest<StartRequest, StartResponse> implements StartRequest {
        private Boolean async;
        public StartRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public StartRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public StartResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/start");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new StartResponseImpl();
        }
        
    }
    
    private class StartResponseImpl implements StartResponse {
    }
    
    public StartRequest start() {
        return new StartRequestImpl();
    }
    
    private class StartProfileRequestImpl extends BaseRequest<StartProfileRequest, StartProfileResponse> implements StartProfileRequest {
        private Boolean async;
        public StartProfileRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public StartProfileResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/startprofile");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new StartProfileResponseImpl();
        }
        
    }
    
    private class StartProfileResponseImpl implements StartProfileResponse {
    }
    
    public StartProfileRequest startProfile() {
        return new StartProfileRequestImpl();
    }
    
    private class StopRequestImpl extends BaseRequest<StopRequest, StopResponse> implements StopRequest {
        private Boolean async;
        public StopRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public StopRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public StopResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/stop");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new StopResponseImpl();
        }
        
    }
    
    private class StopResponseImpl implements StopResponse {
    }
    
    public StopRequest stop() {
        return new StopRequestImpl();
    }
    
    private class StopProfileRequestImpl extends BaseRequest<StopProfileRequest, StopProfileResponse> implements StopProfileRequest {
        private Boolean async;
        public StopProfileRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public StopProfileResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/stopprofile");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new StopProfileResponseImpl();
        }
        
    }
    
    private class StopProfileResponseImpl implements StopProfileResponse {
    }
    
    public StopProfileRequest stopProfile() {
        return new StopProfileRequestImpl();
    }
    
    private class StopRebalanceRequestImpl extends BaseRequest<StopRebalanceRequest, StopRebalanceResponse> implements StopRebalanceRequest {
        private Boolean async;
        public StopRebalanceRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public StopRebalanceResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/stoprebalance");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new StopRebalanceResponseImpl();
        }
        
    }
    
    private class StopRebalanceResponseImpl implements StopRebalanceResponse {
    }
    
    public StopRebalanceRequest stopRebalance() {
        return new StopRebalanceRequestImpl();
    }
    
    public GlusterBricksService glusterBricksService() {
        return new GlusterBricksServiceImpl(getConnection(), getPath() + "/glusterbricks");
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("glusterbricks")) {
            return glusterBricksService();
        }
        if (path.startsWith("glusterbricks/")) {
            return glusterBricksService().service(path.substring(14));
        }
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "GlusterVolumeService:" + getPath();
    }
    
}

