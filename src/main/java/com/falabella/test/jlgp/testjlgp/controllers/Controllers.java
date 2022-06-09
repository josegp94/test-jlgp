package com.falabella.test.jlgp.testjlgp.controllers;

import com.falabella.test.jlgp.testjlgp.model.Store;
import com.falabella.test.jlgp.testjlgp.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("stores")
public class Controllers {

    @Autowired
    Services services;

    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Store> getStoresEndPoint(@PathParam(value = "commune") String commune) {

        List<Store> stores;
        try {
            stores = services.getStores(commune);
        } catch (NullPointerException e) {
            stores = null;
        }

        return stores != null && stores.size() > 0 ? stores : Collections.emptyList();
    }
}
