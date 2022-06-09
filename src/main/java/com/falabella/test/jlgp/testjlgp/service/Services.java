package com.falabella.test.jlgp.testjlgp.service;

import com.falabella.test.jlgp.testjlgp.repository.IStore;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.falabella.test.jlgp.testjlgp.model.Store;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class Services implements IStore {
    static List<Store> getlistExternal() {

        List<Store> resultList = new ArrayList<>();

        String uri = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7&format=json";
        RestTemplate restTemplate = new RestTemplate();
        String rawJson = restTemplate.getForObject(uri, String.class);

        JSONArray stores = new JSONArray(rawJson);

        for (int i = 0; i < stores.length(); i++) {
            JSONObject jsonStore = stores.getJSONObject(i);
            Store store = new Store();
            String communeName = jsonStore.getString("comuna_nombre");
            String storeName = jsonStore.getString("local_nombre");
            String address = jsonStore.getString("local_direccion");
            String phone = jsonStore.getString("local_telefono");
            String latitude = jsonStore.getString("local_lat");
            String longitude = jsonStore.getString("local_lng");
            store.setAddress(address);
            store.setCommuneName(communeName);
            store.setLatitude(latitude);
            store.setLongitude(longitude);
            store.setPhone(phone);
            store.setStoreName(storeName);
            resultList.add(store);
        }
        return resultList;

    }

    private boolean isSameCommune(Store item, String commune){
        return item.getCommuneName().equalsIgnoreCase(commune);
    }

    @Override
    public List<Store> getStores(String commune) {
        List<Store> externalResult = getlistExternal();
        List<Store> result = externalResult.stream().filter(item -> isSameCommune(item,commune)).collect(Collectors.toList());
        return result;
    }
}
