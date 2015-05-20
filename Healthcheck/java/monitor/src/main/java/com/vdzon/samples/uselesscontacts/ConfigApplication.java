package com.vdzon.samples.uselesscontacts;

import com.vdzon.samples.uselesscontacts.rest.ServerResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/resources")
public class ConfigApplication extends Application {

    @Override
    public java.util.Set<java.lang.Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(ServerResource.class);
        return s;
    }
}
