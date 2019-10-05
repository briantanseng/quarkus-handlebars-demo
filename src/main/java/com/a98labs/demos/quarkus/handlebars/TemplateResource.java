package com.a98labs.demos.quarkus.handlebars;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/resource")
public class TemplateResource {
    
    @Inject
    TemplateService service;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return service.processHandlebarsTemplate();
    }
}