package com.test.rs;

import com.test.rs.entity.Loc;
import com.test.rs.rsevice.LocationRest;
import java.util.ArrayList;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class LocationRestTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void convertJsonStringToArrayListLocTest(){
        String jPackage = "[{\"latitude\":0.0,\"longitude\":0.0,\"horizontalAccuracy\":0,\"speed\":4.0,\"course\":0,"
                + "\"altitude\":0,\"verticalAccuracy\":5,\"actuality\":\"GPS\",\"timestamp\":139333763500},"
                + "{\"latitude\":1.0,\"longitude\":2.0,\"horizontalAccuracy\":3,\"speed\":4.0,\"course\":4,"
                + "\"altitude\":5,\"verticalAccuracy\":5,\"actuality\":\"GPS\",\"timestamp\":139333763500}]";
        LocationRest rs = new LocationRest();
        ArrayList<Loc> loks = rs.convertJsonStringToArrayListLoc(jPackage);
        assertTrue(loks.get(0).toString().equals("latitude: 0.0, longitude: 0.0, horizontalAccuracy: 0.0, speed: 4.0, "
                + "course: 0.0, altitude: 0.0, verticalAccuracy: 5.0, actuality: GPS, timestamp: 139333763500"));
        assertTrue(loks.get(1).toString().equals("latitude: 1.0, longitude: 2.0, horizontalAccuracy: 3.0, speed: 4.0, "
                + "course: 4.0, altitude: 5.0, verticalAccuracy: 5.0, actuality: GPS, timestamp: 139333763500"));
    }    
}
