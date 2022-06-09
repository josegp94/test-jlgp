package com.falabella.test.jlgp.testjlgp.repository;

import com.falabella.test.jlgp.testjlgp.model.Store;
import java.util.List;

public interface IStore {

    List<Store> getStores(String commune);
}
