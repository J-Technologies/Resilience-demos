package com.vdzon.samples.uselesscontacts.rest;

import com.vdzon.samples.uselesscontacts.model.ServerModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HaProxyApi {

    private static final String URL = "http://haproxy:81/";

    public static List<ServerModel> getStatus() {
        List<ServerModel> serverModels = new ArrayList<ServerModel>();
        try {
            List<String> serversToFind = getServersToFind();
            Document doc = Jsoup.connect(URL).get();
            Elements newsHeadlines = doc.select("#tbl");
            Element table = doc.select("table[class=tbl]").get(3);
            Elements trs = table.select("tr");
            for (Element tr : trs) {
                for (String server : serversToFind) {
                    if (tr.toString().contains(server)) {
                        serverModels.add(getServerModel(tr,server));
                    }
                }
            }
        } catch (IOException ex) {
            //oeps!
        }
        return serverModels;
    }

    public static List<String> getServersToFind() {
        List<String> servers = new ArrayList<String>();
        servers.add("apache1");
        servers.add("apache2");
        return servers;
    }

    private static ServerModel getServerModel(Element tr, String server) {
        ServerModel serverModel = new ServerModel();
        serverModel.setServer(server);
        serverModel.setStatus(tr.className());
        serverModel.setColor("LightGray");
        if (tr.className().equals("active4")) {
            serverModel.setColor("LightGreen");
            serverModel.setStatus("Running");
        }
        if (tr.className().equals("active0")) {
            serverModel.setColor("#F78181");
            serverModel.setStatus("Down");
        }
        if (tr.className().equals("active3")) {
            serverModel.setColor("LightGray");
            serverModel.setStatus("Going down");
        }
        if (tr.className().equals("active1")) {
            serverModel.setColor("LightGray");
            serverModel.setStatus("Starting up");
        }
        return serverModel;
    }


}
