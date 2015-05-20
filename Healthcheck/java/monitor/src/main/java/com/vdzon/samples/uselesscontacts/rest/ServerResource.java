package com.vdzon.samples.uselesscontacts.rest;

import com.vdzon.samples.uselesscontacts.model.ServerModel;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/servers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServerResource {

    private static final String URL = "http://haproxy:81/";


    @GET
    @Path("getservers")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServers(@Context HttpHeaders headers) {
        return Response.accepted(HaProxyApi.getStatus()).build();
    }

}
