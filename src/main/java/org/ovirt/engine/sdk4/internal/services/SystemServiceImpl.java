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
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlApiReader;
import org.ovirt.engine.sdk4.services.AffinityLabelsService;
import org.ovirt.engine.sdk4.services.BookmarksService;
import org.ovirt.engine.sdk4.services.ClusterLevelsService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.CpuProfilesService;
import org.ovirt.engine.sdk4.services.DataCentersService;
import org.ovirt.engine.sdk4.services.DiskProfilesService;
import org.ovirt.engine.sdk4.services.DisksService;
import org.ovirt.engine.sdk4.services.DomainsService;
import org.ovirt.engine.sdk4.services.EngineKatelloErrataService;
import org.ovirt.engine.sdk4.services.EventsService;
import org.ovirt.engine.sdk4.services.ExternalHostProvidersService;
import org.ovirt.engine.sdk4.services.ExternalTemplateImportsService;
import org.ovirt.engine.sdk4.services.ExternalVmImportsService;
import org.ovirt.engine.sdk4.services.GroupsService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.services.IconsService;
import org.ovirt.engine.sdk4.services.ImageTransfersService;
import org.ovirt.engine.sdk4.services.InstanceTypesService;
import org.ovirt.engine.sdk4.services.JobsService;
import org.ovirt.engine.sdk4.services.MacPoolsService;
import org.ovirt.engine.sdk4.services.NetworkFiltersService;
import org.ovirt.engine.sdk4.services.NetworksService;
import org.ovirt.engine.sdk4.services.OpenstackImageProvidersService;
import org.ovirt.engine.sdk4.services.OpenstackNetworkProvidersService;
import org.ovirt.engine.sdk4.services.OpenstackVolumeProvidersService;
import org.ovirt.engine.sdk4.services.OperatingSystemsService;
import org.ovirt.engine.sdk4.services.RolesService;
import org.ovirt.engine.sdk4.services.SchedulingPoliciesService;
import org.ovirt.engine.sdk4.services.SchedulingPolicyUnitsService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.StorageServerConnectionsService;
import org.ovirt.engine.sdk4.services.SystemOptionsService;
import org.ovirt.engine.sdk4.services.SystemPermissionsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.TagsService;
import org.ovirt.engine.sdk4.services.TemplatesService;
import org.ovirt.engine.sdk4.services.UsersService;
import org.ovirt.engine.sdk4.services.VmPoolsService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.services.VnicProfilesService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Api;

public class SystemServiceImpl extends ServiceImpl implements SystemService {
    
    public SystemServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.api(XmlApiReader.readOne(reader));
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
        private Api api;
        
        public void api(Api api) {
            this.api = api;
        }
        
        public Api api() {
            return api;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class ReloadConfigurationsRequestImpl extends BaseRequest<ReloadConfigurationsRequest, ReloadConfigurationsResponse> implements ReloadConfigurationsRequest {
        private Boolean async;
        public ReloadConfigurationsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ReloadConfigurationsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reloadconfigurations");
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
            return new ReloadConfigurationsResponseImpl();
        }
        
    }
    
    private class ReloadConfigurationsResponseImpl implements ReloadConfigurationsResponse {
    }
    
    public ReloadConfigurationsRequest reloadConfigurations() {
        return new ReloadConfigurationsRequestImpl();
    }
    
    public AffinityLabelsService affinityLabelsService() {
        return new AffinityLabelsServiceImpl(getConnection(), getPath() + "/affinitylabels");
    }
    
    public BookmarksService bookmarksService() {
        return new BookmarksServiceImpl(getConnection(), getPath() + "/bookmarks");
    }
    
    public ClusterLevelsService clusterLevelsService() {
        return new ClusterLevelsServiceImpl(getConnection(), getPath() + "/clusterlevels");
    }
    
    public ClustersService clustersService() {
        return new ClustersServiceImpl(getConnection(), getPath() + "/clusters");
    }
    
    public CpuProfilesService cpuProfilesService() {
        return new CpuProfilesServiceImpl(getConnection(), getPath() + "/cpuprofiles");
    }
    
