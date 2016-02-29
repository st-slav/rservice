package com.test.rs.rsevice;

import com.test.rs.entity.Loc;
<<<<<<< HEAD
import com.test.rs.log.ProducerLogBean;
import com.test.rs.logic.LocLocal;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
=======
import com.test.rs.logic.LocLocal;
import java.io.StringReader;
import java.util.ArrayList;
>>>>>>> 6ba3fe343e2ac176700501225261d648e035d7b5
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public class LocationRest {
    
<<<<<<< HEAD
    @EJB(beanName = "location")
    private LocLocal locLocal;
    
    @EJB
    private ProducerLogBean producerLog;
    
    @POST
    @Path("/saveloc")
    @Consumes(MediaType.TEXT_HTML)
    public void saveClientLocaton(String jPackage){
        locLocal.addLocListFromRestPakage(new LocationRest().convertJsonStringToArrayListLoc(jPackage));
        producerLog.sendMessage(new Date() + " [rservise]: " + jPackage);
    }
    
    public ArrayList<Loc> convertJsonStringToArrayListLoc(String jString){
=======
    @EJB
    private LocLocal locLocal;
    
    @POST
    @Path("/saveloc")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveClientLocaton(String jPakage){
        locLocal.addLocListFromRestPakage(new LocationRest().convertJsonStringToArrayListLoc(jPakage));
    }
    
    private ArrayList<Loc> convertJsonStringToArrayListLoc(String jString){
>>>>>>> 6ba3fe343e2ac176700501225261d648e035d7b5
        JsonReader jReader = Json.createReader(new StringReader(jString));
        JsonArray jArray = jReader.readArray();
        ArrayList<Loc> locs = new ArrayList<Loc>();
        for (int i = 0; i < jArray.size(); i++){
            JsonObject jObject = jArray.getJsonObject(i);
            locs.add(new Loc (
                    (float) jObject.getJsonNumber("latitude").doubleValue(),
                    (float) jObject.getJsonNumber("longitude").doubleValue(),
                    (float) jObject.getJsonNumber("horizontalAccuracy").doubleValue(),
                    (float) jObject.getJsonNumber("speed").doubleValue(),
                    (float) jObject.getJsonNumber("course").doubleValue(),
                    (float) jObject.getJsonNumber("altitude").doubleValue(),
                    (float) jObject.getJsonNumber("verticalAccuracy").doubleValue(),
                    jObject.getString("actuality"),
<<<<<<< HEAD
                    jObject.getJsonNumber("timestamp").bigIntegerValue()));
=======
                    jObject.getJsonNumber("course").bigIntegerValue()));
>>>>>>> 6ba3fe343e2ac176700501225261d648e035d7b5
        }
        return locs;
    }
}
