/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author dmaharjan
 */
@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectResource {

    @GET
    public String injection(@MatrixParam("matrixParam") String matrixParam, @HeaderParam("headerParam") String headerParam, @CookieParam("cookie") String cookieName) {
        return "Matrix Param : " + matrixParam + "Header Param : " + headerParam + "Cookie Name " + cookieName;
    }

    @GET
    @Path("context")
    public String getContextParameters(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        return "URI info : " + uriInfo.getAbsolutePath() + "Http Headers : " + httpHeaders.getAcceptableMediaTypes();
    }
}
