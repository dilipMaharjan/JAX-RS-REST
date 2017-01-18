/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.resources;

import com.dmaharjan.jaxrs.model.Profile;
import com.dmaharjan.jaxrs.service.ProfileService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dmaharjan
 */
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileServices = new ProfileService();

    @GET
    public List<Profile> getProfiles() {
        return profileServices.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileServices.getProfile(profileName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile) {
        return profileServices.addProfile(profile);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile updateProfile(Profile profile, @PathParam("profileName") String profileName) {
        profile.setProfileName(profileName);
        return profileServices.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile removeProfile(@PathParam("profileName") String profileName) {
        return profileServices.removeProfile(profileName);
    }
}