    public DataCentersService dataCentersService() {
        return new DataCentersServiceImpl(getConnection(), getPath() + "/datacenters");
    }
    
    public DiskProfilesService diskProfilesService() {
        return new DiskProfilesServiceImpl(getConnection(), getPath() + "/diskprofiles");
    }
    
    public DisksService disksService() {
        return new DisksServiceImpl(getConnection(), getPath() + "/disks");
    }
    
    public DomainsService domainsService() {
        return new DomainsServiceImpl(getConnection(), getPath() + "/domains");
    }
    
    public EventsService eventsService() {
        return new EventsServiceImpl(getConnection(), getPath() + "/events");
    }
    
    public ExternalHostProvidersService externalHostProvidersService() {
        return new ExternalHostProvidersServiceImpl(getConnection(), getPath() + "/externalhostproviders");
    }
    
    public ExternalTemplateImportsService externalTemplateImportsService() {
        return new ExternalTemplateImportsServiceImpl(getConnection(), getPath() + "/externaltemplateimports");
    }
    
    public ExternalVmImportsService externalVmImportsService() {
        return new ExternalVmImportsServiceImpl(getConnection(), getPath() + "/externalvmimports");
    }
    
    public GroupsService groupsService() {
        return new GroupsServiceImpl(getConnection(), getPath() + "/groups");
    }
    
    public HostsService hostsService() {
        return new HostsServiceImpl(getConnection(), getPath() + "/hosts");
    }
    
    public IconsService iconsService() {
        return new IconsServiceImpl(getConnection(), getPath() + "/icons");
    }
    
    public ImageTransfersService imageTransfersService() {
        return new ImageTransfersServiceImpl(getConnection(), getPath() + "/imagetransfers");
    }
    
    public InstanceTypesService instanceTypesService() {
        return new InstanceTypesServiceImpl(getConnection(), getPath() + "/instancetypes");
    }
    
    public JobsService jobsService() {
        return new JobsServiceImpl(getConnection(), getPath() + "/jobs");
    }
    
    public EngineKatelloErrataService katelloErrataService() {
        return new EngineKatelloErrataServiceImpl(getConnection(), getPath() + "/katelloerrata");
    }
    
    public MacPoolsService macPoolsService() {
        return new MacPoolsServiceImpl(getConnection(), getPath() + "/macpools");
    }
    
    public NetworkFiltersService networkFiltersService() {
        return new NetworkFiltersServiceImpl(getConnection(), getPath() + "/networkfilters");
    }
    
    public NetworksService networksService() {
        return new NetworksServiceImpl(getConnection(), getPath() + "/networks");
    }
    
    public OpenstackImageProvidersService openstackImageProvidersService() {
        return new OpenstackImageProvidersServiceImpl(getConnection(), getPath() + "/openstackimageproviders");
    }
    
    public OpenstackNetworkProvidersService openstackNetworkProvidersService() {
        return new OpenstackNetworkProvidersServiceImpl(getConnection(), getPath() + "/openstacknetworkproviders");
    }
    
    public OpenstackVolumeProvidersService openstackVolumeProvidersService() {
        return new OpenstackVolumeProvidersServiceImpl(getConnection(), getPath() + "/openstackvolumeproviders");
    }
    
    public OperatingSystemsService operatingSystemsService() {
        return new OperatingSystemsServiceImpl(getConnection(), getPath() + "/operatingsystems");
    }
    
    public SystemOptionsService optionsService() {
        return new SystemOptionsServiceImpl(getConnection(), getPath() + "/options");
    }
    
