package com.vdzon.samples.uselesscontacts.model;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.UUID;

public class ServerModel {
    private String server;
    private String status;
    private String color;

    private static ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller

    // the fromString is needed to convert json to object. This is needed for using this object as a PathParam in REST
    public static ServerModel fromString(String jsonRepresentation) throws IOException {
        return mapper.readValue(jsonRepresentation, ServerModel.class );
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
