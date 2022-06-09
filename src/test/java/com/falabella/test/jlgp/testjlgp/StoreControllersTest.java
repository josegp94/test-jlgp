package com.falabella.test.jlgp.testjlgp;

import com.falabella.test.jlgp.testjlgp.controllers.Controllers;
import com.falabella.test.jlgp.testjlgp.service.Services;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class StoreControllersTest {

    @Test
    void testControllergetStores() throws IOException {
        Controllers controller = new Controllers();
        Services services = new Services();
        assertNotNull(services.getStores("MACUL"));
        assertNotNull(controller.getStoresEndPoint("asd"));
    }
}