    public SystemPermissionsService permissionsService() {
        return new SystemPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public RolesService rolesService() {
        return new RolesServiceImpl(getConnection(), getPath() + "/roles");
    }
    
    public SchedulingPoliciesService schedulingPoliciesService() {
        return new SchedulingPoliciesServiceImpl(getConnection(), getPath() + "/schedulingpolicies");
    }
    
    public SchedulingPolicyUnitsService schedulingPolicyUnitsService() {
        return new SchedulingPolicyUnitsServiceImpl(getConnection(), getPath() + "/schedulingpolicyunits");
    }
    
    public StorageServerConnectionsService storageConnectionsService() {
        return new StorageServerConnectionsServiceImpl(getConnection(), getPath() + "/storageconnections");
    }
    
    public StorageDomainsService storageDomainsService() {
        return new StorageDomainsServiceImpl(getConnection(), getPath() + "/storagedomains");
    }
    
    public TagsService tagsService() {
        return new TagsServiceImpl(getConnection(), getPath() + "/tags");
    }
    
    public TemplatesService templatesService() {
        return new TemplatesServiceImpl(getConnection(), getPath() + "/templates");
    }
    
    public UsersService usersService() {
        return new UsersServiceImpl(getConnection(), getPath() + "/users");
    }
    
    public VmPoolsService vmPoolsService() {
        return new VmPoolsServiceImpl(getConnection(), getPath() + "/vmpools");
    }
    
    public VmsService vmsService() {
        return new VmsServiceImpl(getConnection(), getPath() + "/vms");
    }
    
    public VnicProfilesService vnicProfilesService() {
        return new VnicProfilesServiceImpl(getConnection(), getPath() + "/vnicprofiles");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("affinitylabels")) {
            return affinityLabelsService();
        }
        if (path.startsWith("affinitylabels/")) {
            return affinityLabelsService().service(path.substring(15));
        }
        if (path.equals("bookmarks")) {
            return bookmarksService();
        }
        if (path.startsWith("bookmarks/")) {
            return bookmarksService().service(path.substring(10));
        }
        if (path.equals("clusterlevels")) {
            return clusterLevelsService();
        }
        if (path.startsWith("clusterlevels/")) {
            return clusterLevelsService().service(path.substring(14));
        }
        if (path.equals("clusters")) {
            return clustersService();
        }
        if (path.startsWith("clusters/")) {
            return clustersService().service(path.substring(9));
        }
        if (path.equals("cpuprofiles")) {
            return cpuProfilesService();
        }
        if (path.startsWith("cpuprofiles/")) {
            return cpuProfilesService().service(path.substring(12));
        }
        if (path.equals("datacenters")) {
            return dataCentersService();
        }
        if (path.startsWith("datacenters/")) {
            return dataCentersService().service(path.substring(12));
        }
        if (path.equals("diskprofiles")) {
            return diskProfilesService();
        }
        if (path.startsWith("diskprofiles/")) {
            return diskProfilesService().service(path.substring(13));
        }
        if (path.equals("disks")) {
            return disksService();
        }
        if (path.startsWith("disks/")) {
            return disksService().service(path.substring(6));
        }
        if (path.equals("domains")) {
            return domainsService();
        }
        if (path.startsWith("domains/")) {
            return domainsService().service(path.substring(8));
        }
        if (path.equals("events")) {
            return eventsService();
        }
        if (path.startsWith("events/")) {
            return eventsService().service(path.substring(7));
        }
        if (path.equals("externalhostproviders")) {
            return externalHostProvidersService();
        }
        if (path.startsWith("externalhostproviders/")) {
            return externalHostProvidersService().service(path.substring(22));
        }
        if (path.equals("externaltemplateimports")) {
            return externalTemplateImportsService();
        }
        if (path.startsWith("externaltemplateimports/")) {
            return externalTemplateImportsService().service(path.substring(24));
        }
        if (path.equals("externalvmimports")) {
            return externalVmImportsService();
        }
        if (path.startsWith("externalvmimports/")) {
            return externalVmImportsService().service(path.substring(18));
        }
        if (path.equals("groups")) {
            return groupsService();
        }
        if (path.startsWith("groups/")) {
            return groupsService().service(path.substring(7));
        }
        if (path.equals("hosts")) {
            return hostsService();
        }
        if (path.startsWith("hosts/")) {
            return hostsService().service(path.substring(6));
        }
        if (path.equals("icons")) {
            return iconsService();
        }
        if (path.startsWith("icons/")) {
            return iconsService().service(path.substring(6));
        }
        if (path.equals("imagetransfers")) {
            return imageTransfersService();
        }
        if (path.startsWith("imagetransfers/")) {
            return imageTransfersService().service(path.substring(15));
        }
        if (path.equals("instancetypes")) {
            return instanceTypesService();
        }
        if (path.startsWith("instancetypes/")) {
            return instanceTypesService().service(path.substring(14));
        }
        if (path.equals("jobs")) {
            return jobsService();
        }
        if (path.startsWith("jobs/")) {
            return jobsService().service(path.substring(5));
        }
        if (path.equals("katelloerrata")) {
            return katelloErrataService();
        }
        if (path.startsWith("katelloerrata/")) {
            return katelloErrataService().service(path.substring(14));
        }
        if (path.equals("macpools")) {
            return macPoolsService();
        }
        if (path.startsWith("macpools/")) {
            return macPoolsService().service(path.substring(9));
        }
        if (path.equals("networkfilters")) {
            return networkFiltersService();
        }
        if (path.startsWith("networkfilters/")) {
            return networkFiltersService().service(path.substring(15));
        }
        if (path.equals("networks")) {
            return networksService();
        }
        if (path.startsWith("networks/")) {
            return networksService().service(path.substring(9));
        }
        if (path.equals("openstackimageproviders")) {
            return openstackImageProvidersService();
        }
        if (path.startsWith("openstackimageproviders/")) {
            return openstackImageProvidersService().service(path.substring(24));
        }
        if (path.equals("openstacknetworkproviders")) {
            return openstackNetworkProvidersService();
        }
        if (path.startsWith("openstacknetworkproviders/")) {
            return openstackNetworkProvidersService().service(path.substring(26));
        }
        if (path.equals("openstackvolumeproviders")) {
            return openstackVolumeProvidersService();
        }
        if (path.startsWith("openstackvolumeproviders/")) {
            return openstackVolumeProvidersService().service(path.substring(25));
        }
        if (path.equals("operatingsystems")) {
            return operatingSystemsService();
        }
        if (path.startsWith("operatingsystems/")) {
            return operatingSystemsService().service(path.substring(17));
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
        if (path.equals("schedulingpolicies")) {
            return schedulingPoliciesService();
        }
        if (path.startsWith("schedulingpolicies/")) {
            return schedulingPoliciesService().service(path.substring(19));
        }
        if (path.equals("schedulingpolicyunits")) {
            return schedulingPolicyUnitsService();
        }
        if (path.startsWith("schedulingpolicyunits/")) {
            return schedulingPolicyUnitsService().service(path.substring(22));
        }
        if (path.equals("storageconnections")) {
            return storageConnectionsService();
        }
        if (path.startsWith("storageconnections/")) {
            return storageConnectionsService().service(path.substring(19));
        }
        if (path.equals("storagedomains")) {
            return storageDomainsService();
        }
        if (path.startsWith("storagedomains/")) {
            return storageDomainsService().service(path.substring(15));
        }
        if (path.equals("tags")) {
            return tagsService();
        }
        if (path.startsWith("tags/")) {
            return tagsService().service(path.substring(5));
        }
        if (path.equals("templates")) {
            return templatesService();
        }
        if (path.startsWith("templates/")) {
            return templatesService().service(path.substring(10));
        }
        if (path.equals("users")) {
            return usersService();
        }
        if (path.startsWith("users/")) {
            return usersService().service(path.substring(6));
        }
        if (path.equals("vmpools")) {
            return vmPoolsService();
        }
        if (path.startsWith("vmpools/")) {
            return vmPoolsService().service(path.substring(8));
        }
        if (path.equals("vms")) {
            return vmsService();
        }
        if (path.startsWith("vms/")) {
            return vmsService().service(path.substring(4));
        }
        if (path.equals("vnicprofiles")) {
            return vnicProfilesService();
        }
        if (path.startsWith("vnicprofiles/")) {
            return vnicProfilesService().service(path.substring(13));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "SystemService:" + getPath();
    }
    
}

